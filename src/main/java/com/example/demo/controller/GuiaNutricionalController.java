package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiaNutricionalController {
    @GetMapping("/guiaNutricional.html")
    public String lista(){
        return "guiaNutricional.html";
    }

}
