package com.example.authtry3.repo;

import com.example.authtry3.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<UserDto,Long> {
//    Optional<UserDto> findByName(String username);
    @Query("SELECT u FROM UserDto u WHERE u.email = :email")
    UserDto findByEmail(String email);
}
