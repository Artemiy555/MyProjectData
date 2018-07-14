package com.rest.client.config;

import com.rest.client.feign.RestApiFeignClient;
import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@EnableFeignClients(clients = { RestApiFeignClient.class })
@ConditionalOnClass({ Feign.class })
public class FeignMappingConfig {

    @Bean
    public WebMvcRegistrations feignWebRegist() {
        return  new WebMvcRegistrationsAdapter() {
            @Override
            public RequestMappingHandlerMapping
                                    getRequestMappingHandlerMapping() {
                return new FeignFilterRequestMappingHandler();
            }
        };
    }

    private class FeignFilterRequestMappingHandler
                                extends  RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && !beanType.isInterface();
        }
    }
}
