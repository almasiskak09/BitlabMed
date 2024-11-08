package com.medProject.bitlabMed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
    @GetMapping(value = "/doctors")
    public String doctorsPage(){
        return "doctors";
    }

    @GetMapping(value = "/analyses")
    public String analysesPage(){
        return "analyses";
    }

    @GetMapping(value = "/diagnostic")
    public String diagnosticPage(){
        return "diagnostic";
    }


}
