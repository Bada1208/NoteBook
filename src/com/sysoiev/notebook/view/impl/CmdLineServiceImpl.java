package com.sysoiev.notebook.view.impl;

import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.view.CmdLineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService {

    private ContactService contactService;
    private BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public CmdLineServiceImpl(ContactService contactService) {
        this.contactService = contactService;
    }

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
        System.out.println("Enter surname");
        String surName = br.readLine();
        System.out.println("Enter name");
        String name = br.readLine();
        System.out.println("Enter phone number");
        String phoneNumber = br.readLine();
        System.out.println("Enter age");
        //int age = Integer.parseInt(br.readLine());
        int ageN = readInt();

        this.contactService.createContact(surName, name, phoneNumber, ageN);
    }

    private void deleteContact() throws IOException {
        System.out.println("Enter surname");
        String surname = br.readLine();
        this.contactService.deleteContact(surname);
    }

    private void showAllContacts() {
        System.out.println("The Contacts of the Phonebook are:");
        this.contactService.showAllContacts();


    }


    private void editContact() throws IOException {

        System.out.println("Enter surname of modified contact");
        String oldSurname = br.readLine();

        System.out.println("Enter new surname");
        String newSurname = br.readLine();

        System.out.println("Enter new name");
        String newName = br.readLine();

        System.out.println("Enter new phone");
        String newPhoneNumber = br.readLine();

        System.out.println("Enter new age");
        //int newAge = Integer.parseInt(br.readLine());
        String newAge = br.readLine();

        this.contactService.editContact(oldSurname, newSurname, newName, newPhoneNumber, newAge);

    }

    private int readInt() throws IOException {

        int i;
        try {
            // System.out.println("Input number!");
            String line = this.br.readLine();
            i = new Integer(line);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong Input!");
            return readInt();
        }
        return i;
    }

}

