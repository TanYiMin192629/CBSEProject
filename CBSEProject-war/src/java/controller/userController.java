
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
    private Login login2;

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
        if (login1.authenticate(this.user.getEmail(), this.user.getPassword()).equals("admin")) {
            return "AdminHomepage";
        } else if (login1.authenticate(this.user.getEmail(), this.user.getPassword()).equals("user")) {
            return "user_homepage";
        } else {
            return "index";
        }

    }

    public userController() {
    }

}
