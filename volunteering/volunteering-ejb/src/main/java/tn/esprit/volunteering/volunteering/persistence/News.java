package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: News
 *
 */
@Entity

public class News implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNews;
	private String nameNews;
	private Date dateCreation;
	private String description;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Admin adminNews ;
	

	public News() {
		super();
	}   
	public int getIdNews() {
		return this.idNews;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}   
	public String getNameNews() {
		return this.nameNews;
	}

	public void setNameNews(String nameNews) {
		this.nameNews = nameNews;
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
	public Admin getAdminNews() {
		return adminNews;
	}
	public void setAdminNews(Admin adminNews) {
		this.adminNews = adminNews;
	}
   
}
