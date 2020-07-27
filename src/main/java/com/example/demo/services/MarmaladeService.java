package com.example.demo.services;

import com.example.demo.domain.Marmalade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class MarmaladeService {

    public void save(Marmalade marmalade) {
        log.info("Saving marmalade {}", marmalade);
    }

    public List<Marmalade> getAll() {
        log.info("Returning all marmalade");
        return Collections.emptyList();
    }

    public Marmalade getOne() {
        Marmalade murmur = Marmalade.builder().name("murmur").taste("Orangen").build();
        log.info("Returning one marmalade {}", murmur);
        return murmur;
    }
}
