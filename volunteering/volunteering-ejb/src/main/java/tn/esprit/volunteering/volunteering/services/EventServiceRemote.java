package tn.esprit.volunteering.volunteering.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.volunteering.volunteering.persistence.Event;

@Remote
public interface EventServiceRemote {

	Event createEvent(Event event);
	boolean saveEvent(Event event);
	void removeEvent(Event event);
	List<Event> findAllEvents();
	Event findEventByName(String name);
	public boolean removeEvent(int id);
	void saveEven(Event event);
	boolean updateEvent(int id,Event event);
	public Event findEventById(int id) ;
}
