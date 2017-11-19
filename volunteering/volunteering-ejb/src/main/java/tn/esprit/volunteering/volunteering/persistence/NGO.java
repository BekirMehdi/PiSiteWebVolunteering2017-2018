package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.volunteering.volunteering.persistence.User;

/**
 * Entity implementation class for Entity: NGO
 *
 */
@Entity

public class NGO extends User implements Serializable {

	
	private String nameAss;
	private String addressAss;
	private String mailAss;
	private static final long serialVersionUID = 1L;

	public NGO() {
		super();
	}   
	public String getNameAss() {
		return this.nameAss;
	}

	public void setNameAss(String nameAss) {
		this.nameAss = nameAss;
	}   
	public String getAddressAss() {
		return this.addressAss;
	}

	public void setAddressAss(String addressAss) {
		this.addressAss = addressAss;
	}   
	public String getMailAss() {
		return this.mailAss;
	}

	public void setMailAss(String mailAss) {
		this.mailAss = mailAss;
	}
   
}
