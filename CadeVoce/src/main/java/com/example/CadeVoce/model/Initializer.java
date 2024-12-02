package com.example.CadeVoce.model;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.CadeVoce.CadeVoceApplication;

public class Initializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CadeVoceApplication.class); // Referência à classe principal da aplicação
    }
}
