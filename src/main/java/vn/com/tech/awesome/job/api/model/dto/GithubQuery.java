package vn.com.tech.awesome.job.api.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Admin
 * @created 18/01/2024 - 2:00 PM
 * @project awesome-job-api
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GithubQuery extends CommonQuery {
    String state;
    String sort;
    String since;
}
