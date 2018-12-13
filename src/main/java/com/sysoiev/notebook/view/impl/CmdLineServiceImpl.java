package com.sysoiev.notebook.view.impl;

import com.sysoiev.notebook.dao.impl.SpringContactDaoImpl;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.util.ValidationUtil;
import com.sysoiev.notebook.view.CmdLineService;
import javafx.collections.ObservableList;
import com.sysoiev.notebook.dao.SpringContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.*;
import java.util.List;

/**
 * Сервис реализующий логику предоставления и считывания информации в/из консоль.
 */

@Component
public class CmdLineServiceImpl implements CmdLineService {
    JdbcTemplate jdbcTemplate;
    Contact contact;

    /*@Autowired
    private ContactService contactService;*/
    @Autowired
    private SpringContactDao springContactDao;

    @Autowired
    private BufferedReader br;
    // private Contact contact;

    @Autowired
    public CmdLineServiceImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        //this.springContactDao = new SpringContactDaoImpl(dataSource);
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

/*
    //this constructor for App
    public CmdLineServiceImpl(ContactService contactService) {
        this.contactService = contactService;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }*/

    @Override
    public void runMenu() throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            String line = br.readLine();
            switch (line) {
                case "1": {
                    createContact();
                    break;
                }
                case "2": {
                    deleteContact();
                    break;
                }
                case "3": {
                    showAllContacts();
                    break;
                }
                case "4": {
                    editContact();
                    break;
                }
                case "0": {
                    isRunning = false;
                    break;
                }
                default:
                    System.out.println("Repeat");
            }
        }
    }


    private static void showMenu() {
        System.out.println("1. Create Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Show all Contacts");
        System.out.println("4. Edit Contact");
        System.out.println("0. Exit");
    }

    private void createContact() throws IOException {
        System.out.println("Enter id :");
        int id = readInt();
        System.out.println("Enter surname :");
        String surname = br.readLine();
        System.out.println("Enter name :");
        String name = br.readLine();
        System.out.println("Enter phone number :");
        String phoneNumber = br.readLine();
        System.out.println("Enter age :");
        //int age = Integer.parseInt(br.readLine());
        int age = readInt();

        //this.contactService.createContact(surname, name, phoneNumber, ageNumber);
        Contact contact = new Contact(id,surname, name, phoneNumber, age);
        springContactDao.createContact(contact);

    }

    private void deleteContact() throws IOException {
        System.out.println("Enter surname in order to remove :");
        String surname = br.readLine();
        Contact contactDeleted = springContactDao.getSurname(surname);
        //Person personById = personDAO.getPersonById(2L);
        springContactDao.deleteContact(contactDeleted);
        //personDAO.deletePerson(personById);
    }

    private void showAllContacts() {
        System.out.println("The Contacts of the Notebook are :");
        //Observable
        List<Contact> contacts = springContactDao.showAllContacts();
        System.out.println(contacts);
    }

    private void editContact() throws IOException {

        System.out.println("Enter surname of modified contact :");
        String oldSurname = br.readLine();

        System.out.println("Enter new surname :");
        String newSurname = br.readLine();

        System.out.println("Enter new name :");
        String newName = br.readLine();

        System.out.println("Enter new phone :");
        String newPhoneNumber = br.readLine();

        System.out.println("Enter new age :");
        int newAge = readInt();
        //int newAge = Integer.parseInt(br.readLine());

        Contact updatedContact = springContactDao.getSurname(oldSurname);
        updatedContact.setSurname(newSurname);
        updatedContact.setName(newName);
        updatedContact.setPhoneNumber(newPhoneNumber);
        updatedContact.setAge(newAge);
        springContactDao.editContact(updatedContact);


    }

    private int readInt() throws IOException {
        try {
            // System.out.println("Input number!");
            String line = br.readLine();
            return ValidationUtil.checkNumber(line);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong Input! You must input number,please.");
            return readInt();
        }
    }

}

