package com.example.rfq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.example.rfq.RfqService;

@Configuration
@ComponentScan("com.example.rfq")
public class AppConfig {

    @Bean
    public RfqService rfqService() {
        return new RfqService();
    }
}
