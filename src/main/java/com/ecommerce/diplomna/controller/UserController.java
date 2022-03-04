package com.ecommerce.diplomna.controller;

import com.ecommerce.diplomna.dto.ResponseDto;
import com.ecommerce.diplomna.dto.user.SignInDto;
import com.ecommerce.diplomna.dto.user.SignInResponseDto;
import com.ecommerce.diplomna.dto.user.SignUpDto;
import com.ecommerce.diplomna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    // two apis

    // signup

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignUpDto signupDto) {
        return userService.signUp(signupDto);
    }


    // signin

    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
}
