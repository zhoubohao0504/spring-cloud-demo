package com.zbh.example.springcloud.client.springcloudribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/client")
    public String client(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-ribbon-server");
        String url = String.format("http://%s:%s/server",serviceInstance.getHost(),serviceInstance.getPort());
        return "This is Client"+restTemplate.getForObject(url,String.class);
    }
}
