package com.sysoiev.notebook.model;


public class Contact {

    /**
     * Класс модель.
     * Этот класс представляет основные сущности и хранимый тип данных.
     * Это логические сущности которые управляются слоем сервисов бизнес логики.
     */

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
        if (surname != null && !surname.isEmpty() && name != null && !name.isEmpty() && phoneNumber != null
                && !phoneNumber.isEmpty() && age > 0) {
            this.surname = surname;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.age = age;
        }
    }
}