package com.example.rest_soap_graphql_api_tutorial.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rest/")
public class MyRestController {
    private final List<User> userRepository;
    MyRestController(List<User> userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public void postUser(@RequestBody UserDTO userDTO){
        User user = new User(userDTO);
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        userRepository.add(user);
    }

    @GetMapping("/user/all")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity(userRepository.stream().map(
                u -> new UserDTO(u.getName(),u.getAge())).collect(Collectors.toList()
        ), HttpStatus.OK);
    }
}
