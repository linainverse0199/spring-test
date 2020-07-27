package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("register")
public class RegistrationController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @GetMapping
    public String registryForm(Model model) {
        // model.addAttribute("newUser", new User(""));
        return "register";
    }

    /**
     * Password is passed through form without any encoding, in pure text form.
     * Is it OK?
     *
     * @param user
     * @param error
     * @return
     */
    @PostMapping
    public String processRegistration(User user, Errors error) {
        if (error.hasErrors()) {
            return "register";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return "redirect:/login";
    }
}
