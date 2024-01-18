package vn.com.tech.awesome.job.api.repository;

import org.springframework.stereotype.Repository;
import vn.com.tech.awesome.job.api.model.entity.Issue;

/**
 * @author Admin
 * @created 18/01/2024 - 12:20 PM
 * @project awesome-job-api
 */
@Repository
public interface IssueRepository extends CommonRepository<Issue, String> {

    Issue getById(String id);
}
