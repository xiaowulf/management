package com.kid.chinese.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.dao.ITeacherDAO;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.IEmployeeService;


@Service("teacherService")
public class TeacherService extends AbstractService<TbTeacher> implements ITeacherService {

    @Resource(name="teacherDAO")
    private ITeacherDAO dao;
    
    public TeacherService() {
        super();
    }
    @Override
    protected IOperations<TbTeacher> getDao() {
        return this.dao;
    }
	@Override
	public Long findAllTbTeacherCount(String name) {
		return this.dao.findAllTbTeacherCount(name);
	}
	@Override
	public List findAllTbTeacher(int start, int pageSize, String name) {
		return this.dao.findAllTbTeacher(start, pageSize, name);
	}
	@Override
	public boolean saveTbTeacher(TbTeacher tbTeacher) {
		return this.dao.saveTbTeacher(tbTeacher);
	}
	@Override
	public TbTeacher findAllTbTeacherByUsername(String username) {
		return this.dao.findAllTbTeacherByUsername(username);
	}
}