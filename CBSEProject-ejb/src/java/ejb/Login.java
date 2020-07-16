/*
 * Loo Yiyang
 */
package ejb;

import entities.Users;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author acer
 */
@Stateless
@LocalBean
public class Login {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public boolean authenticate(String email, String password){
        emf = Persistence.createEntityManagerFactory("CBSEProject-ejbPU");
        em = emf.createEntityManager();
        
        try{
            Users u = em.createNamedQuery("Users.login", Users.class).setParameter("email", email).setParameter("password", password).getSingleResult();
            if (u != null) {
            return true;
        }
        return false;
        }catch(Exception e){
           return false; 
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
