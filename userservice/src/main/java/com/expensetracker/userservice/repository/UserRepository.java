package com.expensetracker.userservice.repository;

import com.expensetracker.userservice.entities.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfoDto,String> {

    UserInfoDto findByUserId(String userId);
}
