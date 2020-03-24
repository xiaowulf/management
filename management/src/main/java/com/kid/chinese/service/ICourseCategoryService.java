package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbCourseCategory;

public interface ICourseCategoryService extends IOperations<TbCourseCategory> {
	public Long findAllTbCourseCategoryCount(String name);
	public List findAllTbCourseCategory(int start,int pageSize,String name);
	public boolean saveTbCourseCategory(TbCourseCategory TbCourseCategory);
	public TbCourseCategory findAllTbCourseCategoryByCode(String code);
}