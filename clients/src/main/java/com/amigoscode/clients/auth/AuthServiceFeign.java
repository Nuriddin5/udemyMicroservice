package com.amigoscode.clients.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("AUTHSERVICE")
public interface AuthServiceFeign {
    @GetMapping("api/v1/user/current")
    public User getCurrentUser();

}
