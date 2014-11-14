/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.OrderItem;
import com.vuyo.cafe.cafeapp.domain.RegisteredUser;
import com.vuyo.cafe.cafeapp.repository.OrderItemRepository;
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
public class OrderItemRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private OrderItemRepository repo;
    
    public OrderItemRepositoryTest() {
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(OrderItemRepository.class);
        List<Item>itemList = new ArrayList();
        
        Item item = new Item();
        item.setBroughtPrice(BigDecimal.valueOf(100));
        item.setItemName("Bread Rolls");
        item.setProfit(BigDecimal.valueOf(10));
        item.setSellingPrice(BigDecimal.valueOf(7));
        
        Item item2 = new Item();
        item2.setBroughtPrice(BigDecimal.valueOf(600));
        item2.setItemName("Burgers");
        item2.setProfit(BigDecimal.valueOf(150));
        item2.setSellingPrice(BigDecimal.valueOf(20));
        
        itemList.add(item);
        itemList.add(item2);
        
        OrderItem orderItem = new OrderItem();
        orderItem.setCost(BigDecimal.valueOf(5000));
        orderItem.setDate(null);
        orderItem.setQuantity(10);
        orderItem.setItem(itemList);
        
        repo.save(orderItem);
        id = orderItem.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        OrderItem item = repo.findOne(id);
        Assert.assertEquals(BigDecimal.valueOf(5000).longValue(), item.getCost().longValue());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        OrderItem order = repo.findOne(id);
        order.setQuantity(50);
        repo.save(order);
        
        OrderItem updatedOrder = repo.findOne(id);
        Assert.assertEquals(50, updatedOrder.getQuantity());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        OrderItem order = repo.findOne(id);
        repo.delete(order);
        
        OrderItem deletedOrder = repo.findOne(id);
        Assert.assertNull(deletedOrder);
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
