package com.rest.client.feign;

import com.rest.api.endpoint.StudentsEndpoint;
import com.rest.client.config.FeignClientConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(
        value = "Rest-API",
        url   = "http://localhost:15000",
        configuration = FeignClientConfig.class
)
public interface RestApiFeignClient extends StudentsEndpoint {
}
