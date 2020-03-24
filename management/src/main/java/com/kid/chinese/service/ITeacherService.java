package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.TbTeacher;

public interface ITeacherService extends IOperations<TbTeacher> {
	public Long findAllTbTeacherCount(String name);
	public List findAllTbTeacher(int start,int pageSize,String name);
	public boolean saveTbTeacher(TbTeacher tbTeacher);
	public TbTeacher findAllTbTeacherByUsername(String username);
}