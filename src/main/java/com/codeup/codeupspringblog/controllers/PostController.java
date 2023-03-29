package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private UserRepository userDao;
    private PostRepository postDao;

    public PostController(UserRepository userDao, PostRepository postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }




    @GetMapping("/posts")
    public String postHolder(Model model) {
        List<Post> posts = new ArrayList<>();
//        Post post1 = new Post("Has anyone swapped a LS2 in", "Trying to see if it's something");
//        Post post2 = new Post("What are good tires for track use", "I am going to start tracking the car soon so I wanted to see what tires i should use");
//        Post post3 = new Post("Meet up in the San Antonio area", "meet up April 1st at 2pm by bass pro shop");
//        postDao.save(post1);
//        postDao.save(post2);
//        postDao.save(post3);
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }
    @GetMapping("/posts/{postNum}")
    public String specificPostHolder(@PathVariable Long postNum, Model model) {

        Post post = postDao.findById(postNum).get();
        User user = userDao.findById(post.getId()).get();

//        Post post1 = new Post("taillights for sale", "OEM taillights are for sale after upgrading it (open to trades)");
//        posts.add(post1);
        model.addAttribute("posts", post);
        model.addAttribute("user", user);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostHolder() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
      public String createPostMethod(@RequestParam String title, @RequestParam  String body) {
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }
}
