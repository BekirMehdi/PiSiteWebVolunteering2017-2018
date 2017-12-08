package tn.esprit.volunteering.volunteering.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.volunteering.volunteering.persistence.Evenement;
import tn.esprit.volunteering.volunteering.persistence.User;

@Local
public interface EventServiceLocal {
	public List<User> findUsersByEvent(Evenement event);
	public byte[] findPictureByProductName(String productName);
	Evenement createEvent(Evenement event);
	boolean saveEvent(Evenement event);
	boolean updateEvent(int id,Evenement event);
	void saveEven(Evenement event);
	void removeEvent(Evenement event);
	List<Evenement> findAllEvents();
	Evenement findEventByName(String name);
	public boolean NameExists(String login);
	public boolean removeEvent(int id);
	public Evenement findEventById(int id);

}
