package com.study.university.api.rest;

import com.study.university.api.dto.UserDto;
import com.study.university.api.model.User;
import com.study.university.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/users/")
@Slf4j
public class UserRestControllerV1 {
    private final UserService userService;

    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(method = RequestMethod.OPTIONS)
//    public HttpServletResponse handle(HttpServletResponse theHttpServletResponse) throws IOException {
//        theHttpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
//        theHttpServletResponse.addHeader("Access-Control-Max-Age", "60");
//        theHttpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        theHttpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
//        return theHttpServletResponse;
//    }


    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);


        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
