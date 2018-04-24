package com.sysoiev.notebook.services.impl;

import com.sysoiev.notebook.dataAccessObject.ContactDao;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;

public class FSContactServiceImpl implements ContactService {
    /**
     * Реализация ContactService которая использует Файловую Систему для хранения данных.
     */

    private final ContactDao contactDao;

    public FSContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public void createContact(String surName, String name, String phoneNumber, int age) {
        contactDao.saveContact(new Contact(surName, name, phoneNumber, age));
    }

    @Override
    public void deleteContact(String surName) {

    }

    @Override
    public void showAllContacts() {
        contactDao.showAll();
    }

//    @Override
//    public void showContacts() {
//        contactDao.showAll();
//		for (Contact contact : this.contactList.values()) {
//			System.out.println(contact);
//		}
//    }

    public void editContact(String oldSurname, String newSurname, String newName, String newPhoneNumber, int newAge) {
//		Contact contact = this.contactList.get(name);
//		contact.setName(newName);
//		contact.setAge(newAge);
    }
}
