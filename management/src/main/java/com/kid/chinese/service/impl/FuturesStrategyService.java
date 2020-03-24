package com.kid.chinese.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.IFuturesStrategyService;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.dao.IFuturesStrategyDAO;
import com.kid.chinese.service.AbstractService;


@Service("futuresStrategyService")
public class FuturesStrategyService extends AbstractService<FuturesStrategy> implements IFuturesStrategyService {

    @Resource(name="futuresStrategyDAO")
    private IFuturesStrategyDAO dao;
    
    public FuturesStrategyService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesStrategy> getDao() {
        return this.dao;
    }
}