/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Events;
import entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.EventsFacade;

/**
 *
 * @author Yi Min
 */
@Named(value = "joinEventController")
@SessionScoped
public class joinEventController implements Serializable {
    
    @EJB
    private EventsFacade eventsFacade;
    private Events e = new Events();
    
 
    Users user = new Users();
    
    public Events getE() {
        return e;
    }
    
    public void setE(Events e) {
        this.e = e;
    }
    
     public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public List<Events> findAll(){
        return this.eventsFacade.findAll(); 
    }
    
    public String join(Events e){
        this.e = e;
        return "book_ticket";
    }
    
    
    

    /**
     * Creates a new instance of joinEventController
     */
    public joinEventController() {
    }
    
}
