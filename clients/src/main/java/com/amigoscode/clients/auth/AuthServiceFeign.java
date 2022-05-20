package com.amigoscode.clients.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authservice",
        url = "${clients.authservice.url}")
public interface AuthServiceFeign {
    @GetMapping("api/v1/user/current")
    User getCurrentUser();
}
