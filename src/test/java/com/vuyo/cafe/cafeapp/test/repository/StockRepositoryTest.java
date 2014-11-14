/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.repository;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.Stock;
import com.vuyo.cafe.cafeapp.repository.StockRepository;
import java.math.BigDecimal;
import java.math.MathContext;
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
public class StockRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private StockRepository repo;
    public StockRepositoryTest() {
        
    }
    
    @Test
    public void testCreate()
    {
        repo = ctx.getBean(StockRepository.class);
        List<Item> itemList = new ArrayList();
        
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
        
        itemList.add(gatsby);
        itemList.add(juice);
        
        
        Stock stock = new Stock();
        stock.setCost(BigDecimal.valueOf(1500.0));
        stock.setItem(itemList);
        
        repo.save(stock);
        id = stock.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "testCreate")
    public void testRead()
    {
        Stock stock = repo.findOne(id);
        Assert.assertEquals(BigDecimal.valueOf(1500).longValue(), stock.getCost().longValue());
    }
    
    @Test(dependsOnMethods = "testRead")
    public void testUpdate()
    {
        Stock stock = repo.findOne(id);
        stock.setCost(BigDecimal.valueOf(1000.00));
        repo.save(stock);
        
        Stock updatedStock = repo.findOne(id);
        Assert.assertEquals(BigDecimal.valueOf(1000).longValue(), updatedStock.getCost().longValue());
    }
    
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()
    {
        Stock stock = repo.findOne(id);
        repo.delete(stock);
        
        Stock deletedStock = repo.findOne(id);
        Assert.assertNull(deletedStock);
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
