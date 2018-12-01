package com.sysoiev.notebook.dao;

import com.sysoiev.notebook.model.Contact;

import java.util.List;

public interface SpringContactDao {

    boolean saveContact(Contact contact);

    boolean removeContact(String surname);

    boolean updateContact(String oldSurname, Contact contact);

    List<Contact> showAll();
}
