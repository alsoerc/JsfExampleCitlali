package beans;

import dao.DaoAgenda;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.User;

/**
 *
 * @author alsorc
 */
@ManagedBean(name = "beanUsuario")
@RequestScoped
public class UBean {
    
    private int id;
    private User user;
    private List<User> users;
    private DaoAgenda dao;
    
    /**
     * Creates a new instance of UBean
     */
    public UBean() {
        user = new User();
        users = new ArrayList();
        dao = new DaoAgenda();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public DaoAgenda getDao() {
        return dao;
    }

    public void setDao(DaoAgenda dao) {
        this.dao = dao;
    }
    
    public void saveRecord(){
        this.dao.insertRecord(user);
    }
    
    public void deleteRecord(){
        this.dao.deleteRecord(id);
    }
    
    public void updateRecord(){
        this.dao.updateRecord(user, id);
    }    
    
    
}
