package com.musinsa.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommonEntity is a Querydsl query type for CommonEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QCommonEntity extends EntityPathBase<CommonEntity> {

    private static final long serialVersionUID = -280843116L;

    public static final QCommonEntity commonEntity = new QCommonEntity("commonEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public QCommonEntity(String variable) {
        super(CommonEntity.class, forVariable(variable));
    }

    public QCommonEntity(Path<? extends CommonEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonEntity(PathMetadata metadata) {
        super(CommonEntity.class, metadata);
    }

}

