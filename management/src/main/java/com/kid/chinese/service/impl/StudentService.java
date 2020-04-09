package com.kid.chinese.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.dao.IStudentDAO;
import com.kid.chinese.dao.ITeacherDAO;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.TbStudent;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.IStudentService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.IEmployeeService;


@Service("studentService")
public class StudentService extends AbstractService<TbStudent> implements IStudentService {

    @Resource(name="studentDAO")
    private IStudentDAO dao;
    
    public StudentService() {
        super();
    }
    @Override
    protected IOperations<TbStudent> getDao() {
        return this.dao;
    }
	@Override
	public Long findAllTbStudentCount(String name) {
		return dao.findAllTbStudentCount(name);
	}
	@Override
	public List findAllTbStudent(int start, int pageSize, String name) {
		return dao.findAllTbStudent(start, pageSize, name);
	}
	@Override
	public boolean saveTbStudent(TbStudent tbStudent) {
		return this.dao.saveTbStudent(tbStudent);
	}
	@Override
	public TbStudent findAllTbStudentByUsername(String username) {
		return this.dao.findAllTbStudentByUsername(username);
	}
}