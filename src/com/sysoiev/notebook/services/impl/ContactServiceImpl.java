package com.sysoiev.notebook.services.impl;


import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private List<Contact> contactList = new ArrayList<>();

    @Override
    public void createContact(String surname, String name, String phoneNumber, int age) {
        this.contactList.add(new Contact(surname, name, phoneNumber, age));

        for (Contact contact : this.contactList) System.out.println(contact);

    }

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

    @Override
    public void showAllContacts() {
        for (Contact contact : this.contactList) System.out.println(contact);
    }

}
