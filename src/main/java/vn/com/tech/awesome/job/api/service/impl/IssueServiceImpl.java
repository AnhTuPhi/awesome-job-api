package vn.com.tech.awesome.job.api.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.com.tech.awesome.job.api.connector.feign.github.GithubConnector;
import vn.com.tech.awesome.job.api.connector.feign.github.GithubHeaderConfig;
import vn.com.tech.awesome.job.api.service.IssueService;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 10:56 PM - Wednesday
 * @project : awesome-job-api
 **/
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class IssueServiceImpl implements IssueService {

    private String owner;
    private String repo;
    GithubConnector githubConnector;

    public IssueServiceImpl(@Value("${github.awesome-job.owner}") String owner,
                            @Value("${github.awesome-job.repo}") String repo,
                            GithubConnector githubConnector) {
        this.owner = owner;
        this.repo = repo;
        this.githubConnector = githubConnector;
    }

    @Override
    public Object getIssues() {
        return githubConnector.getIssues(GithubHeaderConfig.defaultHeaders(), owner, repo, 0, 2, null, null, null);
    }
}
