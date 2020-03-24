package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbEmployee;

public interface IEmployeeService extends IOperations<TbEmployee> {
	TbEmployee findEmployeeByNameAndPwd(String username, String pwd);
	public Long findAllTbEmployeeCount(String name);
	public List findAllTbEmployee(int start,int pageSize,String name);
	public void saveTbEmployee(TbEmployee tbEmployee);
}