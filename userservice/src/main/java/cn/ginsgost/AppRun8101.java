package cn.ginsgost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 20:46
 **/

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class AppRun8101 {
    public static void main(String[] args) {
        SpringApplication.run(AppRun8101.class,args);
    }
    @GetMapping("/run")
    public String run(){
        return "8101 is running";
    }
}
