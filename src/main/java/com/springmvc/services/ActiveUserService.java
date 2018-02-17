package com.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActiveUserService {
    @Autowired
    private SessionRegistry sessionRegistry;

    public List<String> getAllActiveUsers() {
        List<String> userList=new ArrayList<>();
        List<Object> principals = sessionRegistry.getAllPrincipals();
        for (Object object:principals){
            User user=(User)object;
            if(!sessionRegistry.getAllSessions(user,false).isEmpty()){
                userList.add(user.getUsername());
            }
        }
        return userList;
    }
}