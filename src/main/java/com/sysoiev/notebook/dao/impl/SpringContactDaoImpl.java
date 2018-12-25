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

    private Contact contact;

    JdbcTemplate jdbcTemplate;


    private final String SQL_FIND_CONTACT_BY_SURNAME = "select * from clientspring where SURNAME = ?";
    private final String SQL_REMOVE_CONTACT = "DELETE FROM clientspring WHERE SURNAME=?;";
    private final String SQL_UPDATE_CONTACT = "UPDATE clientspring  SET SURNAME=?, NAME=?, PHONENUMBER=?, AGE=? WHERE SURNAME=?";
    private final String SQL_SHOW_ALL = "SELECT * FROM clientspring ORDER BY surname";
    private final String SQL_SAVE_CONTACT = "INSERT INTO clientspring VALUES( ?, ?, ?, ?);";

    @Autowired
    public SpringContactDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean createContact(Contact contact) {
        return jdbcTemplate.update(SQL_SAVE_CONTACT, contact.getSurname(), contact.getName(), contact.getPhoneNumber(), contact.getAge()) > 0;
    }

    @Override
    public boolean deleteContact(Contact contact) {
        return jdbcTemplate.update(SQL_REMOVE_CONTACT, contact.getSurname()) > 0;
    }

    @Override
    public boolean editContact(Contact contact,String oldSurname) {
        return jdbcTemplate.update(SQL_UPDATE_CONTACT, contact.getSurname(), contact.getName(),
                contact.getPhoneNumber(), contact.getAge(),oldSurname) > 0;

    }

    @Override
    public List<Contact> showAllContacts() {
        return jdbcTemplate.query(SQL_SHOW_ALL, new ContactMapper());
    }

    @Override
    public Contact getSurname(String surname) {
        return jdbcTemplate.queryForObject(SQL_FIND_CONTACT_BY_SURNAME, new Object[]{surname}, new ContactMapper());
    }
}
