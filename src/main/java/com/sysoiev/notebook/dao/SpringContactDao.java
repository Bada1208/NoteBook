package com.sysoiev.notebook.dao;

import com.sysoiev.notebook.model.Contact;

import java.util.List;

public interface SpringContactDao {

    boolean createContact(String surname,String  name,String phoneNumber,int ageNumber);

    boolean deleteContact(String surname);

    boolean editContact(String oldSurname,String  newSurname,String newName,String newPhoneNumber,int newAge);

    List<Contact> showAllContacts();
}
