package me.puneetghodasara.coe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.puneetghodasara.coe.boot.GlobalConfig;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(GlobalConfig.class)
public class BootClass {

    public static void main(String[] args) {
        SpringApplication.run(BootClass.class, args);
    }

    @RestController
    class DummyEndpoint {

        @RequestMapping("/")
        public String get() {
            // This is required by CF :(
            return "Yes, CF I am running";
        }
    }

}
