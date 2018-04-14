package com.light.core.impl;

import com.light.core.entity.LightInfo;
import com.light.core.entity.QLightInfo;
import com.light.core.repository.LightInfoJpaRepository;
import com.light.core.service.ILightInfoService;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
@Transactional
public class LightInfoServiceImpl implements ILightInfoService {
    private Logger logger = LoggerFactory.getLogger(LightInfoServiceImpl.class);
    private JPAQueryFactory queryFactory;
    //实体管理者
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LightInfoJpaRepository lightInfoJpaRepository;


    @PostConstruct
    public void initFactory()
    {
        queryFactory = new JPAQueryFactory(entityManager);
        logger.info("init JPAQueryFactory successfully");
    }
    @Override
    public List<LightInfo> findAll() {
        return lightInfoJpaRepository.findAll();
    }

    @Override
    public void saveLightInfo(LightInfo user) {

    }

    @Override
    public LightInfo findOneById(long id) {
        return null;
    }

    @Override
    public Page<LightInfo> findAll(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page,size, Sort.Direction.ASC,"id");
        return lightInfoJpaRepository.findAll(pageable);
    }

    @Override
    public Page<LightInfo> findAllByCretiaPage(Integer page, Integer size, Predicate predicate) {
        Pageable pageable = new PageRequest(page,size, Sort.Direction.ASC,"id");
        Page<LightInfo> lightInfos = lightInfoJpaRepository.findAll(predicate,pageable);
        return lightInfos;
    }

    @Override
    public int updateLightInfoById(int id,LightInfo lightInfo){
        QLightInfo qLightInfo = QLightInfo.lightInfo;

        long updateResult = queryFactory.update(qLightInfo)
                .set(qLightInfo.lightCode,lightInfo.getLightCode())
                .set(qLightInfo.userCode,lightInfo.getUserCode())
                .where(qLightInfo.id.eq(lightInfo.getId()))
        .execute();
        return (int)updateResult;
    }
}
