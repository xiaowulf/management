package com.kid.chinese.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_course", catalog = "xedu")
public class TbCourse implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5284027288950275460L;
	private Long id;
	private String course_name;
	private Long create_date;
	private String coursecategory_name;
	private Long coursecategory_id;
	private Integer status;
	private Long update_date;
	private String file1;
	private String file2;
	private String file3;
	private String description;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "create_date")
	public Long getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Long create_date) {
		this.create_date = create_date;
	}
	@Column(name = "course_name")
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Column(name = "coursecategory_name")
	public String getCoursecategory_name() {
		return coursecategory_name;
	}
	public void setCoursecategory_name(String coursecategory_name) {
		this.coursecategory_name = coursecategory_name;
	}
	@Column(name = "coursecategory_id")
	public Long getCoursecategory_id() {
		return coursecategory_id;
	}
	public void setCoursecategory_id(Long coursecategory_id) {
		this.coursecategory_id = coursecategory_id;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "update_date")
	public Long getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Long update_date) {
		this.update_date = update_date;
	}
	@Column(name = "file1")
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	@Column(name = "file2")
	public String getFile2() {
		return file2;
	}
	public void setFile2(String file2) {
		this.file2 = file2;
	}
	@Column(name = "file3")
	public String getFile3() {
		return file3;
	}
	public void setFile3(String file3) {
		this.file3 = file3;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
