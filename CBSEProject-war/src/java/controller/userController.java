
package controller;

import ejb.Login;
import ejb.Profile;
import entities.Users;
import model.UsersFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Persistence;

/**
 *
 * @author acer
 */
@Named(value = "userController")
@SessionScoped
public class userController implements Serializable {

    @EJB
    private Profile profile;

    @EJB
    private Login login1;


    @EJB
    private UsersFacade usersFacade;

    
    private Users user = new Users();
    
    

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    
    public List<Users> findAll(){
        return this.usersFacade.findAll();
    
    }
    
    public List<Users> findUser(){
        
        return this.profile.findUsers(this.user.getEmail(),this.user.getPassword());
 
    }

    public String register() {
        this.user.setRole(1);
        this.usersFacade.create(user);
        this.user = new Users();
        return "index";
    }

    public String login() {

        if (login1.authenticate(this.user.getEmail(), this.user.getPassword()).equals("admin")) {
            return "AdminHomepage";
        } else if (login1.authenticate(this.user.getEmail(), this.user.getPassword()).equals("user")) {
            return "user_homepage";
        } else {
            return "index";
        }

    }
    
    
    public void edit(Users user){
        this.usersFacade.edit(this.user);
    
    }

    public userController() {
    }

}
