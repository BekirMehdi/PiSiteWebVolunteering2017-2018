package tn.esprit.volunteering.volunteering.presentation.mbeans;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.volunteering.volunteering.persistence.Event;
import tn.esprit.volunteering.volunteering.services.EventServiceLocal;

@Path("Event")
@RequestScoped
public class EventResourses {

	@EJB
	private EventServiceLocal eventServiceLocal;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents(){
		if (eventServiceLocal.findAllEvents() != null)
			return Response.status(Status.OK).entity(eventServiceLocal.findAllEvents()).build();
		return Response.status(Status.NO_CONTENT).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreationEvent (Event event) {
		if (eventServiceLocal.saveEvent(event))
			return Response.status(Status.CREATED).build();
		return Response.status(Status.NOT_FOUND).build();		
	}
	
	
	
	
	
	
}
