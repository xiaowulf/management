package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbStudent;
import com.kid.chinese.model.TbTeacher;

public interface IStudentService extends IOperations<TbStudent> {
	public Long findAllTbStudentCount(String name);
	public List findAllTbStudent(int start,int pageSize,String name);
	public boolean saveTbStudent(TbStudent tbStudent);
	public TbStudent findAllTbStudentByUsername(String username);
}