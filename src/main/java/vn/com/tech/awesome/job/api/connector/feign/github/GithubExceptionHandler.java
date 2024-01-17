package vn.com.tech.awesome.job.api.connector.feign.github;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vn.com.tech.awesome.job.api.connector.feign.FeignHttpExceptionHandler;
import vn.com.tech.awesome.job.api.util.JsonMapper;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 11:05 PM - Wednesday
 * @project : awesome-job-api
 **/
@Component
@Slf4j
public class GithubExceptionHandler implements FeignHttpExceptionHandler {

    @Override
    public Exception handle(Response response) {
        log.error(JsonMapper.write(response));
        return new Exception("GOT ERROR GITHUB");
    }
}
