/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuyo.cafe.cafeapp.services.impl;

import com.vuyo.cafe.cafeapp.domain.Item;
import com.vuyo.cafe.cafeapp.domain.Stock;
import com.vuyo.cafe.cafeapp.domain.StockOrder;
import com.vuyo.cafe.cafeapp.repository.ItemRepository;
import com.vuyo.cafe.cafeapp.repository.StockOrderRepository;
import com.vuyo.cafe.cafeapp.repository.StockRepository;
import com.vuyo.cafe.cafeapp.services.ItemsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*import com.cafeteria.system.app.factory.ContactFactory;
import com.cafeteria.system.app.factory.DemographyFactory;
import com.cafeteria.system.app.factory.EmployeeFactory;
import com.cafeteria.system.app.factory.ItemFactory;
import com.cafeteria.system.client.web.model.EmployeeModel;
import com.cafeteria.system.client.web.model.ItemModel;
import com.cafeteria.system.domain.Contact;
import com.cafeteria.system.domain.Demography;
import com.cafeteria.system.domain.Employee;
import com.cafeteria.system.domain.Item;
import com.cafeteria.system.services.ItemsService;
import com.cafeteria.system.services.crud.ItemCrudService;
import com.cafeteria.system.services.crud.ItemService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;*/

/**
 *
 * @author namhla
 */
@Service("itemService")
public class ItemServiceImpl implements ItemsService{
 @Autowired
    private StockRepository stockService;
    private ItemRepository itemRepositoryService;
    
    @Override
     public List<Item> itemList(Long id) {
        List<Stock> stockList = stockService.findAll();
        List<Item> itemList = new ArrayList<Item>();
        for(Stock stock: stockList)
        {
                if(stock.getId()== id)
                {
                    itemList = stock.getItem();
                }
        }
    
    return itemList;
    }

  
    
}
