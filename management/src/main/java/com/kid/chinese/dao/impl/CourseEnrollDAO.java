package com.kid.chinese.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.kid.chinese.model.TbCourseEnroll;
import com.kid.chinese.model.TbCourseEnroll;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.dao.AbstractHibernateDAO;
import com.kid.chinese.dao.ICourseArrangeDAO;
import com.kid.chinese.dao.ICourseEnrollDAO;
import com.kid.chinese.dao.ITeacherDAO;

@Repository("courseEnrollDAO")
public class CourseEnrollDAO extends AbstractHibernateDAO<TbCourseEnroll> implements ICourseEnrollDAO {

    public CourseEnrollDAO() {
        super();
        setClazz(TbCourseEnroll.class);
    }

	@Override
	public Long findAllTbCourseEnrollCount(String name) {
		try {
			String hql = "select count(*) from TbCourseEnroll u where u.course_name is null or u.course_name like :name";
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
	public List findAllTbCourseEnroll(int start, int pageSize, String name) {
		try {
			final String hql = "from TbCourseEnroll u where u.course_name is null or u.course_name like :name  order by id desc";
			
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
	public boolean saveTbCourseEnroll(TbCourseEnroll TbCourseEnroll) {
		boolean result = false;
		try {
			getCurrentSession().saveOrUpdate(TbCourseEnroll);
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	
}