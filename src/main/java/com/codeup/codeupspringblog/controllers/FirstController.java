package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {


//    @GetMapping("/hello")
//    @ResponseBody
//    public String returnHelloWorld() {
//        return "Hello World!";
//    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String greetName(@PathVariable String name) {
        return "Hello " + name;
    }

    //Not the proper way to return thing to populate things on the page
    @GetMapping("/ricardo")
    @ResponseBody
    public String returnRicardo() {
        return "<h1>I am Ricardo</h1>";
    }
}
