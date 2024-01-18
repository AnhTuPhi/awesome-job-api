package vn.com.tech.awesome.job.api.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Admin
 * @created 18/01/2024 - 10:40 AM
 * @project awesome-job-api
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String login;
    Long id;

    @JsonProperty("node_id")
    String nodeId;

    @JsonProperty("avatar_url")
    String avatarUrl;

    @JsonProperty("html_url")
    String htmlUrl;

    @JsonProperty("repos_url")
    String repoUrl;

    @JsonProperty("starred_url")
    String starUrl;

    String type;
}
