package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.StudentInfo;

@Repository
@Transactional
public class StudentDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	public StudentDAO() {
    	
    }
	
	public List<StudentInfo> getListStudent() {
    	String sql = "select * from student_info";
    	Session session = this.sessionFactory.getCurrentSession();
    	Query<StudentInfo> query = session.createNativeQuery(sql, StudentInfo.class);
    	try {
    		return query.getResultList();
    	} catch (Exception e) {
    		return null;
    	}	
    }
}
