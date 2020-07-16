  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import model.EventsFacade;
import entities.*;
/**
 *
 * @author chaiq
 */
@Named(value = "eventController")
@SessionScoped
public class eventController implements Serializable {
    @EJB
    private EventsFacade eventsFacade;
    private Events e = new Events();

    public Events getE() {
        return e;
    }

    public void setE(Events e) {
        this.e = e;
    }
    
    /**
     * Creates a new instance of eventController
     */
    public eventController() {
    }
    
    public List<Events> findAll(){
        return this.eventsFacade.findAll(); 
    }
}
