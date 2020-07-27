package com.example.demo.services;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository repository;

    public User getUser(long id) {
        return repository.getOne(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.getList();
    }

}
