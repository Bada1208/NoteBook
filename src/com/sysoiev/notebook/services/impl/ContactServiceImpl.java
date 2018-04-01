package com.sysoiev.notebook.services.impl;


import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private List<Contact> contactList = new ArrayList<>();

    @Override
    public void createContact(String surname, String name, String phoneNumber, int age) {
        this.contactList.add(new Contact(surname, name, phoneNumber, age));

        for (Contact contact : this.contactList) {
            System.out.println(contact);
        }

    }

    @Override
    public void deleteContact() {

    }
}
