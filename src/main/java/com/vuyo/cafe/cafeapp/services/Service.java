/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuyo.cafe.cafeapp.services;

import java.util.List;

/**
 *
 * @author vuyo
 * @param <T>
 * @param <ID>
 */
public interface Service<T, ID> {

    public T findById(final ID id);

    public List<T> findAll();

    public void persist(final T entity);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeById(final Long entityId);

}
