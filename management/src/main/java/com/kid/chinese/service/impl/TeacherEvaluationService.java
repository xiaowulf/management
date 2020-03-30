package com.kid.chinese.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.dao.ITeacherDAO;
import com.kid.chinese.dao.ITeacherEvaluationDAO;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.model.TbTeacherEvaluation;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.ITeacherEvaluationService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.dao.IEmployeeDAO;
import com.kid.chinese.dao.IFuturesMessageDAO;
import com.kid.chinese.service.AbstractService;
import com.kid.chinese.service.IEmployeeService;


@Service("teacherEvaluationService")
public class TeacherEvaluationService extends AbstractService<TbTeacherEvaluation> implements ITeacherEvaluationService {

    @Resource(name="teacherEvaluationDAO")
    private ITeacherEvaluationDAO dao;
    
    public TeacherEvaluationService() {
        super();
    }
    @Override
    protected IOperations<TbTeacherEvaluation> getDao() {
        return this.dao;
    }
	@Override
	public List findAllTbTeacherEvaluation(int start, int pageSize, String name) {
		return this.dao.findAllTbTeacherEvaluation(start, pageSize, name);
	}
	@Override
	public List findAllTbTeacherEvaluationByTeacherId(Long teacher_id) {
		return this.dao.findAllTbTeacherEvaluationByTeacherId(teacher_id);
	}
	@Override
	public Long findAllTbTeacherEvaluationCount(Long teacher_id) {
		return this.dao.findAllTbTeacherEvaluationCount(teacher_id);
	}
	@Override
	public List findAllTbTeacherEvaluation(int start, int pageSize, Long teacher_id) {
		return this.dao.findAllTbTeacherEvaluation(start, pageSize, teacher_id);
	}
	
}