package com.example.demo.services;

import com.example.demo.domain.GiftSet;
import com.example.demo.repositories.GiftSetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GiftSetService {

    private final GiftSetRepository repository;

    public void sendGiftSet(GiftSet giftSet) {
        // save here values for gift set and gift_set_gift_item tables
    }
}
