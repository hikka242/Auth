package com.example.authtry3.repo;

import com.example.authtry3.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
