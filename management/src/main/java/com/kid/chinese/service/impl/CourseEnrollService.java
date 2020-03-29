package com.kid.chinese.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.dao.ITeacherDAO;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.model.TbCourse;
import com.kid.chinese.model.TbCourseEnroll;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.dao.ICourseArrangeDAO;
import com.kid.chinese.dao.ICourseDAO;
import com.kid.chinese.dao.ICourseEnrollDAO;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.ICourseArrangeService;
import com.kid.chinese.service.ICourseEnrollService;
import com.kid.chinese.service.ICourseService;
import com.kid.chinese.service.IEmployeeService;


@Service("courseEnrollService")
public class CourseEnrollService extends AbstractService<TbCourseEnroll> implements ICourseEnrollService {

    @Resource(name="courseEnrollDAO")
    private ICourseEnrollDAO dao;
    
    public CourseEnrollService() {
        super();
    }

	@Override
	protected IOperations<TbCourseEnroll> getDao() {
		return this.dao;
	}

	@Override
	public Long findAllTbCourseEnrollCount(String name) {
		return this.dao.findAllTbCourseEnrollCount(name);
	}

	@Override
	public List findAllTbCourseEnroll(int start, int pageSize, String name) {
		return this.dao.findAllTbCourseEnroll(start, pageSize, name);
	}

	@Override
	public boolean saveTbCourseEnroll(TbCourseEnroll TbCourseEnroll) {
		return this.dao.saveTbCourseEnroll(TbCourseEnroll);
	}

	
}