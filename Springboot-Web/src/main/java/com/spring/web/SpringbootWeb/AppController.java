package com.spring.web.SpringbootWeb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.SpringbootWeb.entity.Contact;

@Controller
public class AppController {

	@Autowired
	ContactBusiness business;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("AppController->test()");
		return "test";
	}
	
	@RequestMapping("/list_contact")
	public String listContact(Model model) {
		List<Contact> contactList = business.getContactList();
		model.addAttribute("contacts", contactList);
		return "contact";
	}
}
