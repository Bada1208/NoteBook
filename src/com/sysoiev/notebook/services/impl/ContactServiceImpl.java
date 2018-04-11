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
    public void editContact(String oldSurname,String newSurname,String oldName, String newName,String oldPhoneNumber,
                            String newPhoneNumber,int oldAge, int newAge) {
        Contact contact = this.contactList.get(oldSurname);
        contact.setSurname(newSurname);
        contact.setName(newName);
        contact.setPhoneNumber(newPhoneNumber);
        contact.setAge(newAge);

    }
}