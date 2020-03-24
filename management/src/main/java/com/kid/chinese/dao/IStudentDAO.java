package com.kid.chinese.dao;

import java.util.List;

import com.kid.chinese.model.TbStudent;

public interface IStudentDAO extends IOperations<TbStudent> {
	public Long findAllTbStudentCount(String name);
	public List findAllTbStudent(int start,int pageSize,String name);
}