package vn.com.tech.awesome.job.api.connector.feign;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:37 AM - Wednesday
 * @project : awesome-job-api
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HandleFeignError {
    Class<? extends FeignHttpExceptionHandler> value();
}

