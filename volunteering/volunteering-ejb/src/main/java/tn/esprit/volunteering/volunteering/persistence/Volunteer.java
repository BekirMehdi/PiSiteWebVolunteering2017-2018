package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.volunteering.volunteering.persistence.User;

/**
 * Entity implementation class for Entity: Volunteer
 *
 */
@Entity

public class Volunteer extends User implements Serializable {

	
	private String levelVolunteer;
	private static final long serialVersionUID = 1L;

	public Volunteer() {
		super();
	}   
	public String getLevelVolunteer() {
		return this.levelVolunteer;
	}

	public void setLevelVolunteer(String levelVolunteer) {
		this.levelVolunteer = levelVolunteer;
	}
   
}
