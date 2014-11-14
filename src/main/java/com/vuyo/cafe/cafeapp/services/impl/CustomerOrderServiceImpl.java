/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.services.impl;

import com.vuyo.cafe.cafeapp.domain.Customer;
import com.vuyo.cafe.cafeapp.domain.OrderItem;
import com.vuyo.cafe.cafeapp.repository.CustomerRepository;
import com.vuyo.cafe.cafeapp.services.CustomerOrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author namhla
 */
@Service("customerOrderService")
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private CustomerRepository customerRepository;
    public List<OrderItem> customerOrder(Long id){
        
        List<Customer> customers = customerRepository.findAll();
        List<OrderItem> orderItems = new  ArrayList<OrderItem>();
        for(Customer customer: customers)
        {
            if (customer.getId() == id)
            {
                orderItems = customer.getOrderItem();
            }
           
        }
        return orderItems;

    }
    
}
