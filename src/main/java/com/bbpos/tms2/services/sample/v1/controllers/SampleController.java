package com.bbpos.tms2.services.sample.v1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping()
    public String get(String value) {
        return String.format("Server response: %s", value);
    }
}
