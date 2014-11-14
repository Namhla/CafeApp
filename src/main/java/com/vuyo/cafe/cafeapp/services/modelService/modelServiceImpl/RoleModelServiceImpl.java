/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.services.modelService.modelServiceImpl;

import com.google.common.collect.ImmutableList;
import com.vuyo.cafe.cafeapp.client.web.model.RoleModel;
import com.vuyo.cafe.cafeapp.domain.Roles;
import com.vuyo.cafe.cafeapp.repository.RolesRepository;
import com.vuyo.cafe.cafeapp.services.modelService.RoleModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author namhla
 */
@Service("roleModelService")
public class RoleModelServiceImpl implements RoleModelService{
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public List<Roles> createRole(RoleModel model) {
        Roles roles = new Roles();
        roles.setRoleName(model.getRoleName());
        roles.setDescription(model.getDescription());
        
        rolesRepository.save(roles);
        return  ImmutableList.copyOf(rolesRepository.findAll());
       }

    @Override
    public List<Roles> deleteRole(Long id) {
      Roles role = rolesRepository.findOne(id);
      rolesRepository.delete(role);
      return ImmutableList.copyOf(rolesRepository.findAll());
    
    }

    @Override
    public RoleModel getRoleToedit(Long id) {
        RoleModel roleModel = new RoleModel();
        Roles roles = rolesRepository.findOne(id);
        roleModel.setRoleName(roles.getRoleName());
        roleModel.setDescription(roles.getDescription());
        
        return roleModel;
    }

    @Override
    public List<Roles> updateRole(RoleModel model, Long id) {
      Roles role = rolesRepository.findOne(id);
      role.setRoleName(model.getRoleName());
      role.setDescription(model.getDescription());
      rolesRepository.save(role);
      return ImmutableList.copyOf(rolesRepository.findAll());
    }

    @Override
    public List<Roles> findAll() {
        return ImmutableList.copyOf(rolesRepository.findAll());
    }

    @Override
    public List<Roles> getRoles() {
       return ImmutableList.copyOf(rolesRepository.findAll());
    
    }
    
}
