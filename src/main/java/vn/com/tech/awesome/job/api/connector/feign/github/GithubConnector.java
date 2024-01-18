package vn.com.tech.awesome.job.api.connector.feign.github;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.tech.awesome.job.api.connector.feign.HandleFeignError;
import vn.com.tech.awesome.job.api.model.dto.response.CommentResponse;
import vn.com.tech.awesome.job.api.model.dto.response.IssueResponse;

import java.util.List;
import java.util.Map;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:38 AM - Wednesday
 * @project : awesome-job-api
 **/
@HandleFeignError(GithubExceptionHandler.class)
@FeignClient(name = "github", url = "${github.restapi}")
public interface GithubConnector {

    @GetMapping("/repos/{owner}/{repo}/issues")
    List<IssueResponse> getIssues(@RequestHeader Map<String, String> headers,
                                  @PathVariable("owner") String owner,
                                  @PathVariable("repo") String repo,
                                  @RequestParam("page") Integer page,
                                  @RequestParam("per_page") Integer perPage,
                                  @RequestParam("state") String state,
                                  @RequestParam("sort") String sort,
                                  @RequestParam("since") String since);

    @GetMapping("/repos/{owner}/{repo}/issues/{id}/comments")
    List<CommentResponse> getCommentsOfIssue(@PathVariable("owner") String owner,
                                             @PathVariable("repo") String repo,
                                             @PathVariable("id") Long id,
                                             @RequestParam("sort") String sort);
}
