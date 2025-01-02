package icu.uuqk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UuEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UuEurekaApplication.class, args);
    }

}
