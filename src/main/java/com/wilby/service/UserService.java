package com.wilby.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wilby.db.User;
import com.wilby.db.UserRepository;
import com.wilby.util.FileTypeUtil;
import com.wilby.xml.XMLUser;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private XMLUser xmlUser;
	
	public String addNewUser(int id, String firstName, String surname) {
		User savedUser = userRepository.save(new User(id, firstName, surname));
		return savedUser.toString();
	}
	
	public String addFromFile(String path) {
		Path pathValue;
		try {
			pathValue = Paths.get(path);
		}
		catch (InvalidPathException err){
			return new String("\nThe path entered does not appear to match a valid file path\n");
		}
		try {
			String fileType = FileTypeUtil.probeContentType(pathValue);
			if (fileType == null) {
				return new String("\nThe file submitted does not appear to be xml\n");
			}
			if (!fileType.equals("xml")) {
				return new String("\nThe file submitted does not appear to be xml\n");
			}
		}
		catch (IOException ioe) {
			return new String("\nThe file submitted does not appear to be xml\n");
		}
		try {
			File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(com.wilby.xml.XMLUser.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			xmlUser = (XMLUser) unmarshaller.unmarshal(file);
			User savedUser = userRepository.save(new User(xmlUser.getId(), xmlUser.getFirstName(), xmlUser.getSurname()));
			return savedUser.toString();
		}
		catch (Exception e) {
			return new String("\nEncountered a problem processing XML file\n");
		}
	}

	public String deleteExistingUser(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return new String("\nRecord for id " + id + " successfully deleted\n");
		}
		return new String("\nUnable to find matching record for id " + id + " \n");
	}

	public String editExistingUser(String firstName, String surname) {
		// Decided not to implement, unclear requirement
		return null;
	}

	public String listAllUsers() {
		List<User> userList = new ArrayList<User>();
		userRepository.findAll().forEach(e -> userList.add(e));
		return userList.toString();
	}

	public String countAllUsers() {
		long resultTally = userRepository.count();
		return new String("\nThere are " + resultTally + " user record(s) in the database\n");
	}
}
