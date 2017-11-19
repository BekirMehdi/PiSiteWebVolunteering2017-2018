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


/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	private byte[] picture;

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "event")
	private List<User> listUsers ;
	

	@ManyToOne
	private Event parent;
	@OneToMany(mappedBy = "parent")
	private List<Event> subEvents;

	public Event() {

	}

	public Event(String nameEvent, String typeEvent) {
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

	public Event getParent() {
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

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
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

	
}
