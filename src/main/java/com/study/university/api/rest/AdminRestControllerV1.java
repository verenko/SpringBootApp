package com.study.university.api.rest;


import com.study.university.api.dto.AdminUserDto;
import com.study.university.api.model.User;
import com.study.university.api.security.jwt.JwtTokenProvider;
import com.study.university.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/admin/")
@Slf4j
public class AdminRestControllerV1 {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AdminRestControllerV1(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/me")
    @ResponseBody
    public ResponseEntity<AdminUserDto> getUsernameWithToken(HttpServletRequest req) {

        String bearerToken = req.getHeader("Authorization");
        String token = bearerToken.substring(7, bearerToken.length());
        String username = jwtTokenProvider.getUsername(token);
        AdminUserDto result = AdminUserDto.fromUser(userService.findByUsername(username));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
