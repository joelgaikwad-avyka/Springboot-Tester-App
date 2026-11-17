package com.testing;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public Map<String, String> hello() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("message", "Hello World!");
        try {
            InetAddress host = InetAddress.getLocalHost();
            response.put("hostname", host.getHostName());
            response.put("ip", host.getHostAddress());
        } catch (UnknownHostException e) {
            response.put("hostname", "unknown");
            response.put("ip", "unknown");
        }
        return response;
    }
}
