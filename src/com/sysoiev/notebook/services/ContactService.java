package com.sysoiev.notebook.services;

public interface ContactService {

    void createContact( String surname,String name, int phoneNumber, int age);

    void deleteContact();

}