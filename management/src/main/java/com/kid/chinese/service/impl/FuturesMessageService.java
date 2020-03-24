package com.kid.chinese.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;


@Service("futuresMessageService")
public class FuturesMessageService extends AbstractService<FuturesMessage> implements IFuturesMessageService {

    @Resource(name="futuresMessageDAO")
    private IFuturesMessageDAO dao;
    
    public FuturesMessageService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesMessage> getDao() {
        return this.dao;
    }
}