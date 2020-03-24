package com.kid.chinese.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.kid.chinese.model.TbCourse;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.dao.AbstractHibernateDAO;
import com.kid.chinese.dao.ICourseDAO;
import com.kid.chinese.dao.ITeacherDAO;

@Repository("courseDAO")
public class CourseDAO extends AbstractHibernateDAO<TbCourse> implements ICourseDAO {

    public CourseDAO() {
        super();
        setClazz(TbCourse.class);
    }

	@Override
	public Long findAllTbCourseCount(String name) {
		try {
			String hql = "select count(*) from TbCourse u where u.coursename is null or u.coursename like :name";
			Long userCount = (Long) getCurrentSession()
					.createQuery(hql)
					.setParameter("name", "%"+name+"%")
					.uniqueResult();
			return userCount;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0L;
	}

	@Override
	public List findAllTbCourse(int start, int pageSize, String code) {
		return null;
	}

	@Override
	public boolean saveTbCourse(TbCourse tbCourse) {
		return false;
	}

	@Override
	public TbCourse findAllTbCourseByCode(String code) {
		return null;
	}
}