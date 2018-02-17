package com.springmvc.controller;


import com.springmvc.repositories.UserRepository;
import com.springmvc.services.RunAsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RunAsController {
    @Autowired
    RunAsService runAsService;

    @RequestMapping("/runas")
    @ResponseBody
    @Secured({"ROLE_ADMIN", "RUN_AS_REPORTER"})
    public String runAs(){
        return runAsService.display();
    }

    @RequestMapping("/runas2")
    @ResponseBody
    @Secured({"ROLE_ADMIN"})
    public String runAs2(){
        return runAsService.display();
    }

}
