/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Events;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author chaiq
 */
@Stateless
@LocalBean
public class Participants {

    EntityManagerFactory emf;
    EntityManager em;
    
    public List<Events> viewParticipants(int eventid){
        emf = Persistence.createEntityManagerFactory("CBSEProject-ejbPU");
        em = emf.createEntityManager();
        
        List<Events> results = em.createQuery("Select e.name, t.ticketid, u.username from Ticket t, Events e, Users u where (t.eventid = e) and (t.userid = u) and (e.eventid = :eventid)").setParameter("eventid", eventid).getResultList();
        
        
        return results;
}
}
