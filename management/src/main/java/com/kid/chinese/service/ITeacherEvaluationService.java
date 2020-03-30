package com.kid.chinese.service;
import java.util.List;

import com.kid.chinese.dao.IOperations;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.model.TbTeacherEvaluation;

public interface ITeacherEvaluationService extends IOperations<TbTeacherEvaluation> {
	public List findAllTbTeacherEvaluation(int start,int pageSize,String name);
	public List findAllTbTeacherEvaluationByTeacherId(Long teacher_id);
	public Long findAllTbTeacherEvaluationCount(Long teacher_id);
	public List findAllTbTeacherEvaluation(int start,int pageSize,Long teacher_id);
}