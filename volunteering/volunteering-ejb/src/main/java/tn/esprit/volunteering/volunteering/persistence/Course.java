package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCourse;
	private String nameCourse;
	private Date dateCreation;
	private String description;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Admin adminCourses ;
	
	public Course() {
		super();
	}   
	public int getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}   
	public String getNameCourse() {
		return this.nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Admin getAdminCourses() {
		return adminCourses;
	}
	public void setAdminCourses(Admin adminCourses) {
		this.adminCourses = adminCourses;
	}
	
   
}
