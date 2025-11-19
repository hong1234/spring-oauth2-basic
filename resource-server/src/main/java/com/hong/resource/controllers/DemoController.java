package com.hong.resource.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "Demo";
    }

    @GetMapping("/teams")
    public List<String> getTeams() {
        return List.of("Portugal", "Republic of Ireland", "South Africa", "Spain", "Sweden", "Switzerland", "USA", "Vietnam", "Zambia");
    }
}
