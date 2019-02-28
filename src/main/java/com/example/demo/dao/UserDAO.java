package com.example.demo.dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;

@Repository
@Transactional
public class UserDAO {
	@Autowired
    private SessionFactory sessionFactory;
 
    public UserDAO() {
    	
    }
 
    public User findUserLogin(String username, String password) {
    	String sql = "select * from User where User.user_name =:username and User.password =:password";
    	Session session = this.sessionFactory.getCurrentSession();
    	Query<User> query = session.createNativeQuery(sql, User.class);
    	query.setParameter("username", username);
    	query.setParameter("password", password);
    	try {
    		return query.getSingleResult();
    	} catch (Exception e) {
    		return null;
    	}	
    }
    
    public User findUserByName(String username) {
    	String sql = "select * from User where User.user_name =:username";
    	Session session = this.sessionFactory.getCurrentSession();
    	Query<User> query = session.createNativeQuery(sql, User.class);
    	query.setParameter("username", username);
    	try {
    		return query.getSingleResult();
    	} catch (Exception e) {
    		return null;
    	}
    }

	public int addUser(String username, String password) {
		// TODO Auto-generated method stub
    	Session session = this.sessionFactory.openSession();
    	
    	Integer stId = null;
    	try {
    		User user = new User();
    		user.setUsername(username);
    		user.setPassword(password);
    		stId = (Integer) session.save(user);
    		System.out.println("3");
    	} catch (HibernateException ex) {
    		session.getTransaction().rollback();
    	} finally {
    		session.close();
    	}
    	return stId;
	}
}
