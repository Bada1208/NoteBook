package com.sysoiev.notebook.services;


public interface ContactService {

    void createContact(String surName, String name, String phoneNumber, int age);

    void deleteContact(String surName);

    void showAllContacts();

   void editContact(String oldSurname,String newSurname,String oldName, String newName,String oldPhoneNumber,
                     String newPhoneNumber,int oldAge, int newAge);

}