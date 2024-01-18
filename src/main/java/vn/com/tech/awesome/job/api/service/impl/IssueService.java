package vn.com.tech.awesome.job.api.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import vn.com.tech.awesome.job.api.connector.feign.github.GithubConnector;
import vn.com.tech.awesome.job.api.connector.feign.github.GithubHeaderConfig;
import vn.com.tech.awesome.job.api.model.dto.CommonQuery;
import vn.com.tech.awesome.job.api.model.dto.GithubQuery;
import vn.com.tech.awesome.job.api.model.dto.response.CommentResponse;
import vn.com.tech.awesome.job.api.model.dto.response.IssueResponse;
import vn.com.tech.awesome.job.api.model.entity.Issue;
import vn.com.tech.awesome.job.api.repository.IssueRepository;
import vn.com.tech.awesome.job.api.service.common.CommonService;

import java.util.List;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 10:56 PM - Wednesday
 * @project : awesome-job-api
 **/
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class IssueService extends CommonService<Issue, String, IssueRepository> {

    private final static Logger logger = LoggerFactory.getLogger(IssueService.class);

    @Override
    protected String notFoundMessage() {
        return "NOT FOUND ISSUES";
    }

    private String owner;
    private String repo;
    GithubConnector githubConnector;

    public IssueService(IssueRepository repository,
                        @Value("${github.awesome-job.owner}") String owner,
                        @Value("${github.awesome-job.repo}") String repo,
                        GithubConnector githubConnector) {
        super(repository);
        this.owner = owner;
        this.repo = repo;
        this.githubConnector = githubConnector;
    }

    public List<IssueResponse> getIssues(GithubQuery query) {
        return githubConnector.getIssues(GithubHeaderConfig.defaultHeaders(), owner, repo,
                query.getPage(), query.getPageSize(), query.getState(), query.getSort(), query.getSince());
    }

    public List<CommentResponse> getComments(Long issueId) {
        return githubConnector.getCommentsOfIssue(owner, repo, issueId, "created");
    }
}
