/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Cafeteria;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.StockOrder;
import com.vuyo.cafe.cafeapp.repository.CafeteriaRepository;
import com.vuyo.cafe.cafeapp.repository.ItemRepository;
import com.vuyo.cafe.cafeapp.repository.StockOrderRepository;
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
public class StockOrderRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private StockOrderRepository repo;
    private CafeteriaRepository cafeRepo;
    private ItemRepository itemRepo;
    
    public StockOrderRepositoryTest() {
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(StockOrderRepository.class);
        cafeRepo = ctx.getBean(CafeteriaRepository.class);
        itemRepo = ctx.getBean(ItemRepository.class);
        
        List<Item> itemList = new ArrayList();
        
        Item item = new Item();
        item.setBroughtPrice(BigDecimal.valueOf(500.00));
        item.setItemName("Pie");
        item.setProfit(BigDecimal.valueOf(300.00));
        item.setSellingPrice(BigDecimal.valueOf(13.00));
        
        Item item2 = new Item();
        item2.setBroughtPrice(BigDecimal.valueOf(500.00));
        item2.setItemName("Dougnut");
        item2.setProfit(BigDecimal.valueOf(300.00));
        item2.setSellingPrice(BigDecimal.valueOf(13.00));
        
        Item item3 = new Item();
        item3.setBroughtPrice(BigDecimal.valueOf(500.00));
        item3.setItemName("Chips");
        item3.setProfit(BigDecimal.valueOf(300.00));
        item3.setSellingPrice(BigDecimal.valueOf(13.00));
        
        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);
        
        itemRepo.save(item);
        itemRepo.save(item2);
        itemRepo.save(item3);
        
        Cafeteria caf = new Cafeteria();
        caf.setCafeBuilding("Commerce");
        caf.setCafeName("Scala Junction");
        caf.setContact(null);
        caf.setStock(null);
        
        cafeRepo.save(caf);
        
        StockOrder order = new StockOrder();
        order.setCafeteria(caf);
        order.setItem(itemList);
        order.setQuantity(100);
        
        repo.save(order);
        id = order.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        StockOrder order = repo.findOne(id);
        Assert.assertEquals(3, order.getItem().size());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        StockOrder order = repo.findOne(id);
        order.setQuantity(50);
        repo.save(order);
        
        StockOrder updatedOrder = repo.findOne(id);
        Assert.assertEquals(50, updatedOrder.getQuantity());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        StockOrder order = repo.findOne(id);
        repo.delete(order);
        
        StockOrder deletedOrder = repo.findOne(id);
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
