/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.services.modelService.modelServiceImpl;

import com.google.common.collect.ImmutableList;
import com.vuyo.cafe.cafeapp.client.web.model.CustomerModel;
import com.vuyo.cafe.cafeapp.domain.Customer;
import com.vuyo.cafe.cafeapp.domain.Roles;
import com.vuyo.cafe.cafeapp.repository.CustomerRepository;
import com.vuyo.cafe.cafeapp.services.modelService.CustomerModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author namhla
 */
@Service
public class CustomerModelServiceImpl implements CustomerModelService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> createCustomer(CustomerModel model){
        Customer customers = new Customer();
        customers.setCustomerID(model.getCustomerID());
        customers.setCustomerName(model.getCustomerName());
        customers.setCustomerSurname(model.getCustomerSurname());
        
        customerRepository.save(customers);
        return  ImmutableList.copyOf(customerRepository.findAll());
    }

    @Override
    public List<Customer> deleteCustomer(Long id) {
       Customer customers = customerRepository.findOne(id);
      customerRepository.delete(customers);
      return ImmutableList.copyOf(customerRepository.findAll());
    }

    @Override
    public CustomerModel getCustomerToedit(Long id) {
        CustomerModel customerModel = new CustomerModel();
        Customer customers = customerRepository.findOne(id);
        customerModel.setCustomerID(customers.getCustomerID());
        customerModel.setCustomerName(customers.getCustomerName());
        customerModel.setCustomerSurname(customers.getCustomerSurname());
        
        return customerModel;
    }

    @Override
    public List<Customer> updateCustomer(CustomerModel model, Long id) {
        Customer customers = customerRepository.findOne(id);
      customers.setCustomerName(model.getCustomerName());
      customers.setCustomerSurname(model.getCustomerSurname());
      customerRepository.save(customers);
      return ImmutableList.copyOf(customerRepository.findAll());
    }

    @Override
    public List<Customer> getCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
}
