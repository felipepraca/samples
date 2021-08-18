package com.samples.sample.endpoint.maven.services;

import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    public Boolean check() {
        // Executa alguma operação no banco ou algum serviço que é dependecia desse.
        return Math.random() < 0.5;
    }
}
