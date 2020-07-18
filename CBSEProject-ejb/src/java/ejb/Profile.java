/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Yi Min
 */
@Stateless
@LocalBean
public class Profile {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public Users findUsers(String email, String password){
        emf = Persistence.createEntityManagerFactory("CBSEProject-ejbPU");
        em = emf.createEntityManager();
        
        return em.createNamedQuery("Users.login", Users.class).setParameter("email", email).setParameter("password", password).getSingleResult();

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
}
