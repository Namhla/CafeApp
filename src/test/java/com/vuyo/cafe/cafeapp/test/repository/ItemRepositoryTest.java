/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.RegisteredUser;
import com.vuyo.cafe.cafeapp.repository.ItemRepository;
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
public class ItemRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ItemRepository repo;
    
    public ItemRepositoryTest() {
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(ItemRepository.class);
        
        Item item = new Item();
        item.setBroughtPrice(BigDecimal.valueOf(100));
        item.setItemName("Patato Chips");
        item.setProfit(BigDecimal.valueOf(50));
        item.setSellingPrice(BigDecimal.valueOf(110));
        
        repo.save(item);
        id = item.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Item item = repo.findOne(id);
        Assert.assertEquals(BigDecimal.valueOf(100).longValue(), item.getBroughtPrice().longValue());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Item item = repo.findOne(id);
        item.setItemName("Boerewors Rolls");
        repo.save(item);
        
        Item updatedItem = repo.findOne(id);
        Assert.assertEquals("Boerewors Rolls", updatedItem.getItemName());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Item item = repo.findOne(id);
        repo.delete(item);
        
        Item deletedItem = repo.findOne(id);
        Assert.assertNull(deletedItem);
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
