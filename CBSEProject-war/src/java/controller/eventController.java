  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.Participants;
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
    private Participants participants;
    
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
    
    public String add(){
        this.eventsFacade.create(this.e);
        this.e = new Events();
        return "manage_event";
    }
    
    public void delete (Events e){
        this.eventsFacade.remove(e);
    }
    public String edit(Events e){
        this.e = e;
        return "edit_event";
    }
    public String edit(){
        this.eventsFacade.edit(this.e);
        return "manage_event";
    }
    
    public String back(){
        return "manage_event";
    }
    
    public String view(Events e){
    
    this.e = e;
    return "participant_list";
    
    }
    
    public List<Events> viewParticipants(){

    return this.participants.viewParticipants(this.e.getEventid());
    
    }
    
    
    
}
