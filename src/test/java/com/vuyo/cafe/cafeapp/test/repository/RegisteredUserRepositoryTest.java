/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.AppUser;
import com.vuyo.cafe.cafeapp.domain.RegisteredUser;
import com.vuyo.cafe.cafeapp.domain.Roles;
import com.vuyo.cafe.cafeapp.repository.AppUserRepository;
import com.vuyo.cafe.cafeapp.repository.RegisteredUserRepository;
import com.vuyo.cafe.cafeapp.repository.RolesRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author namhla
 */
public class RegisteredUserRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private RegisteredUserRepository repo;
    private RolesRepository rolesRepo;
    private AppUserRepository appRepo;
    
    public RegisteredUserRepositoryTest() {
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(RegisteredUserRepository.class);
        rolesRepo = ctx.getBean(RolesRepository.class);
        appRepo = ctx.getBean(AppUserRepository.class);
        
        Roles role = new Roles();
        role.setDescription("Gets Administrator privileges");
        role.setRoleName("Administrator");
        rolesRepo.save(role);
        
        AppUser appUser = new AppUser();
        appUser.setEnabled(true);
        appUser.setPassword("987");
        appUser.setUserName("Scalea");
        appUser.setRoles(role);
        
        RegisteredUser user = new RegisteredUser();
        user.setCompassword("Scaleesi123");
        user.setEmail("Someone@mail.com");
        user.setFirstname("Someone");
        user.setLastname("Someone");
        user.setPassword("987");
        
        repo.save(user);
        id = user.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        RegisteredUser user = repo.findOne(id);
        Assert.assertEquals("Someone", user.getFirstname());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        RegisteredUser user = repo.findOne(id);
        user.setFirstname("Vuyo");
        repo.save(user);
        
        RegisteredUser updatedUser = repo.findOne(id);
        Assert.assertEquals("Vuyo", updatedUser.getFirstname());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        RegisteredUser user = repo.findOne(id);
        repo.delete(user);
        
        RegisteredUser deletedUser = repo.findOne(id);
        Assert.assertNull(deletedUser);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
}
