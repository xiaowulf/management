package com.kid.chinese.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_course_enroll", catalog = "xedu")
public class TbCourseEnroll implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3612746416799646523L;
	private Long id;
	private Long student_id;
	private String student_name;
	private Long course_arrange_id;
	private Integer status;
	private Long course_id;
	private String coursename;
	private Date create_date_time;
	private String coursecategoryname;
	private Long coursecategoryid;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "coursename")
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	@Column(name = "student_id")
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	@Column(name = "student_name")
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	@Column(name = "course_arrange_id")
	public Long getCourse_arrange_id() {
		return course_arrange_id;
	}
	public void setCourse_arrange_id(Long course_arrange_id) {
		this.course_arrange_id = course_arrange_id;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "course_id")
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	@Column(name = "create_date_time")
	public Date getCreate_date_time() {
		return create_date_time;
	}
	public void setCreate_date_time(Date create_date_time) {
		this.create_date_time = create_date_time;
	}
	@Column(name = "coursecategoryname")
	public String getCoursecategoryname() {
		return coursecategoryname;
	}
	public void setCoursecategoryname(String coursecategoryname) {
		this.coursecategoryname = coursecategoryname;
	}
	@Column(name = "coursecategoryid")
	public Long getCoursecategoryid() {
		return coursecategoryid;
	}
	public void setCoursecategoryid(Long coursecategoryid) {
		this.coursecategoryid = coursecategoryid;
	}
	
}
