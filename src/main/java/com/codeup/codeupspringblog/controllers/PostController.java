package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String postHolder(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("Moving service available", "Moving soon call us at 111-111-1111");
        Post post2 = new Post("Gaming Computer problems", "It doesn't work and I down know why");
        Post post3 = new Post("Cats for new home", "a couple of 2 month old kittens looking for a new home");
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @GetMapping("/posts/{postNum}")
    @ResponseBody
    public String specificPostHolder(@PathVariable int postNum, Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("Moving service available", "Moving soon call us at 111-111-1111");
        posts.add(post1);
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostHolder() {return "Holder for the create post page";}

    @PostMapping("/posts/create")
      public String createPostMethod() {
        return "holder for the post method once the form is submitted";
    }
}
