package com.wilby.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class XMLUser {

	@XmlAttribute(name = "id")
	private int id;
	@XmlElement(name = "firstName")
	private String firstName;
	@XmlElement(name = "surname")
	private String surname;
	
	public XMLUser(){}
	
	public XMLUser(int id, String firstName, String surname) {
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

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}
}