package com.sysoiev.notebook.services.impl;


import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ContactServiceImpl implements ContactService {

    private Map<String, Contact> contactList = new HashMap<>();

    @Override
    public void createContact(String surname, String name, String phoneNumber, int age) {
        this.contactList.put(surname, new Contact(surname, name, phoneNumber, age));

        // for (Contact contact : this.contactList) System.out.println(contact);
        for (Map.Entry<String, Contact> element : contactList.entrySet()) {
            System.out.println(element.getKey());
            System.out.println(element.getValue());

        }
    }

    /*
            @Override
        public void deleteContact() throws IOException, IndexOutOfBoundsException {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" Deleting a contact by index ");
            int index = Integer.parseInt(br.readLine());
            // проверка на выход за пределы массива, если нет - вывод успешности выполнения
            try {
                if (index >= 0) {
                    contactList.remove(index);
                    System.out.println("Contact deleted");
                } else { // если число < 0 выведем это:
                    System.out.println(" Incorrect index. Repeat! Delete Contact");
                } // если ввести число > чем индексов массива выведем это:
            } catch (IndexOutOfBoundsException e) {
                System.out.println(" Incorrect index. Repeat! Delete Contact");
            }
        }
        Override
        public void deleteContact() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter ,please , surname ");
            String surName1 = br.readLine();
            for(int i = 0;i < contactList.size();i++){
                if(contactList.get(i))
                    contactList.remove(this.contactList);
            }else{
                System.out.println("Wrong typing");
            }

        }

    @Override
    public void deleteContact() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter surname ");
        String surName = br.readLine();
        for (int i = 0; i < contactList.size(); i++) {
            final Contact contact = contactList.get(i);
            if (contact.getSurname().equals(surName)) {
                contactList.remove(i);
            }
        }
    }
*/
    @Override
    public void deleteContact(String surName) {
        this.contactList.remove(surName);
    }

    @Override
    public void showAllContacts() {
        for (Contact contact : this.contactList.values()) {
            System.out.println(contact);
        }

    }

//    @Override
//    public void editContact(String name, String newName, int newAge) {
//        Contact contact = this.contactList.get(name);
//        contact.setName(newName);
//        contact.setAge(newAge);
//    }
}