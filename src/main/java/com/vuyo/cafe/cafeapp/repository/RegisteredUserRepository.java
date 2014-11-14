/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.repository;

import com.vuyo.cafe.cafeapp.domain.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author namhla
 */
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    
}
