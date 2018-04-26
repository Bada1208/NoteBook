package com.sysoiev.notebook.view.controller;

import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.services.impl.ContactServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import java.awt.*;

public class MainController {

    private ContactService contactService;

    public MainController() {
        this.contactService = new ContactServiceImpl();
    }

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputAge;

    @FXML
    private Button createButton;

    @FXML
    private TableColumn<Contact, String> nameColumn;

    @FXML
    private TableColumn<Contact, Integer> ageColumn;

    public void createContact(){

        String name = inputName.getText();
        String age = inputAge.getText();

        contactService.createContact(name,new Integer(age));
    }

}
