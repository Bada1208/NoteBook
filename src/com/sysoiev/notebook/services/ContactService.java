package com.sysoiev.notebook.services;

import java.io.IOException;

public interface ContactService {

    void createContact(String surName, String name, String phoneNumber, int age);

    void deleteContact() throws IOException;

    void showAllContacts();

}