package com.sysoiev.notebook.view.controller;

import com.sysoiev.notebook.dataAccessObject.impl.DBContactDao;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.services.impl.ContactServiceImpl;
import com.sysoiev.notebook.services.impl.FSContactServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;

public class MainController {

    private ContactService contactService;

    public MainController() {
        this.contactService = new FSContactServiceImpl(new DBContactDao());
    }

    @FXML
    private TextField inputSurname;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputphonenumber;

    @FXML
    private TextField inputAge;

    @FXML
    private Button createButton;

    @FXML
    private TableView<Contact> table;

    @FXML
    private TableColumn<Contact, String> surnameColumn;

    @FXML
    private TableColumn<Contact, String> nameColumn;

    @FXML
    private TableColumn<Contact, String> phonenumberColumn;

    @FXML
    private TableColumn<Contact, Integer> ageColumn;

    public void createContact() {
        String surName = inputName.getText();
        String name = inputName.getText();
        String phoneNumber = inputName.getText();
        String age = inputAge.getText();

        contactService.createContact(surName, name, phoneNumber, new Integer(age));
    }

    @FXML
    public void initialize() {
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        table.setItems(contactService.showAllContacts());
    }

}
