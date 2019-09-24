package com.spring.web.SpringbootWeb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.SpringbootWeb.entity.Contact;
import com.spring.web.SpringbootWeb.springdata.ContactSpringDataRepository;

@Controller
public class AppController {

	@Autowired
	ContactBusiness business;
	
	@Autowired
	ContactSpringDataRepository repository;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("AppController->test()");
		return "test";
	}
	
	@RequestMapping(value = "/list_contact", method = RequestMethod.GET)
	public String listContact(Model model) {
		List<Contact> contactList = business.getContactList();
		model.addAttribute("contacts", contactList);
		return "contact";
	}
	
	@RequestMapping(value = "/add_contact", method = RequestMethod.GET)
	public String goAddContact() {
		return "addingcontact";
	}
	
	@RequestMapping(value = "/add_contact", method = RequestMethod.POST)
	public String addContact(@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String country, Model model) {
		if(repository.existsById(id)) {
			model.addAttribute("errorMessage", "The id is exist!! Use defferent id!!");
		}
		
		else {
			model.addAttribute("data", "Data added!!");
			model.addAttribute("name", name);
			repository.save(new Contact(id, name, email, country));	
		}
		
		return "addingcontact";
	}
	
	@RequestMapping(value = "/delete_contact", method = RequestMethod.GET)
	public String goDeleteContactPage() {
		return "deletingcontact";
	}
	
	@RequestMapping(value = "/delete_contact", method = RequestMethod.POST)
	public String deleteContact(@RequestParam int id, Model model) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			model.addAttribute("delete", "Deleted!!");
			return "deletingcontact";
		}
		else {
			model.addAttribute("errorMessage", "The contact corresponding to id does not exist!!");
			return "deletingcontact";
		}
		
	}
}
