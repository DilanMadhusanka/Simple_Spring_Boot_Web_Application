package com.spring.web.SpringbootWeb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.SpringbootWeb.entity.Contact;
import com.spring.web.SpringbootWeb.springdata.ContactSpringDataRepository;

@Service
public class ContactBusiness {
	
	@Autowired
	ContactSpringDataRepository repository;

	public List<Contact> getContactList() {
		List<Contact> listContact = new ArrayList<>();
		
		for (Contact contact : repository.findAll()) {
			listContact.add(contact);
		}
		
		return listContact;
	}
}
