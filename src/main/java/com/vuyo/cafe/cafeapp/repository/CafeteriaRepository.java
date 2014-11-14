/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vuyo.cafe.cafeapp.repository;

import com.vuyo.cafe.cafeapp.domain.Cafeteria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author namhla
 */
public interface CafeteriaRepository extends JpaRepository<Cafeteria, Long> {
    
}
