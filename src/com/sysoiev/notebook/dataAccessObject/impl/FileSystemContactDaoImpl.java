package com.sysoiev.notebook.dataAccessObject.impl;

import com.sysoiev.notebook.dataAccessObject.ContactDao;
import com.sysoiev.notebook.model.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileSystemContactDaoImpl implements ContactDao {


    @Override
    public void saveContact(Contact contact) {
        File file = new File("data");
        try (PrintWriter writer = new FileWriter(new BufferedReader(new FileWriter(file)))) {
            writer.println(contact);

        }


    }

    @Override
    public void removeContact() {

    }
}
