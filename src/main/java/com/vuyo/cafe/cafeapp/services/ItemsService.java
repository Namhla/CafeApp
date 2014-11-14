/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuyo.cafe.cafeapp.services;

import com.vuyo.cafe.cafeapp.domain.Item;
import java.util.List;

/**
 *
 * @author namhla
 */
public interface ItemsService {
    
    public List<Item> itemList(Long id);
    
}
