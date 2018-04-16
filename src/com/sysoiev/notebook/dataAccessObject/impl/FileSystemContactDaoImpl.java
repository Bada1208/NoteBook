package com.sysoiev.notebook.dataAccessObject.impl;

import com.sysoiev.notebook.dataAccessObject.ContactDao;
import com.sysoiev.notebook.model.Contact;

import java.io.*;

public class FileSystemContactDaoImpl implements ContactDao {

    /**
     * Сервис работы с файловой системой. Преобразует модели в/из данные хранимые на жестком диске.
     */

    private static final File FILE = new File("data");

    @Override
    public void saveContact(Contact contact) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE,true)))) {
            writer.println(contact);
            writer.flush();
          //  writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact() {


    }
    @Override
    public void showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
