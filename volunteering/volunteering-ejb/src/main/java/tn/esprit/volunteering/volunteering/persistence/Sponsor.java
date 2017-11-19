package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sponsor
 *
 */
@Entity

public class Sponsor implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSponsor;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Admin adminSponsors ;

	public Sponsor() {
		super();
	}   
	public int getIdSponsor() {
		return this.idSponsor;
	}

	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}
	public Admin getAdminSponsors() {
		return adminSponsors;
	}
	public void setAdminSponsors(Admin adminSponsors) {
		this.adminSponsors = adminSponsors;
	}
   
	
}
