package com.sysoiev.notebook.model;

/**
 * Next step is to create model classes to map our database table.
 * For fetching data from database we need to implement interface RowMapper.
 * This interface has only one method mapRow(ResultSet resultSet, int i), which
 * will return one instance of our model class (i.e. Contact).
 */

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {

        Contact contact = new Contact();
        contact.setSurname(resultSet.getString("surname"));
        contact.setName(resultSet.getString("name"));
        contact.setPhoneNumber(resultSet.getString("phoneNumber"));
        contact.setAge(resultSet.getInt("age"));
        return contact;
    }
}
