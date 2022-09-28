package com.example.mvcapp.controllers;

import com.example.mvcapp.informacionEmpresa.User;
import com.example.mvcapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @Autowired
    protected UserService service;

    protected User seguridad(){
        //ingreso a la información de spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Tomo el correo electronico que nos guardo spring security
        String currentPrincipalName = authentication.getName();
        User user = this.service.selectByUserName(currentPrincipalName);
        return  user;
    }
}
