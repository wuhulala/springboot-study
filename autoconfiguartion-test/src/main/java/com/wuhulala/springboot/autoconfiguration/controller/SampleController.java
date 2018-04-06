package com.wuhulala.springboot.autoconfiguration.controller;

import com.wuhulala.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final User owner;

    @Autowired
    public SampleController(User owner) {
        this.owner = owner;
    }

    @GetMapping("/")
    String home() {
        return "our system owner is " + owner;
    }

}