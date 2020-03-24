package com.kid.chinese.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.dao.ITeacherDAO;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.TbCourseCategory;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.dao.ICourseCategoryDAO;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.ICourseCategoryService;
import com.kid.chinese.service.IEmployeeService;


@Service("courseCategoryService")
public class CourseCategoryService extends AbstractService<TbCourseCategory> implements ICourseCategoryService {

    @Resource(name="courseCategoryDAO")
    private ICourseCategoryDAO dao;
    
    public CourseCategoryService() {
        super();
    }
    @Override
    protected IOperations<TbCourseCategory> getDao() {
        return this.dao;
    }
	@Override
	public Long findAllTbCourseCategoryCount(String name) {
		return this.dao.findAllTbCourseCategoryCount(name);
	}
	@Override
	public List findAllTbCourseCategory(int start, int pageSize, String name) {
		return this.dao.findAllTbCourseCategory(start, pageSize, name);
	}
	@Override
	public boolean saveTbCourseCategory(TbCourseCategory TbCourseCategory) {
		return this.dao.saveTbCourseCategory(TbCourseCategory);
	}
	@Override
	public TbCourseCategory findAllTbCourseCategoryByCode(String code) {
		return this.dao.findAllTbCourseCategoryByCode(code);
	}
}