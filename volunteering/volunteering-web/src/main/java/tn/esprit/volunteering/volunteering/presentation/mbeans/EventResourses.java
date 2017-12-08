package tn.esprit.volunteering.volunteering.presentation.mbeans;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.volunteering.volunteering.persistence.Evenement;
import tn.esprit.volunteering.volunteering.services.EventServiceLocal;

import java.io.FileOutputStream;

import javax.ws.rs.FormParam;

 
import org.apache.commons.codec.binary.Base64;


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
	public Response CreationEvent (Evenement event) {
		 String result="false";
	        
	        //decode Base64 String to image
	        try{
	            FileOutputStream fos = new FileOutputStream("C:\\wamp64\\www\\image"+event.getIdEvent()+".jpg"); //change the path where you want to save the image
	            byte byteArray[] = Base64.decodeBase64(event.getImgPath());
	            fos.write(byteArray);
	             
	            result="true";
	            fos.close(); 
	            event.setImgPath("http://10.0.2.2:8080/image"+event.getIdEvent()+".jpg");
	        }
	        catch(Exception e){
	        	event.setImgPath(null);
	            e.printStackTrace();
	           
	        }
		
		if (eventServiceLocal.saveEvent(event))
			return Response.status(Status.CREATED).build();
		return Response.status(Status.NOT_FOUND).build();		
	}

	
	
	
	@DELETE
	public Response deleteArchive (@QueryParam (value="id")Integer id){
		if(eventServiceLocal.removeEvent(id))
		return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).build();	
		}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateRendezVousById(@QueryParam(value="id")int idEvent,Evenement event) {
	
		if (eventServiceLocal.updateEvent(idEvent,event))
			return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).build(); 
			
	}

	
	
	
	
}
