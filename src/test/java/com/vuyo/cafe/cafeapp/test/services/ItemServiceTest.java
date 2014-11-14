/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.services;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.Stock;
import com.vuyo.cafe.cafeapp.repository.StockRepository;
import com.vuyo.cafe.cafeapp.services.ItemsService;
import static com.vuyo.cafe.cafeapp.test.repository.CafeteriaRepositoryTest.ctx;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author namhla
 */
public class ItemServiceTest {
   private StockRepository stockRepository;
    private static ApplicationContext ctx;
    private ItemsService itemListService;
    
    private Long id;
    public ItemServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void itemServiceTest() {
     stockRepository = ctx.getBean(StockRepository.class);
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
        stock.setItem(itemList);;
        
        itemListService = ctx.getBean(ItemsService.class);
        List<Item> itemArr =  itemListService.itemList(itemList.get(0).getId());
        Assert.assertNotNull(itemArr);
        for (Item ite : itemArr) {
            System.out.println(ite.getItemName());
            System.out.println("Item:00000");
            
         }     
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
