/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Contact;
import com.vuyo.cafe.cafeapp.domain.Demography;
import com.vuyo.cafe.cafeapp.domain.Employee;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.repository.EmployeeRepository;
import java.math.BigDecimal;
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
public class EmployeeRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private EmployeeRepository repo;
    
    public EmployeeRepositoryTest() {
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(EmployeeRepository.class);
        
        Contact contact = new Contact();
        contact.setCellphone("111 111 1111");
        contact.setEmail("Someone@mail.com");
        contact.setOfficeNumber("222 222 2222");
        
        Demography demo = new Demography();
        demo.setDateOfBirth(null);
        demo.setGender("Male");
        demo.setRace("Marathon");                   //I know its not that type of race
        
        Employee employee = new Employee();
        employee.setFirstName("Someone");
        employee.setLastName("Someone");
        employee.setJobId("Cashier");
        employee.setContact(contact);
        employee.setDemography(demo);
        
        repo.save(employee);
        id = employee.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Employee employee = repo.findOne(id);
        Assert.assertEquals("Someone", employee.getFirstName());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Employee employee = repo.findOne(id);
        employee.setLastName("Nothing");
        repo.save(employee);
        
        Employee updatedEmployee = repo.findOne(id);
        Assert.assertEquals("Nothing", updatedEmployee.getLastName());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Employee employee = repo.findOne(id);
        repo.delete(employee);
        
        Employee deletedEmployee = repo.findOne(id);
        Assert.assertNull(deletedEmployee);
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
