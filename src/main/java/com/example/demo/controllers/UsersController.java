package com.example.demo.controllers;

import com.example.demo.model.UserItem;
import com.example.demo.model.UserView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@Slf4j
@RequestMapping("/users")
public class UsersController {

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("user", new UserItem());
        model.addAttribute("list", Arrays.asList(new UserView(23L, "Peter"), new UserView(34L, "Jack")));
        return "users";
    }

    /*
    Example was without @ModelAttribute, but it is necessary - it provides
    access to passed model which is expected by view due to its errors showing feature
     */
    @PostMapping
    public String createUser(@Valid @ModelAttribute("user") UserItem user, Errors error) {
        if (error.hasErrors()) {
            log.error("User object is invalid {}", user);
            return "users";
        }
        log.info("User object received {}", user);
        return "redirect:/users/current";
    }
}
