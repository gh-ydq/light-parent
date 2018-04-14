package com.light.core.impl;

import com.light.core.entity.User;
import com.light.core.repository.UserJpaRepository;
import com.light.core.repository.UserRepository;
import com.light.core.service.IUserService;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userJpaRepository.findAll();
    }

    public List<User> findByName(String name)
    {
        List<User> userList1 = userRepository.findByName1(name);
        List<User> userList2 = userRepository.findByName2(name);
        List<User> userList3 = userRepository.findByNameAndAddress(name, "3");
        System.out.println("userList1:" + userList1);
        System.out.println("userList2:" + userList2);
        System.out.println("userList3:" + userList3);
        return userRepository.findByName(name);
    }

    public void saveUser(User book)
    {
        userJpaRepository.save(book);
    }

    @Cacheable("users")
    public User findOne(long id)
    {
        System.out.println("Cached Pages");
        return userJpaRepository.findOne(id);
    }

    public void delete(long id)
    {
        userJpaRepository.delete(id);
    }

    public Iterable<User> findByUserExpression(BooleanExpression booleanExpression){
        Iterable<User> users = userJpaRepository.findAll(booleanExpression);
        return users;
    }

    @Override
    public Page<User> findAll(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return userJpaRepository.findAll(pageable);
    }


    @Override
    public Page<User> findAllByCretiaPage(Integer page, Integer size, Predicate predicate) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<User> userPage = userJpaRepository.findAll(predicate,pageable);
        return userPage;
    }
}