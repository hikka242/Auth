package com.example.authtry3.controllers;

import com.example.authtry3.dto.UserDto;
import com.example.authtry3.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//package com.example.authtry3.controllers;
//
//import com.example.authtry3.dto.UserDto;
//import com.example.authtry3.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v2/user")
//public class CrudRestController {
//    private final UserRepo userRepo;
//    @Autowired
//    public CrudRestController(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @GetMapping("/getAll")
////    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<List<UserDto>> getAll(){
//        try{
//            List<UserDto> userDtos = new ArrayList<>(userRepo.findAll());
//            if(userDtos.isEmpty()){
//                return new ResponseEntity<>(userDtos, HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//    @GetMapping("/getById/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
//        Optional<UserDto> user =userRepo.findById(id);
//
//        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//    @PostMapping("/addUser")
//    public String addUser(@RequestBody UserDto userDto){
//        userRepo.save(userDto);
//        return "User is saved";
//    }
//    @PutMapping("/editById/{id}")
//    public ResponseEntity<UserDto> editUser(@PathVariable Long id, @RequestBody UserDto newUserDto){
//        Optional<UserDto> user =userRepo.findById(id);
//        if(user.isPresent()){
//            UserDto updateUserDto =user.get();
//            updateUserDto.setUsername(newUserDto.getUsername());
//            updateUserDto.setEmail(newUserDto.getEmail());
//            updateUserDto.setPassword(newUserDto.getPassword());
//            return new ResponseEntity<>(user.get(),HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @DeleteMapping("/deleteById/{id}")
//    public ResponseEntity<UserDto> removeUser(@PathVariable Long id){
//        userRepo.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @DeleteMapping("/deleteAll")
//    public ResponseEntity<UserDto> removeAll(){
//        userRepo.deleteAll();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//}
@RestController
@RequestMapping("/api/v2/user")
@AllArgsConstructor
public class CrudRestController {
    private final UserRepo userRepo;

    @GetMapping("/getAll")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UserDto>> getAll() {
        try {
            List<UserDto> userDtos = new ArrayList<>(userRepo.findAll());
            if (userDtos.isEmpty()) {
                return new ResponseEntity<>(userDtos, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto){
        userRepo.save(userDto);
        return "User is saved";
    }

}
