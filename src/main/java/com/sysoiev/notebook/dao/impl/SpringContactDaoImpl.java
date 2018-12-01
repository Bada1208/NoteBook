package com.sysoiev.notebook.dao.impl;

import com.sysoiev.notebook.dao.SpringContactDao;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.model.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Final step is to create DAO classes to map our model class to database table using sql queries.
 * We will also configure DataSource using @Autowired annotation and expose some APIs.
 * SpringContactDAOImpl class is annotated with @Component annotation and in this class we have field with
 * type JdbcTemplate.
 * When constructor of this class will be invoked, an instance of DataSource will be injected into
 * it and we can create
 * an instance of JdbcTemplate. After that we can use in in our methods.
 */

@Component
public class SpringContactDaoImpl implements SpringContactDao {

    Contact contact;
    JdbcTemplate jdbcTemplate;

    private final String SQL_REMOVE_CONTACT = "DELETE FROM CLIENT WHERE SURNAME=?;";
    private final String SQL_UPDATE_CONTACT = "UPDATE CLIENT SET SURNAME=?, NAME=?, PHONENUMBER=?, AGE=? WHERE SURNAME=?";
    private final String SQL_SHOW_ALL = "SELECT * FROM CLIENT ORDER BY ID";
    private final String SQL_SAVE_CONTACT = "INSERT INTO CLIENT VALUES(?, ?, ?, ?, ?);";

    @Autowired
    public SpringContactDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean saveContact(Contact contact) {
        return jdbcTemplate.update(SQL_SAVE_CONTACT, contact.getSurname(), contact.getName(),
                contact.getPhoneNumber(), contact.getAge()) > 0;
    }

    @Override
    public boolean removeContact(String surname) {
        return jdbcTemplate.update(SQL_REMOVE_CONTACT, contact.getSurname()) > 0;
    }

    @Override
    public boolean updateContact(String oldSurname, Contact contact) {
        return jdbcTemplate.update(SQL_UPDATE_CONTACT, contact.getSurname(), contact.getName(),
                contact.getPhoneNumber(), contact.getAge()) > 0;
    }

    @Override
    public List<Contact> showAll() {
        return jdbcTemplate.query(SQL_SHOW_ALL, new ContactMapper());
    }

}
