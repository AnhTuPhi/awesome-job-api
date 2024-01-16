package vn.com.tech.awesome.job.api.connector.feign;

import feign.Response;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:37 AM - Wednesday
 * @project : awesome-job-api
 **/
public interface FeignHttpExceptionHandler {
    Exception handle(Response response);
}
