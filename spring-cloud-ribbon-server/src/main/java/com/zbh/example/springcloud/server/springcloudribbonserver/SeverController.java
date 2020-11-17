package com.zbh.example.springcloud.server.springcloudribbonserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeverController {

    @GetMapping("/server")
    public String server(){
        return "This is server";
    }
}
