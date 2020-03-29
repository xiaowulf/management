package com.kid.chinese.dao;

import java.util.List;

import com.kid.chinese.model.TbCourseArrangement;
import com.kid.chinese.model.TbTeacher;

public interface ICourseArrangeDAO extends IOperations<TbCourseArrangement> {
	public Long findAllTbCourseArrangementCount(String name);
	public List findAllTbCourseArrangement(int start,int pageSize,String name);
	public boolean saveTbCourseArrangement(TbCourseArrangement tbCourseArrangement);
	
}