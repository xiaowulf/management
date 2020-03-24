package com.kid.chinese.dao.impl;
import org.springframework.stereotype.Repository;

import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.model.FuturesOrders;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.dao.AbstractHibernateDAO;
import com.kid.chinese.dao.IFuturesOrdersDAO;

@Repository("futuresOrdersDAO")
public class FuturesOrdersDAO extends AbstractHibernateDAO<FuturesOrders> implements IFuturesOrdersDAO {

    public FuturesOrdersDAO() {
        super();
        setClazz(FuturesOrders.class);
    }
}