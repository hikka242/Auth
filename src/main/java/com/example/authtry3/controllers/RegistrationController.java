package com.example.authtry3.controllers;

import com.example.authtry3.dto.UserDto;
import com.example.authtry3.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private final UserRepo repo;
    //    private final PasswordEncoder encoder;
    @Autowired
    public RegistrationController(UserRepo repo) {
        this.repo = repo;
//        this.encoder = encoder;
    }
    @GetMapping("/registration")
    public String registration(){
        return "register";
    }
    @PostMapping("/registration")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password){
        UserDto user=new UserDto();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder().encode(password));
        user.setRole("AUTHORIZED_USER");
        repo.save(user);
        return "redirect:/login";
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password){
        try{
            UserDto user=repo.findByEmail(email);
            if(user.getPassword().equals(passwordEncoder().encode(password))){
                return "redirect:/api/v2/users/getAll";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/login";
        }
        return "redirect:/login";
    }
    @GetMapping("/helloforauth")
    public String helloforAuth(){
        return "hello2";
    }
}
