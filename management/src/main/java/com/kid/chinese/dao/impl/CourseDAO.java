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
	public List findAllTbCourse(int start, int pageSize, String name) {
		try {
			final String hql = "from TbCourse u where u.coursename is null or u.coursename like :name  order by id desc";
			
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
	public boolean saveTbCourse(TbCourse tbCourse) {
		boolean result = false;
		try {
			getCurrentSession().saveOrUpdate(tbCourse);
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public TbCourse findAllTbCourseByCode(String coursename) {
		try {
			final String hql = "from TbCourse u where u.coursename  = :coursename  order by id desc";
			Query query = getCurrentSession().createQuery(hql).setParameter("coursename", coursename);
			List list = query.list();
			if(list.size()>0) {
				return (TbCourse)list.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}