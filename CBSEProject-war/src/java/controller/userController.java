package controller;

import ejb.Login;
import ejb.Profile;
import entities.Events;
import entities.Ticket;
import entities.Users;
import model.UsersFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Persistence;
import model.EventsFacade;
import model.TicketFacade;

/**
 *
 * @author acer
 */
@Named(value = "userController")
@SessionScoped
public class userController implements Serializable {

    @EJB
    private TicketFacade ticketFacade;

    @EJB
    private EventsFacade eventsFacade;

    @EJB
    private Profile profile;

    @EJB
    private Login login1;

    @EJB
    private UsersFacade usersFacade;
    
    
    private Users user = new Users();
    private Events e = new Events();
    private Ticket ticket = new Ticket();
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Events getE() {
        return e;
    }

    public void setE(Events e) {
        this.e = e;
    }

    
    public List<Users> findAll() {
        return this.usersFacade.findAll();

    }

    public Users findUser() {

        return this.profile.findUsers(this.user.getEmail(), this.user.getPassword());

    }

    public String register() {
        this.user.setRole(1);
        this.usersFacade.create(user);
        this.user = new Users();
        return "index";
    }

    public String login() {

        if (login1.authenticate(this.user.getEmail(), this.user.getPassword()).equals("admin")) {
            this.user = findUser();
            return "AdminHomepage";
        } else if (login1.authenticate(this.user.getEmail(), this.user.getPassword()).equals("user")) {
            this.user = findUser();
            return "user_homepage";
        } else {
            return "index";
        }

    }

    public String edit(Users user) {
        this.usersFacade.edit(user);
        return "user_homepage";
    }
    
        public List<Events> events(){
        return this.eventsFacade.findAll(); 
    }

    public String join(Events e) {
        this.e = e;
        return "book_ticket";
    }

    public String book() {
        System.out.print(e.getName());
        System.out.print(user.getEmail());
        this.ticket.setEventid(e);
        this.ticket.setUserid(user);
        this.ticketFacade.create(ticket);
        this.ticket = new Ticket();
        return "check_ticket";
    }

    public userController() {
    }

}
