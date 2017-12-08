package tn.esprit.volunteering.volunteering.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.volunteering.volunteering.persistence.Evenement;

@Remote
public interface EventServiceRemote {

	Evenement createEvent(Evenement event);
	boolean saveEvent(Evenement event);
	void removeEvent(Evenement event);
	List<Evenement> findAllEvents();
	Evenement findEventByName(String name);
	public boolean removeEvent(int id);
	void saveEven(Evenement event);
	boolean updateEvent(int id,Evenement event);
	public Evenement findEventById(int id) ;
}
