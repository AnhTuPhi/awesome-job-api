package vn.com.tech.awesome.job.api.connector.feign.github;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 10:52 PM - Wednesday
 * @project : awesome-job-api
 **/
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GithubHeaderConfig {

    public static Map<String, String> defaultHeaders(){
        Map<String, String> mapper = new HashMap<>(2);
        mapper.put("Accept", "application/vnd.github+json");
        mapper.put("X-GitHub-Api-Version", "2022-11-28");
        mapper.put("Authorization", "Bearer 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");

        return mapper;
    }
}
