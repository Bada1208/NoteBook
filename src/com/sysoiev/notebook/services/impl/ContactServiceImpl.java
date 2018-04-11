package com.sysoiev.notebook.services.impl;


import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;


import java.util.HashMap;
import java.util.Map;

public class ContactServiceImpl implements ContactService {

    private Map<String, Contact> contactList = new HashMap<>();

    @Override
    public void createContact(String surname, String name, String phoneNumber, int age) {
        this.contactList.put(surname, new Contact(surname, name, phoneNumber, age));


        for (Map.Entry<String, Contact> element : contactList.entrySet()) {
            System.out.println(element.getKey());
            System.out.println(element.getValue());

        }
    }


    @Override
    public void deleteContact(String surName) {
        this.contactList.remove(surName);
    }

    @Override
    public void showAllContacts() {
        for (Contact contact : this.contactList.values()) {
            System.out.println(contact);
        }

    }

    @Override
    public void editContact(String oldSurname, String newSurname, String newName, String newPhoneNumber,String newAge) {
//        Contact contact = this.contactList.get(oldSurname);
//        contact.setSurname(newSurname);
//        contact.setName(newName);
//        contact.setPhoneNumber(newPhoneNumber);
//        contact.setAge(newAge);


        Contact contact = this.contactList.get(oldSurname);

        if (!newSurname.equals("")) {
            contact.setSurname(newSurname);
        }
        if (!newName.equals("")) {
            contact.setName(newName);
        }
        if (!newPhoneNumber.equals("")) {
            contact.setPhoneNumber(newPhoneNumber);
        }
        if (!newAge.equals("")) {
            contact.setAge(Integer.valueOf(newAge));
        }

        contactList.remove(oldSurname);
        contactList.put(newSurname, contact);
    }
}