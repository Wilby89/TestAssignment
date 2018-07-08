package com.wilby.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private int id;
    private String firstName;
    private String surname;
    
    protected User() {}
    
    public User(int id, String firstName, String surname) {
    		this.id = id;
        this.firstName = firstName;
        this.surname = surname;
    }
    
    @Override
    public String toString() {
        return String.format(
                "\nUser is: %d, '%s', '%s'\n",
                id, firstName, surname);
    }
}