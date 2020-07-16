/*
 * Loo Yiyang
 */
package controller;

import entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.UsersFacade;

/**
 *
 * @author acer
 */
@Named(value = "registerController")
@SessionScoped
public class registerController implements Serializable {

    @EJB
    private UsersFacade usersFacade;
    private Users user = new Users();
    
    /**
     * Creates a new instance of registerController
     */
    public registerController() {
    }
    
    
}
