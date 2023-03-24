package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postHolder() {
        return "This is the placeholder for the post page";
    }
    @GetMapping("/posts/{postNum}")
    @ResponseBody
    public String specificPostHolder(@PathVariable int postNum) {
        return "holder for a specific post " + postNum;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostHolder() {
        return "Holder for the create post page";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostMethod() {
        return "holder for the post method once the form is submitted";
    }
}
