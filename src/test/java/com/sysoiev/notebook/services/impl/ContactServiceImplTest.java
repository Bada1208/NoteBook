package com.sysoiev.notebook.services.impl;

import com.sysoiev.notebook.model.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImplTest extends Assert {

    private Contact contact1;
    private Contact contact2;

    private Contact contactNotAdd1;
    private Contact contactNotAdd2;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("@BeforeClass annotation");
    }

    @Before
    public void setUpBefore() {
        System.out.println("@Before annotation");
        contact1 = new Contact("Sysoiev", "Bogdan", "123456789", 33);
        contact2 = new Contact("Sysoieva", "Anna", "987654321", 26);

        contactNotAdd1 = new Contact("", "", "", 0);
        contactNotAdd2 = new Contact(null, null, null, 0);
    }
    @Test
    public void createContact_EMPTY_SURNAME() {
        for (Contact contact : Contact.contactService.showAllContacts()) {
            if (contact.getSurname() != null && contact.getSurname().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустой фамилией");
            }
        }
    }
    @Test
    public void createContact_EMPTY_NAME() {
        for (Contact contact : Contact.contactService.showAllContacts()) {
            if (contact.getName() != null && contact.getName().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым именем");
            }
        }
    }
    @Test
    public void createContact_EMPTY_PHONE_NUMBER() {
        for (Contact contact : Contact.contactService.showAllContacts()) {
            if (contact.getPhoneNumber() != null && contact.getPhoneNumber().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым номером телефона");
            }
        }
    }

    @Test
    public void createContact_AGE_ZERO() {
        for (Contact contact : Contact.contactService.showAllContacts()) {
            if (contact.getAge() <= 0) {
                Assert.fail("Попытка создания пользователя c не допустимым возрастом");
            }
        }
    }

    @Test
    public void showAllContactsTest() {
        List<Contact> expected = Contact.contactService.showAllContacts();

        List<Contact> actual = new ArrayList<>();
        actual.add(contact1);
        actual.add(contact2);

        Assert.assertEquals(expected, actual);
    }

}