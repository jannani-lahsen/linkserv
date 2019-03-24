package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestScoped
@Path("DeletePerson")
public class DeletePerson {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;
	
	@Transactional
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response Delete(@QueryParam("firstname") int fname) throws Exception {


        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Person> per = new ArrayList<Person>();
        transaction = manager.getTransaction();
        transaction.begin();
        int q = manager.createQuery("DELETE  FROM Person s WHERE s.master = "+fname).executeUpdate();
        transaction.commit();
        manager.close();
        return Response.ok("ok").build();
	}
	}
