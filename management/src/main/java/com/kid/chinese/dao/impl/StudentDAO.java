package com.kid.chinese.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.kid.chinese.model.TbStudent;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.dao.AbstractHibernateDAO;
import com.kid.chinese.dao.IStudentDAO;
import com.kid.chinese.dao.ITeacherDAO;

@Repository("studentDAO")
public class StudentDAO extends AbstractHibernateDAO<TbStudent> implements IStudentDAO {

    public StudentDAO() {
        super();
        setClazz(TbStudent.class);
    }

	
	@Override
	public Long findAllTbStudentCount(String name) {
		try {
			String hql = "select count(*) from TbStudent u where (u.username is null or u.truename is null) or (u.username like :name or u.truename like :name)";
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
	public List findAllTbStudent(int start, int pageSize, String name) {
		try {
			final String hql = "from TbStudent u where (u.username is null or u.truename is null) or (u.username like :name or u.truename like :name)  order by id desc";
			
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
	public boolean saveTbStudent(TbStudent tbStudent) {
		boolean result = false;
		try {
			getCurrentSession().saveOrUpdate(tbStudent);
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}


	@Override
	public TbStudent findAllTbStudentByUsername(String username) {
		try {
			final String hql = "from TbStudent u where u.username  = :username  order by id desc";
			Query query = getCurrentSession().createQuery(hql).setParameter("username", username);
			List list = query.list();
			if(list.size()>0) {
				return (TbStudent)list.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}