package com.sysoiev.notebook.services;


public interface ContactService {

    void createContact(String surName, String name, String phoneNumber, int age);

    void deleteContact(String surName);

    void showAllContacts();

   // void editContact(String oldName, String newName);

}