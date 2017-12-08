package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
@XmlRootElement
public class Evenement implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idEvent;
	private String nameEvent;
	private String typeEvent;
	private Date dateEvent;
	private String description;
	private String mailResp ;
	private int phoneResp ;
	private String address;
	private String latitude;
	private String longitude;
	private String imgPath ;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "event")
	private List<User> listUsers ;
	

	/*@ManyToOne
	private Event parent;
	@OneToMany(mappedBy = "parent")
	private List<Event> subEvents;*/

	public Evenement() {

	}

	public Evenement(int idEvent, String nameEvent, String typeEvent, Date dateEvent, String description, String mailResp,
			int phoneResp, String address, String latitude, String longitude) {
		super();
		this.idEvent = idEvent;
		this.nameEvent = nameEvent;
		this.typeEvent = typeEvent;
		this.dateEvent = dateEvent;
		this.description = description;
		this.mailResp = mailResp;
		this.phoneResp = phoneResp;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Evenement(String nameEvent, String typeEvent) {
		this.nameEvent = nameEvent;
		this.typeEvent = typeEvent;
	}

	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	
	public String getNameEvent() {
		return this.nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public String getTypeEvent() {
		return this.typeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}

	public Date getDateEvent() {
		return this.dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

/*	public Event getParent() {
		return parent;
	}

	public void setParent(Event parent) {
		this.parent = parent;
	}

	public List<Event> getSubEvents() {
		return subEvents;
	}

	public void setSubEvents(List<Event> subEvents) {
		this.subEvents = subEvents;
	}
*/

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public String getMailResp() {
		return mailResp;
	}

	public void setMailResp(String mailResp) {
		this.mailResp = mailResp;
	}

	public int getPhoneResp() {
		return phoneResp;
	}

	public void setPhoneResp(int phoneResp) {
		this.phoneResp = phoneResp;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	
}
