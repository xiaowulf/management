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
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.dao.ICourseDAO;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.ICourseService;
import com.kid.chinese.service.IEmployeeService;


@Service("courseService")
public class CourseService extends AbstractService<TbCourse> implements ICourseService {

    @Resource(name="courseDAO")
    private ICourseDAO dao;
    
    public CourseService() {
        super();
    }

	@Override
	protected IOperations<TbCourse> getDao() {
		return this.dao;
	}

	@Override
	public Long findAllTbCourseCount(String name) {
		return this.dao.findAllTbCourseCount(name);
	}

	@Override
	public List findAllTbCourse(int start, int pageSize, String name) {
		return this.dao.findAllTbCourse(start, pageSize, name);
	}

	@Override
	public boolean saveTbCourse(TbCourse tbCourse) {
		return this.dao.saveTbCourse(tbCourse);
	}

	@Override
	public TbCourse findAllTbCourseByCourseName(String coursename) {
		return this.dao.findAllTbCourseByCode(coursename);
	}
}