package com.kid.chinese.dao.impl;
import org.springframework.stereotype.Repository;

import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.dao.AbstractHibernateDAO;

@Repository("futuresMessageDAO")
public class FuturesMessageDAO extends AbstractHibernateDAO<FuturesMessage> implements IFuturesMessageDAO {

    public FuturesMessageDAO() {
        super();
        setClazz(FuturesMessage.class);
    }
}