package com.kid.chinese.dao.impl;
import org.springframework.stereotype.Repository;

import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.dao.IFuturesSusOrdersDAO;
import com.kid.chinese.model.FuturesOrders;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.model.FuturesSusOrders;
import com.kid.chinese.dao.AbstractHibernateDAO;
import com.kid.chinese.dao.IFuturesOrdersDAO;

@Repository("futuresSusOrdersDAO")
public class FuturesSusOrdersDAO extends AbstractHibernateDAO<FuturesSusOrders> implements IFuturesSusOrdersDAO {

    public FuturesSusOrdersDAO() {
        super();
        setClazz(FuturesSusOrders.class);
    }
}