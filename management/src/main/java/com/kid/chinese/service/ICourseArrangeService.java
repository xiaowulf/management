package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbCourse;
import com.kid.chinese.model.TbCourseArrangement;

public interface ICourseArrangeService extends IOperations<TbCourseArrangement> {
	public Long findAllTbCourseArrangementCount(String name);
	public List findAllTbCourseArrangement(int start,int pageSize,String name);
	public boolean saveTbCourseArrangement(TbCourseArrangement tbCourseArrangement);
}