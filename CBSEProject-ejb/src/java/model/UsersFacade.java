/*
 * Loo Yiyang
 */
package model;

import entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author acer
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "CBSEProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
}
