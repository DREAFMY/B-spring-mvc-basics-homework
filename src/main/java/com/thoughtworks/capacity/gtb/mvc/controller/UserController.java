package com.thoughtworks.capacity.gtb.mvc.controller;


import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated User user) throws Exception {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam @Pattern(regexp = "/^\\w{3,10}$/", message = "user name must be length 3-10 number english underline") String username,
                                      @RequestParam @Size(min = 5, max = 12, message = "password length min 5 max 12") String password) throws Exception {
        User user = userService.login(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
