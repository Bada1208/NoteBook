package com.sysoiev.notebook.view.impl;

import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.view.CmdLineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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

    private void deleteContact() {
        System.out.println("Delete Contact");
    }
}
