package com.expensetracker.userservice.deserializer;

import com.expensetracker.userservice.entities.UserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.io.InputStream;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {

    @Override
    public UserInfoDto deserialize(String arg0,byte[] arg1) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user = null;
        try {
            user = objectMapper.readValue(arg1, UserInfoDto.class);

        }catch (Exception ex){
            System.out.println(ex + "Cannot deserialize");
        }
        return user;
    }
}
