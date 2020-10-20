package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public User login(@RequestParam @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$") String username, @RequestParam @Size(max = 12,min = 5) String password){
        return loginService.login(username,password);
    }
}
