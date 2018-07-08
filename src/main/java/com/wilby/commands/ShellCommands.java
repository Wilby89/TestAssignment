package com.wilby.commands;

import org.springframework.shell.standard.ShellMethod;

import com.wilby.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class ShellCommands {
	
	@Autowired
	private UserService userService;
	
	@ShellMethod("Add a new user")
    public String add(int id, String firstName, String surname) {
		return userService.addNewUser(id, firstName, surname);
    }
	
	@ShellMethod("Add a new user from XML file")
    public String addFromFile(String path) {
		return userService.addFromFile(path);
        //return new String("\nValues are " + path);
    }
	
	@ShellMethod("Edit an existing user")
    public String edit(String firstName, String surname) {
		return userService.editExistingUser(firstName, surname);
        //return new String("\nValues are " + " " + firstName + " " + surname);
    }
	
	@ShellMethod("Delete an existing user")
    public String delete(int id) {
		return userService.deleteExistingUser(id);
    }
	
	@ShellMethod("Count users")
    public String count() {
		return userService.countAllUsers();
    }
	
	@ShellMethod("List users")
    public String list() {
		return userService.listAllUsers();
    }
	
	
}