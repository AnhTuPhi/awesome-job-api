package vn.com.tech.awesome.job.api.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;

/**
 * @author Admin
 * @created 18/01/2024 - 10:55 AM
 * @project awesome-job-api
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonQuery {
    Long id;
    @Min(value = 1L, message = "number-page-invalid")
    Integer page = 1;
    @Min(value = 1L, message = "page-size-invalid")
    Integer pageSize = 20;
}
