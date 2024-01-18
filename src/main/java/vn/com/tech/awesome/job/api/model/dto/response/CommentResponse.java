package vn.com.tech.awesome.job.api.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Admin
 * @created 18/01/2024 - 2:31 PM
 * @project awesome-job-api
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentResponse {
    Long id;

    @JsonProperty("node_id")
    String nodeId;

    @JsonProperty("html_url")
    String htmlUrl;

    UserResponse user;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("updated_at")
    String updatedAt;

    String body;
}
