package com.example.demo.services;

import com.example.demo.domain.GiftItem;
import com.example.demo.repositories.GiftItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GiftItemService {

    private final GiftItemRepository repository;

    public void addGiftItem(GiftItem giftItem) {
        repository.save(giftItem);
    }
}
