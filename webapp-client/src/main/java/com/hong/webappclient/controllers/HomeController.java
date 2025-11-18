package com.hong.webappclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    // @GetMapping("/")
    // public String home() {
    //     return "index.html";
    // }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        model.addAttribute("userName", oidcUser.getName());
        // model.addAttribute("audience", oidcUser.getAudience());
        // model.addAttribute("expiresAt", oidcUser.getExpiresAt());
        // model.addAttribute("claims", oidcUser.getClaims());
        return "index";
    }
}
