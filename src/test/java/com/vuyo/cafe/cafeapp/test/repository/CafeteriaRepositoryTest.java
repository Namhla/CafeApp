/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Cafeteria;
import com.vuyo.cafe.cafeapp.domain.Contact;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.Stock;
import com.vuyo.cafe.cafeapp.repository.CafeteriaRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
public class CafeteriaRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private CafeteriaRepository repo;
    
    public CafeteriaRepositoryTest() {
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(CafeteriaRepository.class);
        List<Stock> stockList = new ArrayList();
        List<Item> itemList = new ArrayList();
        
        Contact contact = new Contact();
        contact.setCellphone("111 111 1111");
        contact.setEmail("scaleesi@spring.com");
        contact.setOfficeNumber("(021) 111 1111");
        
        Item gatsby = new Item();
        gatsby.setBroughtPrice(BigDecimal.valueOf(500.00));
        gatsby.setItemName("Gatsby");
        gatsby.setProfit(BigDecimal.valueOf(50.00));
        gatsby.setSellingPrice(BigDecimal.valueOf(40.00));
        
        Item juice = new Item();
        juice.setBroughtPrice(BigDecimal.valueOf(300.00));
        juice.setItemName("Juice");
        juice.setProfit(BigDecimal.valueOf(10.00));
        juice.setSellingPrice(BigDecimal.valueOf(90.00));
        
        itemList.add(juice);
        itemList.add(gatsby);
        
        Stock stock = new Stock();
        stock.setCost(BigDecimal.valueOf(25.00));
        stock.setItem(itemList);
        
        stockList.add(stock);
        
        Cafeteria caf = new Cafeteria();
        caf.setCafeName("Scala Junction");
        caf.setCafeBuilding("Engineering");
        caf.setContact(contact);
        caf.setStock(stockList);
        repo.save(caf);
        id = caf.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Cafeteria caf = repo.findOne(id);
        Assert.assertEquals("Scala Junction", caf.getCafeName());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Cafeteria caf = repo.findOne(id);
        caf.setCafeBuilding("Commerce");
        repo.save(caf);
        
        Cafeteria updatedCaf = repo.findOne(id);
        Assert.assertEquals("Commerce", updatedCaf.getCafeBuilding());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testRemove()
    {
        Cafeteria caf = repo.findOne(id);
        repo.delete(caf);
        
        Cafeteria deletedCaf = repo.findOne(id);
        Assert.assertNull(deletedCaf);
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
