/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.client.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author namhla
 */
@Controller
@SessionAttributes
public class AppUserController {
    
    @RequestMapping(value ="/", method =RequestMethod.GET)
    public String displayLogin(Model model){
        return " /home";
        
    } 
    
}
