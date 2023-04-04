package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private final UserRepository userDao;
    private final PostRepository postDao;
    private final EmailService emailService;

    public PostController(UserRepository userDao, PostRepository postDao, EmailService emailService) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.emailService = emailService;
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
    public String specificPostHolder(@PathVariable long postNum, Model model) {
//        Post post1 = new Post("taillights for sale", "OEM taillights are for sale after upgrading it (open to trades)");
//        posts.add(post`1);
        Post post = postDao.findById(postNum);
        User user = post.getUser();
        model.addAttribute("posts", post);
        model.addAttribute("users", user);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create") // previous arguments passed (@RequestParam String title, @RequestParam  String body)
      public String createPostSubmit(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userDao.findById(user.getId()));
        emailService.prepareAndSend(post, "New Post Created", "You created a new post your post ID is: " + post.getId());
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPostSubmit(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/")
    public String landingPage() {
//        emailService.prepareAndSend("test", "If you see this it worked");
        return "home";

    }

}
