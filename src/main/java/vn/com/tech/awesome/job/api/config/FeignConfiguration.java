package vn.com.tech.awesome.job.api.config;

import feign.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.com.tech.awesome.job.api.connector.feign.FeignLogger;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 11:12 PM - Wednesday
 * @project : awesome-job-api
 **/
@Configuration
@EnableFeignClients
@RequiredArgsConstructor
public class FeignConfiguration {

    private final FeignLogger logger;

    @Bean
    public FeignLoggerFactory feignLoggerFactory(){
        return type -> logger;
    }

}
