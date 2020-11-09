/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author alsorc
 */
public class User {
    
    private int id;
    private String name;
    private String direction;

    public User() {
    }

    public User(int id, String name, String direction) {
        this.id = id;
        this.name = name;
        this.direction = direction;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    
    
    
}
