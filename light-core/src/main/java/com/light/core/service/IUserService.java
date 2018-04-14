package com.light.core.service;

import com.light.core.entity.User;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IUserService<T>
{
    public List<User> findAll();

    public void saveUser(User user);
   
    public User findOne(long id);

    public void delete(long id);

    public List<User> findByName(String name);

    Page<User> findAll(Integer page, Integer size);

    Page<User> findAllByCretiaPage(Integer page, Integer size, Predicate predicate);

}