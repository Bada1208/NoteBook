package com.sysoiev.notebook.services;

public interface ContactService {

    void createContact( String surname,String name, String phoneNumber, int age);

    void deleteContact();

}