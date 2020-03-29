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
import com.kid.chinese.model.TbCourseArrangement;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.dao.ICourseArrangeDAO;
import com.kid.chinese.dao.ICourseDAO;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.ICourseArrangeService;
import com.kid.chinese.service.ICourseService;
import com.kid.chinese.service.IEmployeeService;


@Service("courseArrangeService")
public class CourseArrangeService extends AbstractService<TbCourseArrangement> implements ICourseArrangeService {

    @Resource(name="courseArrangeDAO")
    private ICourseArrangeDAO dao;
    
    public CourseArrangeService() {
        super();
    }

	@Override
	protected IOperations<TbCourseArrangement> getDao() {
		return this.dao;
	}

	@Override
	public Long findAllTbCourseArrangementCount(String name) {
		return this.dao.findAllTbCourseArrangementCount(name);
	}

	@Override
	public List findAllTbCourseArrangement(int start, int pageSize, String name) {
		return this.dao.findAllTbCourseArrangement(start, pageSize, name);
	}

	@Override
	public boolean saveTbCourseArrangement(TbCourseArrangement tbCourseArrangement) {
		return this.dao.saveTbCourseArrangement(tbCourseArrangement);
	}

	
}