package com.sysoiev.notebook.dataAccessObject.impl;

import com.sysoiev.notebook.dataAccessObject.ContactDao;
import com.sysoiev.notebook.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBContactDao implements ContactDao {
    private static final String DB_URL = " jdbc:h2:~/test";

    public DBContactDao(){
        try{
            Class.forName("org.h2.Driver");
        } catch(ClassNotFoundException e){
            System.out.println("Cant connect to DB ");
        }
        try(Connection connection = DriverManager.getConnection(DB_URL,"test","");
            Statement st = connection.createStatement();) {
            st.execute("CREATE TABLE CLIENT(ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "   NAME VARCHAR(255),AGE INTEGER);");
        } catch(SQLException e){
            System.out.println("Cant create DB!");
        }
    }

    @Override
    public void saveContact(Contact contact) {

    }

    @Override
    public void removeContact() {

    }

    @Override
    public void showAll() {

    }
}
