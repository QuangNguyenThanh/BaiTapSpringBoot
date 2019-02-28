package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id", nullable = false)
	private int info_id;
	
	@Id
	@GeneratedValue
	@Column(name = "student_id", nullable = false)
	private int student_id;

	@OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
	
	@Column(name = "address", length = 255)
	private String address;

	@Column(name = "average_score", length = 15)
	private double average_score;
	
	@Column(name = "date_of_birth")
	private String date_of_birth;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAverage_score() {
		return average_score;
	}

	public void setAverage_score(double average_score) {
		this.average_score = average_score;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
}
