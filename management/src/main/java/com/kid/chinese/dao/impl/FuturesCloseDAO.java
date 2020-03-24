package com.kid.chinese.dao.impl;
import org.springframework.stereotype.Repository;

import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.model.FuturesClose;
import com.kid.chinese.dao.AbstractHibernateDAO;
import com.kid.chinese.dao.IFuturesCloseDAO;

@Repository("futuresCloseDAO")
public class FuturesCloseDAO extends AbstractHibernateDAO<FuturesClose> implements IFuturesCloseDAO {

    public FuturesCloseDAO() {
        super();
        setClazz(FuturesClose.class);
    }
}