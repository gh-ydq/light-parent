package com.light.core.service;

import com.light.core.entity.LightInfo;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ILightInfoService<T>
{
    List<LightInfo> findAll();

    void saveLightInfo(LightInfo user);
   
    LightInfo findOneById(long id);

    Page<LightInfo> findAll(Integer page, Integer size);

    Page<LightInfo> findAllByCretiaPage(Integer page, Integer size, Predicate predicate);

    int updateLightInfoById(int id,LightInfo lightInfo);
}