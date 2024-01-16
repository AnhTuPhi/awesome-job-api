package vn.com.tech.awesome.job.api.connector.feign.github;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:38 AM - Wednesday
 * @project : awesome-job-api
 **/
@FeignClient(name = "github", url = "${github.restapi}")
public interface GithubConnector {

    @GetMapping("/repos/{owner}/{repo}/issues")
    Object getIssues(@PathVariable("owner") String owner,
                     @PathVariable("repo") String repo,
                     @RequestParam("per_page") Integer perPage,
                     @RequestParam("page") Integer page,
                     @RequestParam("state") String state,
                     @RequestParam("sort") String sort,
                     @RequestParam("since") String since);
}
