package com.daoimpl;

import javax.transaction.Transactional;

import org.h2.engine.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.UserDao;
import com.model.user;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory){
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void insertUser(User user){
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
	
//	public void validateUser(String name)
//	{
//	
//	}
}