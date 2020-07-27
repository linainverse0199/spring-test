package com.example.demo.controllers;

import com.example.demo.model.dtos.UserItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 */
@Controller
@Slf4j
public class HomeController {
    @PostMapping(path = "home")
    public String createUser(@Valid UserItem user, Errors errors) {
        if(errors.hasErrors()) {
            log.info("There is an error");
            return "users";
        }
        log.info("Home object received {}", user);
        return "redirect:";
    }
}
