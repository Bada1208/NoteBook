package com.sysoiev.notebook.services.impl;


import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;
import javafx.collections.ObservableList;


import java.util.HashMap;
import java.util.Map;

public class ContactServiceImpl implements ContactService {
    /**
     * Реализация ContactService которая использует Map для хранения данных.
     */

    private final ObservableList<Object> contactList;

    @Override
    public void createContact(String surname, String name, String phoneNumber, int age) {
        this.contactList.add( new Contact(surname, name, phoneNumber, age));


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
    public void editContact(String oldSurname, String newSurname, String newName, String newPhoneNumber,int newAge) {
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
        try {
            if (newAge != 0) {
                contact.setAge(newAge);
            }
        } catch (NumberFormatException e) {
            System.out.println(" Enter zero ");
        }
//        if (!newAge.equals("")) {
//            contact.setAge(Integer.valueOf(newAge));//in the case of newAge will be String
//        }

        contactList.remove(oldSurname);
        contactList.put(newSurname, contact);
    }
}
