package com.kid.chinese.dao;

import java.util.List;

import com.kid.chinese.model.TbCourseEnroll;
import com.kid.chinese.model.TbTeacher;

public interface ICourseEnrollDAO extends IOperations<TbCourseEnroll> {
	public Long findAllTbCourseEnrollCount(String name);
	public List findAllTbCourseEnroll(int start,int pageSize,String name);
	public boolean saveTbCourseEnroll(TbCourseEnroll TbCourseEnroll);
	
}