package org.gradle;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/service2")
public class SimpleRestService2 {

	   @GET
	   @Path("/hola")
	   @Produces(MediaType.TEXT_PLAIN)
	   public String sdf(@QueryParam("numero1") String numero1,@QueryParam("numero2") String numero2){
		   Principal principal = new Principal(numero1, numero2);
		   return principal.devuelta();
	   }
}
