package com.kid.chinese.dao;

import java.util.List;

import com.kid.chinese.model.TbCourseCategory;
import com.kid.chinese.model.TbCourseCategory;

public interface ICourseCategoryDAO extends IOperations<TbCourseCategory> {
	public Long findAllTbCourseCategoryCount(String name);
	public List findAllTbCourseCategory(int start,int pageSize,String name);
	public boolean saveTbCourseCategory(TbCourseCategory TbCourseCategory);
	public TbCourseCategory findAllTbCourseCategoryByCode(String code);
	
}