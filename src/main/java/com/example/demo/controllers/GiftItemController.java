package com.example.demo.controllers;

import com.example.demo.domain.GiftItem;
import com.example.demo.domain.GiftSet;
import com.example.demo.services.GiftItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/giftitem")
@SessionAttributes("giftSet")
@RequiredArgsConstructor
public class GiftItemController {

    private final GiftItemService service;

    @ModelAttribute(name="giftItem")
    public GiftItem giftItem() {
        return null; // new GiftItem();
    }

    @ModelAttribute(name="giftSet")
    public GiftSet giftSet() {
        return new GiftSet();
    }

    @GetMapping("create")
    public String showForm(Model model) {
        model.addAttribute("giftItem", null /*new GiftItem()*/);
        return "giftitem/item";
    }

    @PostMapping("create")
    public String saveGiftItem(@Valid GiftItem giftItem, Errors error, @ModelAttribute GiftSet giftSet) {
        if (error.hasErrors()) {
            return "giftitem/item";
        }
        service.addGiftItem(giftItem);
        giftSet.addGiftItem(giftItem);
        return "redirect:/giftset/current";
    }
}
