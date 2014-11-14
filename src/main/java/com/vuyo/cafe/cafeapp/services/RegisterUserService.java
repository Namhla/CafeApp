/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuyo.cafe.cafeapp.services;

import com.vuyo.cafe.cafeapp.domain.AppUser;




/**
 *
 * @author
 */
public interface RegisterUserService extends Service<AppUser, Long> {
    public void registerUser(AppUser user);
    public AppUser getByEmailAddress(String emailAddress);
}
