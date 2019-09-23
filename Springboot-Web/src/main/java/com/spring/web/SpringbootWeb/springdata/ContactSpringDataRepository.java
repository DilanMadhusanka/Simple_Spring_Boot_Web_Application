package com.spring.web.SpringbootWeb.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.SpringbootWeb.entity.Contact;

public interface ContactSpringDataRepository extends JpaRepository<Contact, Integer>{

}
