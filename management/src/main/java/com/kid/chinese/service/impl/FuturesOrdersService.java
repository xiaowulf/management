package com.kid.chinese.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.model.FuturesOrders;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.IFuturesOrdersService;
import com.kid.chinese.service.IFuturesStrategyService;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.dao.IFuturesOrdersDAO;
import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.service.AbstractService;


@Service("futuresOrdersService")
public class FuturesOrdersService extends AbstractService<FuturesOrders> implements IFuturesOrdersService {

    @Resource(name="futuresOrdersDAO")
    private IFuturesOrdersDAO dao;
    
    public FuturesOrdersService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesOrders> getDao() {
        return this.dao;
    }
}