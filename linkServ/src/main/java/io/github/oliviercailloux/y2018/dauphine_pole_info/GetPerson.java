package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionalException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("GetPerson")
public class GetPerson {


	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;
	
	@GET
	@Path("all")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Person> getAllPersons() throws Exception {
		List<Person> persons = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Person> per = new ArrayList<Person>();
        transaction = manager.getTransaction();
        transaction.begin();
        persons = manager.createQuery("SELECT s FROM Person s",Person.class).getResultList();
        transaction.commit();
        manager.close();
        for (Person entity : persons) {
        	per.add(entity);
        }
        return per;
    }
	

	@GET
	@Path("one")
	@Produces(MediaType.TEXT_PLAIN)
	public Person getPerson(@PathParam("id") int id) throws Exception {
		Person pers = null;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        transaction = manager.getTransaction();
        transaction.begin();
        pers = manager.find(Person.class, id);
        transaction.commit();
        manager.close();
		return pers;
	
	}
	}
	
