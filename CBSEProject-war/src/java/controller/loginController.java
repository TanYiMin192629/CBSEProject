/*
 * Loo Yiyang
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author acer
 */
@Named(value = "loginController")
@SessionScoped
public class loginController implements Serializable {

    /**
     * Creates a new instance of loginController
     */
    public loginController() {
    }
    
}
