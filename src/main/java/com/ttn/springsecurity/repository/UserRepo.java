package com.ttn.springsecurity.repository;

import com.ttn.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByEmail(@Param("email") String email);
}
