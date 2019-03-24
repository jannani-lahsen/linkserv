package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionalException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("addPerson")
public class AddPerson {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response add(@QueryParam("firstname") String fname,@QueryParam("lastname") String lname,@QueryParam("email") String email,@QueryParam("phone") String phone,@QueryParam("fax") String fax) throws Exception {
		
		Person per =new Person(fname,lname,email,phone,fax);
		CreatePerson(per);
		return Response.ok("ok").build();
	}
	
	void CreatePerson(Person per) throws Exception {
		
    	EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        transaction = manager.getTransaction();
        transaction.begin();
        per.setId(per.getId());
        per.setFirstname(per.getFirstname());
        per.setLastname(per.getLastname());
        per.setEmail(per.getEmail());
        per.setPhone(per.getMobile());
	    per.setFax(per.getFax());
        per.setHomePage(per.getHome_page());
        per.setCv(per.getCv());
        per.setNote(per.getNote());
        per.setPassword(per.getPassword());
        per.setRole(per.getRole());
        per.setAddress(per.getAddress());
        per.setMobile(per.getMobile());
        per.setTemporary(per.getTemporary());
            
        manager.persist(per);
        transaction.commit();
        manager.close();
        
}



}
