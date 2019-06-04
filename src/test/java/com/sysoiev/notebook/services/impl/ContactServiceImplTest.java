package com.sysoiev.notebook.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContactServiceImplTest extends Assert {
    ContactServiceImpl contactService = new ContactServiceImpl();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("@BeforeClass annotation");
    }

    @Before
    public void setUpBefore() {
        System.out.println("@Before annotation");
    }

    @Test
    public void createContactTest(String surname, String name, String phoneNumber, int age) {
        assertNotNull(createContact("Sysoiev","Bogdan","123456789",33));
    }


    @Test
    public String deleteContactTest(String surname) {
        assertNotNull(deleteContactTest("Sysoiev"));
    }

    @Test
    public void showAllContactsTest() {
        assertNotNull(contactService);
    }

    @Test
    public void editContactTest() {
        assertNotNull(contactService);
    }
}