package com.sysoiev.notebook.model;

import java.util.Objects;

public class Contact {

    /**
     * Класс модель.
     * Этот класс представляет основные сущности и хранимый тип данных.
     * Это логические сущности которые управляются слоем сервисов бизнес логики.
     */

    private String surname;
    private String name;
    private String phoneNumber;
    private int age;

    public Contact(String surname, String name, String phoneNumber, int age) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return age == contact.age &&
                Objects.equals(surname, contact.surname) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(surname, name, phoneNumber, age);
    }

    @Override
    public String toString() {
        return "Contact:" + '\n' +
                "surname = " + surname + '\n' +
                "name = " + name + '\n' +
                "phone number = " + phoneNumber + '\n' +
                "age = " + age;
    }

}
