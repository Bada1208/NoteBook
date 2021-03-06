package com.sysoiev.notebook.services;


import com.sysoiev.notebook.model.Contact;
import javafx.collections.ObservableList;

public interface ContactService {
    /**
     * Сервис бизнес логики который описывает основные действия над доменными моделями - Контактами.
     */

    void createContact(String surname, String name, String phoneNumber, int age);

    void deleteContact(String surname);

    ObservableList<Contact> showAllContacts();

    void editContact(String oldSurname, String newSurname,String newName,String newPhoneNumber,int newAge);

}