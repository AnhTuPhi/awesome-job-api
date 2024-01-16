package vn.com.tech.awesome.job.api.connector.feign.github;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:38 AM - Wednesday
 * @project : awesome-job-api
 **/
@FeignClient(name = "github", url = "${github.restapi}")
public interface GithubConnector {
}
