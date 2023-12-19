//package com.example.authtry3.service;
//
//import com.example.authtry3.dto.UserDto;
//import com.example.authtry3.repo.UserRepo;
//import com.example.authtry3.security.MyUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepo repo;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserDto> user =repo.findByName(username);
//        return user.map(MyUserDetails::new)
//                .orElseThrow(()-> new UsernameNotFoundException(username+ " not found"));
//    }
//}
