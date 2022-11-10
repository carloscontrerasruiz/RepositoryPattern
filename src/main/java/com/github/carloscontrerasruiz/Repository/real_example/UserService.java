package com.github.carloscontrerasruiz.Repository.real_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }
}
