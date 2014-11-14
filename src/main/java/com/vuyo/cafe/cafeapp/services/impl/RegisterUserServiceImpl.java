/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuyo.cafe.cafeapp.services.impl;



/*import com.cafeteria.system.app.factory.AppFactory;
import com.cafeteria.system.client.web.model.RegisterModel;
import com.cafeteria.system.domain.AppUser;
import com.cafeteria.system.domain.RegisteredUser;
import com.cafeteria.system.domain.Roles;
import com.cafeteria.system.security.PasswordEncrypt;
import com.cafeteria.system.services.RegisterUserService;
import com.cafeteria.system.services.crud.RegisteredUserCrudService;
import com.cafeteria.system.services.impl.authenticate.RegisterService;
import com.cafeteria.system.services.impl.authenticate.RoleCrudService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;*/

/**
 *
 * @author 
 */
//@Service
public class RegisterUserServiceImpl /*implements RegisterUserService*/{
    
    /*@Autowired
    private RegisterService registerService;
    @Autowired
    private RoleCrudService roleCrudService;
    
    @Autowired
    private RegisteredUserCrudService regCrudService;

    @Override
    public void registerUser(RegisterModel model) {
        Map<String, String> Roledetails = new HashMap<String, String>();
        Roledetails.put("roleName", "ROLE_user");
        Roledetails.put("description", "Limited Access");
        
        Map<String, String> details = new HashMap<String, String>();
        details.put("firstname", model.getFirstname());
        details.put("lastname", model.getLastname());
        details.put("email", model.getEmail());
        details.put("password",PasswordEncrypt.encrypt(model.getPassword()));
        details.put("compassword", details.get("password"));

        RegisteredUser user = AppFactory.getRegUser(details);
        
        Map<String, String> userdetails = new HashMap<String, String>();
        userdetails.put("username", user.getEmail());
        userdetails.put("password", user.getPassword());

       Roledetails.put("username", userdetails.get("username"));

        Roles role = AppFactory.getRole(Roledetails);
        roleCrudService.persist(role);
        AppUser appuser = AppFactory.getUser(userdetails, true, role);

        registerService.persist(appuser);
        user.setUser(appuser);
        regCrudService.persist(user);
        
    }

    @Override
    public AppUser getByEmailAddress(String emailAddress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
