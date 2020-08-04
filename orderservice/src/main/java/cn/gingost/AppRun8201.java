package cn.gingost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class AppRun8201 {

    public static void main(String[] args) {
        SpringApplication.run(AppRun8201.class, args);
    }

    @GetMapping("/run")
    public String run() {
        return "8201 is running";
    }
}
