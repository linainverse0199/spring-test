package com.example.demo.controllers;

import com.example.demo.domain.Marmalade;
import com.example.demo.model.dtos.MarmaladeItem;
import com.example.demo.model.dtos.UserItem;
import com.example.demo.services.MarmaladeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("marmalade")
@RequiredArgsConstructor
@SessionAttributes("user")
public class MarmaladeController {

    private final MarmaladeService service;

    @ModelAttribute("user")
    public UserItem user() {
        return new UserItem();
    }

    @ModelAttribute("marmalade")
    public MarmaladeItem marmalade() {
        return new MarmaladeItem();
    }

    @GetMapping
    public String getList(Model model) {
        model.addAttribute("list", service.getAll());
        return "marmalade/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("marmalade", new MarmaladeItem());
        return "marmalade/item";
    }

    @PostMapping("create")
    public String saveItem(@Valid MarmaladeItem marmalade, Errors error, @ModelAttribute UserItem user, SessionStatus session) {
        if (error.hasErrors()) {
            log.error("invalid form");
            return "marmalade/item";
        }
        service.save(Marmalade.builder()
                .name(marmalade.getProvider())
                .shape(marmalade.getShape())
                .taste(marmalade.getTaste())
                .build());
        session.setComplete();
        return "redirect:/marmalade";
    }
}
