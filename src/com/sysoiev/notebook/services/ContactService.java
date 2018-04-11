package com.sysoiev.notebook.services;


public interface ContactService {

    void createContact(String surName, String name, String phoneNumber, int age);

    void deleteContact(String surName);

    void showAllContacts();

    void editContact(String oldSurname, String newSurname,String newName,String newPhoneNumber,int newAge);

}