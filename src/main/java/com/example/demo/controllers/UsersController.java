package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.model.dtos.MarmaladeItem;
import com.example.demo.model.dtos.UserItem;
import com.example.demo.model.views.UserView;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/users")
@RequiredArgsConstructor
@SessionAttributes("user")
public class UsersController {

    private final UserService service;

    @ModelAttribute("user")
    public UserItem user() {
        return new UserItem();
    }

    @ModelAttribute("marmalade")
    public MarmaladeItem marmalade() {
        return new MarmaladeItem();
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users",
                service.getUsers()
                        .stream()
                        .map(user -> new UserView(user.getId(), user.getName())).collect(Collectors.toList()));
        return "users";
    }

    @GetMapping(path = "create")
    public String showCreateForm() {
        return "user";
    }

    /*
    Example was without @ModelAttribute, but it is necessary - it provides
    access to passed model which is expected by view due to its errors showing feature
     */
    @PostMapping
    public String createUser(@Valid @ModelAttribute("user") UserItem user, Errors error) {
        if (error.hasErrors()) {
            log.error("User object is invalid {}", user);
            return "user";
        }
        // service.createUser(user);
        log.info("User object received {}", user);
        return "redirect:/users/current";
    }
}
