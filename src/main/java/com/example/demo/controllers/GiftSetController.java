package com.example.demo.controllers;

import com.example.demo.domain.GiftSet;
import com.example.demo.services.GiftSetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("giftset")
@SessionAttributes("giftSet")
public class GiftSetController {

    private final GiftSetService service;

    @GetMapping("current")
    public String giftSetForm(Model model) {
        return "giftset/item";
    }

    @PostMapping("create")
    public String sendGiftSet(@Valid GiftSet giftSet, Errors error, SessionStatus session) {
        if (error.hasErrors()) {
            return "giftset/item";
        }
        service.sendGiftSet(giftSet);
        session.setComplete();
        return "redirect:/";
    }
}
