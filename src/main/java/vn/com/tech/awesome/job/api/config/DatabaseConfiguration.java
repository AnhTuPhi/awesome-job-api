package vn.com.tech.awesome.job.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:23 AM - Wednesday
 * @project : awesome-job-api
 **/
@Configuration
@EnableJpaRepositories(basePackages = "vn.com.tech.awesome.job.api.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
