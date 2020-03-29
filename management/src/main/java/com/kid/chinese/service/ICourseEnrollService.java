package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbCourseEnroll;

public interface ICourseEnrollService extends IOperations<TbCourseEnroll> {
	public Long findAllTbCourseEnrollCount(String name);
	public List findAllTbCourseEnroll(int start,int pageSize,String name);
	public boolean saveTbCourseEnroll(TbCourseEnroll TbCourseEnroll);
}