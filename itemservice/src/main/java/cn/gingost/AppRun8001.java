package cn.gingost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 20:16
 **/

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class AppRun8001 {
    public static void main(String[] args) {
        SpringApplication.run(AppRun8001.class);
    }

    @GetMapping("/run")
    public String run() {
        return "8081 is running";
    }
}
