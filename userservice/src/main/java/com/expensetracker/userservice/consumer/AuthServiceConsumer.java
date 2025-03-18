package com.expensetracker.userservice.consumer;

import com.expensetracker.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthServiceConsumer {

    private UserRepository userRepository;

    @Autowired
    AuthServiceConsumer(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
