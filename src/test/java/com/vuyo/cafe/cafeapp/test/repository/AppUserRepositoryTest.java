/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.AppUser;
import com.vuyo.cafe.cafeapp.domain.Roles;
import com.vuyo.cafe.cafeapp.repository.AppUserRepository;
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
public class AppUserRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AppUserRepository repo;
    private RolesRepository roleRepo;
    
    public AppUserRepositoryTest() {
    }
    
    @Test(enabled = false)
    public void testCreate()
    {
        repo = ctx.getBean(AppUserRepository.class);
        roleRepo = ctx.getBean(RolesRepository.class);
        
        Roles admin = new Roles();
        admin.setDescription("Grants the user Administrator rights");
        admin.setRoleName("Administrator");
        roleRepo.save(admin);
        
        AppUser user = new AppUser();
        user.setUserName("softDev123");
        user.setPassword("softDev123");
        user.setEnabled(true);
        user.setRoles(admin);
        
        repo.save(user);
        id = user.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate", enabled = false)
    public void testRead()
    {
        AppUser user = repo.findOne(id);
        Assert.assertEquals("softDev123", user.getUserName());
    }
    
    @Test(dependsOnMethods = "testRead", enabled = false)
    public void testUpdate()
    {
        AppUser user = repo.findOne(id);
        user.setPassword("123");
        repo.save(user);
        
        AppUser updatedUser = repo.findOne(id);
        Assert.assertEquals("123", updatedUser.getPassword());
    }
    
    @Test(dependsOnMethods = "testUpdate", enabled = false)
    public void testRemove()
    {
        AppUser user = repo.findOne(id);
        repo.delete(user);
        
        AppUser deletedUser = repo.findOne(id);
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
