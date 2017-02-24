package edu.cmu.mis.iccfb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class QuoteApplication {

    @Autowired
    private SeedData seedData;
    
    public static void main(String[] args) {
        SpringApplication.run(QuoteApplication.class, args);
	}
}
