package vn.com.tech.awesome.job.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
import vn.com.tech.awesome.job.api.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:25 AM - Wednesday
 * @project : awesome-job-api
 **/
@Configuration
public class WebConfiguration {

    @Slf4j
    @ControllerAdvice
    public static class CustomRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {
        private final HttpServletRequest httpServletRequest;

        public CustomRequestBodyAdviceAdapter(HttpServletRequest httpServletRequest) {
            this.httpServletRequest = httpServletRequest;
        }

        @Override
        public boolean supports(MethodParameter methodParameter, Type type,
                                Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
                                    MethodParameter parameter, Type targetType,
                                    Class<? extends HttpMessageConverter<?>> converterType) {
            log.info("Request URL: " + httpServletRequest.getRequestURL() + " - Request Body: " + JsonMapper.write(body));
            return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
        }
    }
}
