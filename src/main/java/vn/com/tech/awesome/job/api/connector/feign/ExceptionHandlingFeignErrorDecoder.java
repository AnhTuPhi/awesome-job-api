package vn.com.tech.awesome.job.api.connector.feign;

import feign.Feign;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:37 AM - Wednesday
 * @project : awesome-job-api
 **/
@Component
@RequiredArgsConstructor
public class ExceptionHandlingFeignErrorDecoder implements ErrorDecoder {

    private final ApplicationContext applicationContext;
    private final ErrorDecoder.Default defaultErrorDecoder = new Default();
    private final Map<String, FeignHttpExceptionHandler> exceptionHandlerMap = new HashMap<>();

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        var feignClients = applicationContext.getBeansWithAnnotation(FeignClient.class);
        var clientMethods = feignClients.values().stream()
                .map(Object::getClass)
                .map(aClass -> aClass.getInterfaces()[0])
                .map(ReflectionUtils::getDeclaredMethods)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        for (var m : clientMethods) {
            var configKey = Feign.configKey(m.getDeclaringClass(), m);
            var handlerAnnotation = getHandleFeignErrorAnnotation(m);
            if (handlerAnnotation != null) {
                FeignHttpExceptionHandler handler = applicationContext.getBean(handlerAnnotation.value());
                exceptionHandlerMap.put(configKey, handler);
            }
        }
    }
    private HandleFeignError getHandleFeignErrorAnnotation(Method m) {
        var result = m.getAnnotation(HandleFeignError.class);
        if (result == null) {
            result = m.getDeclaringClass().getAnnotation(HandleFeignError.class);
        }
        return result;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        var handler = exceptionHandlerMap.get(methodKey);
        if (handler != null) {
            return handler.handle(response);
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
