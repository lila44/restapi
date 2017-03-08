package com.jeongchae.sample.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSample is a Querydsl query type for Sample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSample extends EntityPathBase<Sample> {

    private static final long serialVersionUID = 1793377749L;

    public static final QSample sample = new QSample("sample");

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.util.Date> regDate = createDateTime("regDate", java.util.Date.class);

    public final NumberPath<Long> sampleNo = createNumber("sampleNo", Long.class);

    public final StringPath title = createString("title");

    public final StringPath userId = createString("userId");

    public QSample(String variable) {
        super(Sample.class, forVariable(variable));
    }

    public QSample(Path<? extends Sample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSample(PathMetadata metadata) {
        super(Sample.class, metadata);
    }

}

