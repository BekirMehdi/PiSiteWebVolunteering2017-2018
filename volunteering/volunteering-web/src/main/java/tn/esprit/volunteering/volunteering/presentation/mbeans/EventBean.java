package tn.esprit.volunteering.volunteering.presentation.mbeans;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.FileUploadEvent;

import tn.esprit.volunteering.volunteering.persistence.Event;
import tn.esprit.volunteering.volunteering.persistence.User;
import tn.esprit.volunteering.volunteering.services.EventServiceLocal;
import tn.esprit.volunteering.volunteering.services.UserServiceLocal;


@ManagedBean
@SessionScoped
public class EventBean {
	@EJB
	private EventServiceLocal eventServiceLocal;
	
	@EJB
	private UserServiceLocal userServiceLocal ;
	
	private boolean formDisplayed;
	
	private Event e;
	
	private User user = new User(20,"mehdi","bekir","bizerte cite Jala");
	
	private Event event = new Event();
	
	private List<User> listUsers = new ArrayList<User>();
	
	private List<Event> listEvents = new ArrayList<Event>();
	
	private boolean formDespled =false ;
	
	private List<Event> filteredEvents;
	
	@PostConstruct
	public void init(){
		if (user.getEvent()!=null) {
			formDisplayed = true;
		}
		
		listEvents = eventServiceLocal.findAllEvents();
	}
	
	public String doNew() {
		formDespled=true ;
		return "" ;
		
	}
	
	public String doCancel() {
		
		return "index?faces-redirect=true";
		
	}
	
	public String createEvent() {
		 Event event = new Event();
		 this.event=event;
		return "createEvent?faces-redirect=true";
		
	}
	
	public String doSave(){
		eventServiceLocal.saveEvent(event);
		return "index?faces-redirect=true";
	}
	
	public String editAction(Event event) {

		this.event=event;
		return "edit?faces-redirect=true";
	}
	public String participateAction(){
		user.setEvent(event);
		userServiceLocal.saveUser(user);
		return "showFront?faces-redirect=true";
	}
	
	public String showAction(Event event) {

		this.event=event;
		return "show?faces-redirect=true";
	}
	public String showFrontAction(Event event) {
		listUsers=eventServiceLocal.findUsersByEvent(event);
		this.event=event;
		return "showFront?faces-redirect=true";
	}

	public String deleteAction(Event event) {

		eventServiceLocal.removeEvent(event);
		init();
		return "index?faces-redirect=true";
	}

	
	public void validateNameUnicity(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String NameToValidate = (String) value;
		if (NameToValidate == null || NameToValidate.trim().isEmpty()) {
			return;
		}
		boolean NameInUse = eventServiceLocal.NameExists(NameToValidate);
		if (NameInUse) {
			throw new ValidatorException(new FacesMessage(
					"name already in use!"));
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		byte[] picture = event.getFile().getContents();
		e.setPicture(picture);
	}

	
	public void onRowSelect() {
		formDisplayed = true;
	}
	
	public void onFilter() {
		formDisplayed = false;
	}
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Event> getListEvents() {
		return listEvents;
	}

	public void setListEvents(List<Event> listEvents) {
		this.listEvents = listEvents;
	}

	public boolean isFormDespled() {
		return formDespled;
	}

	public void setFormDespled(boolean formDespled) {
		this.formDespled = formDespled;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public List<Event> getFilteredEvents() {
		return filteredEvents;
	}

	public void setFilteredEvents(List<Event> filteredEvents) {
		this.filteredEvents = filteredEvents;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
