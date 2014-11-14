/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Roles;
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
public class RolesRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private RolesRepository repo;
    
    public RolesRepositoryTest() {
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(RolesRepository.class);
        Roles role = new Roles();
        role.setDescription("Grants the user basic roles of a user");
        role.setRoleName("User");
        
        repo.save(role);
        id = role.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Roles role = repo.findOne(id);
        Assert.assertEquals("User", role.getRoleName());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Roles role = repo.findOne(id);
        role.setRoleName("Manage");
        repo.save(role);
        
        Roles updatedRole = repo.findOne(id);
        Assert.assertEquals("Manage", updatedRole.getRoleName());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Roles role = repo.findOne(id);
        repo.delete(role);
        
        Roles deletedRole = repo.findOne(id);
        Assert.assertNull(deletedRole);
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
