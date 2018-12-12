package com.sysoiev.notebook.dao;

import com.sysoiev.notebook.model.Contact;

import java.util.List;

public interface SpringContactDao {

    boolean createContact(Contact contact);

    boolean deleteContact(Contact contact);

    boolean editContact(Contact contact);

    List<Contact> showAllContacts();

    Contact getSurname(String surname);
}
