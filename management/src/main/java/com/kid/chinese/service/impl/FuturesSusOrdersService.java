package com.kid.chinese.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.model.FuturesOrders;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.model.FuturesSusOrders;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.IFuturesOrdersService;
import com.kid.chinese.service.IFuturesStrategyService;
import com.kid.chinese.service.IFuturesSusOrdersService;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.dao.IFuturesOrdersDAO;
import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.dao.IFuturesSusOrdersDAO;
import com.kid.chinese.service.AbstractService;


@Service("futuresSusOrdersService")
public class FuturesSusOrdersService extends AbstractService<FuturesSusOrders> implements IFuturesSusOrdersService {

    @Resource(name="futuresSusOrdersDAO")
    private IFuturesSusOrdersDAO dao;
    
    public FuturesSusOrdersService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesSusOrders> getDao() {
        return this.dao;
    }
}