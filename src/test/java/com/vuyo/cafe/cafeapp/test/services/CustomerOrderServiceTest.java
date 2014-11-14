/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.test.services;

import com.vuyo.cafe.cafeapp.app.conf.ConnectionConfig;
import com.vuyo.cafe.cafeapp.domain.Contact;
import com.vuyo.cafe.cafeapp.domain.Customer;
import com.vuyo.cafe.cafeapp.domain.Demography;
import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.OrderItem;
import com.vuyo.cafe.cafeapp.repository.CustomerRepository;
import com.vuyo.cafe.cafeapp.repository.OrderItemRepository;
import com.vuyo.cafe.cafeapp.repository.StockRepository;
import com.vuyo.cafe.cafeapp.services.CustomerOrderService;
import static com.vuyo.cafe.cafeapp.test.repository.CustomerRepositoryTest.ctx;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class CustomerOrderServiceTest {
    public static ApplicationContext ctx;
    private Long id;
    private CustomerRepository customerRepository;
    private OrderItemRepository orderRepo;
    public CustomerOrderServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
   
     @Test
     public void customerOrderTest() {
         customerRepository = ctx.getBean(CustomerRepository.class);
        orderRepo = ctx.getBean(OrderItemRepository.class);
        
        List<OrderItem> orderList = new ArrayList();
        List<Item> itemList = new ArrayList();
        
        Contact contact = new Contact();
        contact.setCellphone("111 111 1111");
        contact.setEmail("john.doe@deadmail.com");
        contact.setOfficeNumber("222 222 2222");
        
        Demography demo = new Demography();
        demo.setDateOfBirth(null);
        demo.setGender("Unknown");
        demo.setRace("Unknown");
        
        Item item = new Item();
        item.setBroughtPrice(BigDecimal.valueOf(100));
        item.setItemName("Patato Chips");
        item.setProfit(BigDecimal.valueOf(50));
        item.setSellingPrice(BigDecimal.valueOf(110));
        
        itemList.add(item);
        
        OrderItem order = new OrderItem();
        order.setCost(BigDecimal.valueOf(70));
        order.setDate(null);
        order.setItem(itemList);
        order.setOrderID(1);
        order.setQuantity(1);
        
        orderRepo.save(order);
        orderList.add(order);
        
        Customer customer = new Customer();
        customer.setCustomerName("John");
        customer.setCustomerSurname("Doe");
        customer.setContact(contact);
        customer.setDemography(demo);
        customer.setCustomerID(1);
        customer.setOrderItem(orderList);
       customerRepository.save(customer);
       CustomerOrderService customerOrderService = ctx.getBean(CustomerOrderService.class);
       List<OrderItem> orderItems = customerOrderService.customerOrder(customer.getId());
        Assert.assertNotNull(orderItems);
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
