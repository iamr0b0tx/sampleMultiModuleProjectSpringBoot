package com.twobitsconnect.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.twobitsconnect"})
@EnableJpaAuditing
@EntityScan(basePackages = {"com.twobitsconnect.*"})
@EnableJpaRepositories(basePackages = {"com.twobitsconnect.*"})
//@SpringBootApplication
public class WebApplication {

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
