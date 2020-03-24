package com.kid.chinese.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.FuturesClose;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.model.FuturesOrders;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.IFuturesOrdersService;
import com.kid.chinese.service.IFuturesStrategyService;
import com.kid.chinese.dao.IFuturesCloseDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.dao.IFuturesOrdersDAO;
import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.IFuturesCloseService;


@Service("futuresCloseService")
public class FuturesCloseService extends AbstractService<FuturesClose> implements IFuturesCloseService {

    @Resource(name="futuresCloseDAO")
    private IFuturesCloseDAO dao;
    
    public FuturesCloseService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesClose> getDao() {
        return this.dao;
    }
}