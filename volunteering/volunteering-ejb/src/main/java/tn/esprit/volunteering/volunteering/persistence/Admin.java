package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import tn.esprit.volunteering.volunteering.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends User implements Serializable {

	
	private String levelAdmin;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="adminNews",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<News> listNews ;
	
	@OneToMany(mappedBy="adminCourses",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Course> listCourses ;
	
	@OneToMany(mappedBy="adminManage",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<User> listUsers ;
	
	@OneToMany(mappedBy="adminSponsors",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Sponsor> listSponsors ;


	public Admin() {
		super();
	}   
	public String getLevelAdmin() {
		return this.levelAdmin;
	}

	public void setLevelAdmin(String levelAdmin) {
		this.levelAdmin = levelAdmin;
	}
	public List<News> getListNews() {
		return listNews;
	}
	public void setListNews(List<News> listNews) {
		this.listNews = listNews;
	}
	public List<Course> getListCourses() {
		return listCourses;
	}
	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}
	public List<User> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	public List<Sponsor> getListSponsors() {
		return listSponsors;
	}
	public void setListSponsors(List<Sponsor> listSponsors) {
		this.listSponsors = listSponsors;
	}
   
}
