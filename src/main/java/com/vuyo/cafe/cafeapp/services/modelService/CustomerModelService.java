/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.services.modelService;

import com.vuyo.cafe.cafeapp.client.web.model.CustomerModel;
import com.vuyo.cafe.cafeapp.domain.Customer;
import java.util.List;

/**
 *
 * @author namhla
 */
public interface CustomerModelService {
    
    public List<Customer> createCustomer(CustomerModel model);
    public List<Customer> deleteCustomer(Long id);
    public CustomerModel getCustomerToedit( Long id);
    public List<Customer> updateCustomer(CustomerModel model,Long id);
    public List<Customer> getCustomer();
    public List<Customer> findAll();
    
}
