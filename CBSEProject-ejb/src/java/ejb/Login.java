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

    public String authenticate(String email, String password) {
        emf = Persistence.createEntityManagerFactory("CBSEProject-ejbPU");
        em = emf.createEntityManager();

        try {
            Users u = em.createNamedQuery("Users.login", Users.class).setParameter("email", email).setParameter("password", password).getSingleResult();
            if (u.getRole() == 0) {
                return "admin";
            } else if (u.getRole() == 1) {
                return "user";
            } else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
