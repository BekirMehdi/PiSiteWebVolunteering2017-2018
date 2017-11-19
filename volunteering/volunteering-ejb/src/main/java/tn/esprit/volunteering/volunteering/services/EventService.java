package tn.esprit.volunteering.volunteering.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.volunteering.volunteering.persistence.Event;
import tn.esprit.volunteering.volunteering.persistence.User;



@Stateless
public class EventService implements EventServiceRemote,EventServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public EventService() {
	}

	
	public Event createEvent(Event event) {
		em.persist(event);
		return event;
	}


	public void saveEvent(Event event) {
		em.merge(event);
	}

	public Event findEventById(int id) {
		return em.find(Event.class, id);
	}

	public void removeEvent(Event event) {
		em.remove(em.merge(event));
	}

	public List<Event> findAllEvents() {
		return em.createQuery("select e from Event e", Event.class)
				.getResultList();
	}

	public Event findEventByName(String name) {
		Event found = null;
		TypedQuery<Event> query = em.createQuery(
				"select e from Event e where c.name=:x", Event.class);
		query.setParameter("x", name);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no category with name=" + name);
		}
		return found;
	}
	
	public List<User> findUsersByEvent(Event event) {
		return em.createQuery("select u from User u where u.event=:e",
						User.class).setParameter("e", event)
				.getResultList();
	}
	
	public byte[] findPictureByProductName(String productName) {
		byte[] picture = null;
		TypedQuery<byte[]> query = em.createQuery(
				"select p.picture from Product p where p.name=:x", byte[].class);
		query.setParameter("x", productName);
		try {
			picture = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no picture");
		}
		return picture;

	}

	public boolean NameExists(String nameEvent) {
		boolean exists = false;
		String jpql = "select case when (count(e) > 0)  then true else false end from event e where e.nameEvent=:nameEvent";
		TypedQuery<Boolean> query = em.createQuery(jpql, Boolean.class);
		query.setParameter("nameEvent", nameEvent);
		try {
			exists = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getLogger(EventService.class.getName()).log(
					Level.WARNING, "no Event registred with name=" + nameEvent);
		}
		return exists;
	}
	
}
