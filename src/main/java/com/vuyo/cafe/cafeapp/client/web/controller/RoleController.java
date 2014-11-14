/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.client.web.controller;

import com.vuyo.cafe.cafeapp.client.web.model.RoleModel;
import com.vuyo.cafe.cafeapp.domain.Roles;
import com.vuyo.cafe.cafeapp.services.modelService.RoleModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 *
 * @author namhla
 */
@Controller
@SessionAttributes
public class RoleController {
    private Long editId;
    private Long deleteId;
    @Autowired
    private RoleModelService roleModelService;
    
    @RequestMapping(value= "/rolePage", method=RequestMethod.GET)
    public String getWelcomeToRolesPage(Model model){
        RoleModel role = new RoleModel();
        model.addAttribute("role", role);
        return "role/welcome";
        
    }
    @RequestMapping(value= "/roleForm", method=RequestMethod.GET)
    public String createFormRole(Model model){
        return "/public/role/addRole";
        
    }
    @RequestMapping(value= "/createRole", method=RequestMethod.POST)
    public String createRole(@ModelAttribute("RoleModel") @Validated RoleModel roleModel,
            BindingResult result, Model model){
        
        roleModelService.createRole(roleModel);
        List<Roles> roles = roleModelService.getRoles();
        model.addAttribute("role", roles);
        
        return "/public/role/addRole";
    }
    
    @RequestMapping(value="/deleteRole", method = RequestMethod.POST)
    public String deleteRole(Long id, Model model){
        roleModelService.deleteRole(deleteId);
         List<Roles> roles = roleModelService.getRoles();
         model.addAttribute("role",roles);
         return "/public/role/role";
    }
    @RequestMapping(value="/editRole", method = RequestMethod.GET, params = {"id"})
    public String editRole(@RequestParam("id") Long id, Model model){
       RoleModel roleModel = roleModelService.getRoleToedit(id);
       editId = id;
       model.addAttribute("role", roleModel);
       return "/public/role/role";
   }
   @RequestMapping(value="/updateRole", method = RequestMethod.POST)
    public String updateRole(@ModelAttribute("role") @Validated RoleModel roleModel,
        BindingResult result, Model model){
        roleModelService.updateRole(roleModel, editId);
        List<Roles> roles = roleModelService.getRoles();
        model.addAttribute("role", roles);
        return "/public/role/role";
    }
}
