package com.authentication.authorization.service;

import com.authentication.authorization.entities.UserInfo;
import com.authentication.authorization.eventProducer.UserInfoProducer;
import com.authentication.authorization.model.UserInfoDto;
import com.authentication.authorization.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

@Component
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private final UserInfoProducer userInfoProducer;

    public UserDetailsServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder, UserInfoProducer userInfoProducer) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userInfoProducer = userInfoProducer;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserInfo user = userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Could not found user..!");
        }
        return new CustomUserDetails(user);
    }

    public UserInfo checkIfUserAlreadyExist(UserInfoDto userInfoDto){
        return userRepository.findByUsername(userInfoDto.getUsername());
    }

    public Boolean signupUser(UserInfoDto userInfoDto){
        //Define a function to check if UserEmail,password is correct;
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        if(Objects.nonNull(checkIfUserAlreadyExist(userInfoDto))){
            return false;
        }
        String userId = UUID.randomUUID().toString();
        userRepository.save(new UserInfo(userId,userInfoDto.getUsername(),userInfoDto.getPassword(),new HashSet<>()));

        userInfoProducer.sendEventToKafka(userInfoDto);

        return true;
    }

}
