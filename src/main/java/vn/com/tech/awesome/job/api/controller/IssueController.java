package vn.com.tech.awesome.job.api.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import vn.com.tech.awesome.job.api.model.dto.CommonQuery;
import vn.com.tech.awesome.job.api.model.dto.GithubQuery;
import vn.com.tech.awesome.job.api.model.dto.response.CommentResponse;
import vn.com.tech.awesome.job.api.model.dto.response.IssueResponse;
import vn.com.tech.awesome.job.api.service.impl.IssueService;

import java.util.List;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:27 AM - Wednesday
 * @project : awesome-job-api
 **/
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping(path = "/issues")
public class IssueController {

    IssueService service;

    @GetMapping
    public List<IssueResponse> getIssues(@ModelAttribute GithubQuery query) {
        return service.getIssues(query);
    }

    @GetMapping("/{id}/comments")
    public List<CommentResponse> getComments(@PathVariable("id") Long issueId) {
        return service.getComments(issueId);
    }
}
