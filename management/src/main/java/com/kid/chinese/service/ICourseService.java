package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbCourse;

public interface ICourseService extends IOperations<TbCourse> {
	public Long findAllTbCourseCount(String name);
	public List findAllTbCourse(int start,int pageSize,String name);
	public boolean saveTbCourse(TbCourse TbCourse);
	public TbCourse findAllTbCourseByCourseName(String coursename);
}