package org.brillio.com.brillio.productorder.config;

import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ZERO)
                .setReadTimeout(Duration.ZERO)
                .build();
    }

//    public List<ClientHttpRequestInterceptor> interceptors() {
//        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//        return interceptors;
//    }
}
