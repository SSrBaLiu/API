package org.liu.data.config;

import org.liu.data.util.DataCreater;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public DataCreater dataCreater(){
        return new DataCreater();
    }
}
