package com.springmvc.controller;


import com.springmvc.entity.User;
import com.springmvc.repositories.UserRepository;
import com.springmvc.services.ActiveUserService;
import com.springmvc.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    ActiveUserService activeUserService;

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/current/user")
    @ResponseBody
    public String userdetails(){
        UserDetails userDetails = userDetailsService.getCurrentUser();
        return "Hello "+userDetails.getUsername();
    }

    @RequestMapping("/active/users")
    @ResponseBody
    public String activeUsers(){
        return activeUserService.getAllActiveUsers().toString();
    }
}
