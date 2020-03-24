package com.kid.chinese.dao.impl;
import org.springframework.stereotype.Repository;

import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.dao.AbstractHibernateDAO;

@Repository("futuresStrategyDAO")
public class FuturesStrategyDAO extends AbstractHibernateDAO<FuturesStrategy> implements IFuturesStrategyDAO {

    public FuturesStrategyDAO() {
        super();
        setClazz(FuturesStrategy.class);
    }
}