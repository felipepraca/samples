package com.samples.sample.endpoint.maven.controllers;

import com.samples.sample.endpoint.maven.exceptions.DefaultException;
import com.samples.sample.endpoint.maven.services.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HealthCheckController {

    @Autowired
    HealthCheckService healthCheckService;

    @GetMapping("/healthCheck")
    @ResponseStatus(HttpStatus.OK)
    public void healthCheck() {
        boolean isSuccess = healthCheckService.check();
        System.out.println(isSuccess);
        if (!isSuccess) throw new DefaultException();
    }

}
