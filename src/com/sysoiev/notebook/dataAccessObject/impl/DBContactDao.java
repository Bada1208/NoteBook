package com.sysoiev.notebook.dataAccessObject.impl;

import com.sysoiev.notebook.dataAccessObject.ContactDao;
import com.sysoiev.notebook.model.Contact;

import java.sql.*;

public class DBContactDao implements ContactDao {

    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/ProgramNum1";
    private int counter = 0;

    public DBContactDao() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Can`t connect to DB ");
        }
        try (Connection connection = DriverManager.getConnection(DB_URL, "test", "");
             Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE CLIENT(ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "   SURNAME VARCHAR(255),NAME VARCHAR(255),PNHONENUMBER VARCHAR(255),AGE INTEGER);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveContact(Contact contact) {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, "test", "");
             PreparedStatement st =
                     connection.prepareStatement("INSERT INTO CLIENT VALUES(?, ?, ?, ?, ?);")) {

            st.setInt(1, counter++);
            st.setString(2, contact.getName());
            st.setInt(3, contact.getAge());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeContact(String surname) {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, "test", "");
             PreparedStatement st =
                     connection.prepareStatement("DELETE FROM CLIENT WHERE ID=?;")) {


            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showAll() {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, "test", "");
             PreparedStatement st =
                     connection.prepareStatement("SELECT * FROM CLIENT ORDER BY ID")) {


            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
