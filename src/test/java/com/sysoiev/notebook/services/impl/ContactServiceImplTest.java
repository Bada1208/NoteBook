package com.sysoiev.notebook.services.impl;

import com.sysoiev.notebook.model.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImplTest extends Assert {
   public ContactServiceImpl contactService;// = new ContactServiceImpl();
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
        contactNotAdd2 = new Contact("", "", "", 0);
    }

    @Test
    public void createContactTest(String surname, String name, String phoneNumber, int age) {
       // assertNotNull(createContact("Sysoiev", "Bogdan", "123456789", 33));
    }
    /*//создаем тестовые данные
    User user = new User("Евгений", 35, Sex.MALE);
    User user1 = new User("Марина", 34, Sex.FEMALE);
    User user2 = new User("Алина", 7, Sex.FEMALE);

    //создаем список expected и заполняем его данными нашего метода
    List<User> expected = User.getAllUsers();

    //создаем список actual в него помещаем данные для сравнения
    //то что мы предпологиаем метод должен вернуть
    List<User> actual = new ArrayList<>();
    actual.add(user);
    actual.add(user1);
    actual.add(user2);

    //запускаем тест, в случае если список expected и actual не будут равны
    //тест будет провален, о результатах теста читаем в консоли
    Assert.assertEquals(expected, actual);*/


    @Test
    public void deleteContactTest(String surname) {
        //assertNotNull(deleteContactTest("Sysoiev"));
    }

    @Test
    public void showAllContactsTest() {
        List<Contact> expected = Contact.contactService.showAllContacts();

        List<Contact> actual = new ArrayList<>();
        actual.add(contact1);
        actual.add(contact2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void editContactTest() {
        assertNotNull(contactService);
    }
}