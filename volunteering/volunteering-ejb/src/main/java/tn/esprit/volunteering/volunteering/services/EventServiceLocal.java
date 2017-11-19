package tn.esprit.volunteering.volunteering.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.volunteering.volunteering.persistence.Event;
import tn.esprit.volunteering.volunteering.persistence.User;

@Local
public interface EventServiceLocal {
	public List<User> findUsersByEvent(Event event);
	public byte[] findPictureByProductName(String productName);
	Event createEvent(Event event);
	void saveEvent(Event event);
	void removeEvent(Event event);
	List<Event> findAllEvents();
	Event findEventByName(String name);
	public boolean NameExists(String login);

}
