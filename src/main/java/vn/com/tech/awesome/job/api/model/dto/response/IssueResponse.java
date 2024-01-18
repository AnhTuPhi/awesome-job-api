package vn.com.tech.awesome.job.api.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.com.tech.awesome.job.api.model.enumeration.GithubState;

/**
 * @author Admin
 * @created 18/01/2024 - 10:38 AM
 * @project awesome-job-api
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IssueResponse {
    Long id;

    @JsonProperty("node_id")
    String nodeId;

    Long number;

    GithubState state;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("updated_at")
    String updatedAt;

    String title;

    String body;

    @JsonProperty("html_url")
    String htmlUrl;

    UserResponse user;

}
