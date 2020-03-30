package com.kid.chinese.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.model.TbTeacherEvaluation;
import com.kid.chinese.dao.AbstractHibernateDAO;
import com.kid.chinese.dao.ITeacherDAO;
import com.kid.chinese.dao.ITeacherEvaluationDAO;

@Repository("teacherEvaluationDAO")
public class TeacherEvaluationDAO extends AbstractHibernateDAO<TbTeacherEvaluation> implements ITeacherEvaluationDAO {

    public TeacherEvaluationDAO() {
        super();
        setClazz(TbTeacherEvaluation.class);
    }

	@Override
	public List findAllTbTeacherEvaluation(int start, int pageSize, String name) {
		try {
			final String hql = "from TbTeacher u where u.truename is null or u.truename like :name  order by id desc";
			
			Query query = getCurrentSession().createQuery(hql).setParameter("name", "%"+name+"%");
			//3.分页
			query.setFirstResult(start);//从什么位置开始，默认为0
			query.setMaxResults(pageSize);//最多检出的条数
			//4.执行SQL
			List list = query.list();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	

	@Override
	public List findAllTbTeacherEvaluationByTeacherId(Long teacher_id) {
		try {
			final String hql = "from TbTeacherEvaluation u where u.teacher_id  = :teacher_id";
			
			Query query = getCurrentSession().createQuery(hql).setParameter("teacher_id", teacher_id);
			List list = query.list();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Long findAllTbTeacherEvaluationCount(Long teacher_id) {
		try {
			String hql = "select count(*) from TbTeacherEvaluation u where u.teacher_id  = :teacher_id";
			Long userCount = (Long) getCurrentSession()
					.createQuery(hql)
					.setParameter("teacher_id", teacher_id)
					.uniqueResult();
			return userCount;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0L;
	}

	@Override
	public List findAllTbTeacherEvaluation(int start, int pageSize, Long teacher_id) {
		try {
			final String hql = "from TbTeacherEvaluation u where u.teacher_id = :teacher_id  order by id desc";
			
			Query query = getCurrentSession().createQuery(hql).setParameter("teacher_id", teacher_id);
			query.setFirstResult(start);//从什么位置开始，默认为0
			query.setMaxResults(pageSize);//最多检出的条数
			List list = query.list();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}