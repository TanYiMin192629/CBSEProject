
package controller;

import ejb.Login;
import entities.Users;
import model.UsersFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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

    public String register() {
        this.user.setRole(1);
        this.usersFacade.create(user);
        this.user = new Users();
        return "index";
    }

    public String login() {
        //if (this.usersFacade.login(this.user.getUsername(), this.user.getPassword())) {
        System.out.print(this.user.getEmail());
        System.out.print(this.user.getPassword());
        if( login1.authenticate(this.user.getEmail(),this.user.getPassword())){
            return "user_homepage";
        }
        return "index";
    }

    public userController() {
    }
    
}
