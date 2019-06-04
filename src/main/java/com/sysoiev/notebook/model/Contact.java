package com.sysoiev.notebook.model;


import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.services.impl.ContactServiceImpl;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

public class Contact {
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static ContactService contactService;
    //ContactServiceImpl contactService;
    /**
     * Класс модель.
     * Этот класс представляет основные сущности и хранимый тип данных.
     * Это логические сущности которые управляются слоем сервисов бизнес логики.
     */

    // private int id;
    private String surname;
    private String name;
    private String phoneNumber;
    private int age;

    public Contact() {

    }

    @Override
    public String toString() {
        return "Contact{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }

    public Contact(String surname, String name, String phoneNumber, int age) {
        //this.id = id;
        if (name != null && !name.isEmpty() && surname != null && !surname.isEmpty() && phoneNumber != null
                && !phoneNumber.isEmpty() && age > 0) {
            this.surname = surname;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.age = age;

        /*
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {
            this.name = name;
            this.age = age;
            this.sex = sex;

            if (!hasUser()) {
                countId++;
                this.id = countId;
                allUsers.put(id, this);
            }*/
        }
/*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

        /*public String getSurname () {
            return surname;
        }

        public void setSurname (String surname){
            this.surname = surname;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getPhoneNumber () {
            return phoneNumber;
        }

        public void setPhoneNumber (String phoneNumber){
            this.phoneNumber = phoneNumber;
        }

        public int getAge () {
            return age;
        }

        public void setAge ( int age){
            this.age = age;
        }
*/

   /* @Override
    public boolean equals(Contact c) {
        if (this == c) return true;
        if (c == null || getClass() != c.getClass()) return false;
        Contact contact = (Contact) c;
        return age == contact.age &&
                Objects.equals(surname, contact.surname) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
        // }

    @Override
    public int hashCode() {

        return Objects.hash( surname, name, phoneNumber, age);
    }*/

    }
}