package com.kid.chinese.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.IEmployeeService;

@Service("employeeService")
public class EmployeeService extends AbstractService<TbEmployee> implements IEmployeeService {

	@Resource(name = "employeeDAO")
	private IEmployeeDAO dao;

	public EmployeeService() {
		super();
	}

	@Override
	protected IOperations<TbEmployee> getDao() {
		return this.dao;
	}

	@Override
	public TbEmployee findEmployeeByNameAndPwd(String username, String pwd) {
		return this.dao.findEmployeeByNameAndPwd(username, pwd);
	}

	@Override
	public Long findAllTbEmployeeCount(String name) {
		return this.dao.findAllTbEmployeeCount(name);
	}

	@Override
	public List findAllTbEmployee(int start, int pageSize, String name) {
		return this.dao.findAllTbEmployee(start, pageSize, name);
	}

	@Override
	public void saveTbEmployee(TbEmployee tbEmployee) {
		this.dao.saveTbEmployee(tbEmployee);
	}
}