package com.light.core.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLightInfo is a Querydsl query type for LightInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLightInfo extends EntityPathBase<LightInfo> {

    private static final long serialVersionUID = -1580412125L;

    public static final QLightInfo lightInfo = new QLightInfo("lightInfo");

    public final NumberPath<Integer> activeLightNum = createNumber("activeLightNum", Integer.class);

    public final DateTimePath<java.util.Date> activeTime = createDateTime("activeTime", java.util.Date.class);

    public final NumberPath<Integer> batteryVoltage = createNumber("batteryVoltage", Integer.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> exceptionStatus = createNumber("exceptionStatus", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lightCode = createString("lightCode");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final NumberPath<Double> usedElectricCharge = createNumber("usedElectricCharge", Double.class);

    public final NumberPath<Integer> usedTime = createNumber("usedTime", Integer.class);

    public final StringPath userCode = createString("userCode");

    public QLightInfo(String variable) {
        super(LightInfo.class, forVariable(variable));
    }

    public QLightInfo(Path<? extends LightInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLightInfo(PathMetadata metadata) {
        super(LightInfo.class, metadata);
    }

}

