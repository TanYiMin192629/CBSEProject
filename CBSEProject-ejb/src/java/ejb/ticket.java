/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Ticket;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yi Min
 */
@Stateless
@LocalBean
public class ticket {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public List<Ticket> checkTicket(String email){
        emf = Persistence.createEntityManagerFactory("CBSEProject-ejbPU");
        em = emf.createEntityManager();
        
        List<Ticket> results = em.createQuery("Select t.ticketid, e.eventid, e.name, e.date, e.fee from Ticket t, Events e, Users u where (t.eventid = e) and (t.userid = u) and (u.email = :email)").setParameter("email", email).getResultList();
        
        
        return results;
}
    
    public int deleteTicket(int ticketID){
        emf = Persistence.createEntityManagerFactory("CBSEProject-ejbPU");
        em = emf.createEntityManager();
        
        return em.createQuery("Delete from Ticket t where t.ticketid = :ticketid").setParameter("ticketid", ticketID).executeUpdate();

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
    
    public List<Object[]> countTicket(){
        emf = Persistence.createEntityManagerFactory("CBSEProject-ejbPU");
        em = emf.createEntityManager();
        
        List<Object[]> results = em.createQuery("Select e.name, count(t.ticketid) from Ticket t, Events e where (t.eventid = e) group by e.name").getResultList();
        
        
        return results;
}
    
    
}
