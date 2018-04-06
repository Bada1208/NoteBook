package com.sysoiev.notebook.view.impl;

import com.sysoiev.notebook.model.Contact;
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
//                case "4": {
//                    editContact();
//                    break;
//                }
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
        int age = Integer.parseInt(br.readLine());

        this.contactService.createContact(surName, name, phoneNumber, age);
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
}

//    private void editContact() throws IOException {
//        System.out.println("Enter name of modified contact");
//        String oldName = br.readLine();
//        int ageN = readInt();
//        String newName = " ";
//
//        while (true) {
//            try {
//                System.out.println("Enter new name ");
//                newName = br.readLine();
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Wrong input!");
//            }
//        }
//
//
//       this.contactService.editContact(oldName, newName);
//    }
//    private int readInt() throws IOException{
//        int i ;
//        try {
//            System.out.println("Enter number, please");
//            String line = this.br.readLine();
//            i = new Integer(line);
//        }
//        catch(NumberFormatException e){
//            return readInt();
//        }
//        return i;
//    }



