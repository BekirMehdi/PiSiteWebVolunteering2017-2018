package tn.esprit.volunteering.volunteering.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.volunteering.volunteering.persistence.Event;

@Remote
public interface EventServiceRemote {

	Event createEvent(Event event);
	void saveEvent(Event event);
	void removeEvent(Event event);
	List<Event> findAllEvents();
	Event findEventByName(String name);

}
