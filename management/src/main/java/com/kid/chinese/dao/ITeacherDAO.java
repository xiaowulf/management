package com.kid.chinese.dao;

import java.util.List;

import com.kid.chinese.model.TbTeacher;

public interface ITeacherDAO extends IOperations<TbTeacher> {
	public Long findAllTbTeacherCount(String name);
	public List findAllTbTeacher(int start,int pageSize,String name);
	public boolean saveTbTeacher(TbTeacher tbTeacher);
	public TbTeacher findAllTbTeacherByUsername(String username);
	
}