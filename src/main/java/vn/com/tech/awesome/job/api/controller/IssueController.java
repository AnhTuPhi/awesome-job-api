package vn.com.tech.awesome.job.api.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.tech.awesome.job.api.service.IssueService;

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
    public Object getIssues() {
        return service.getIssues();
    }
}
