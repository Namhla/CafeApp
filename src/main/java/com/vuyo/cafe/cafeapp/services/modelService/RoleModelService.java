/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.services.modelService;

import com.vuyo.cafe.cafeapp.client.web.model.RoleModel;
import com.vuyo.cafe.cafeapp.domain.Roles;
import java.util.List;

/**
 *
 * @author namhla
 */
public interface RoleModelService {
    
    public List<Roles> createRole(RoleModel model);
    public List<Roles> deleteRole(Long id);
    public RoleModel getRoleToedit( Long id);
    public List<Roles> updateRole(RoleModel model,Long id);
    public List<Roles> getRoles();
    public List<Roles> findAll();
    
}
