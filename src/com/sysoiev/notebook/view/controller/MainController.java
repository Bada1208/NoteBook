package com.sysoiev.notebook.view.controller;

import com.sysoiev.notebook.dataAccessObject.impl.DBContactDao;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.services.impl.ContactServiceImpl;
import com.sysoiev.notebook.services.impl.FSContactServiceImpl;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Method;

public class MainController {

    private ContactService contactService;


    private Stage editDialogStage

    public MainController() {
        this.contactService = new FSContactServiceImpl(new DBContactDao());
    }

    public void showDialog(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scenes/edit.fxml"));
            stage.setTitle("Peдактирование записи");
            stage.setMinHeight(150);
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView tableAddressBook;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableColumn<Contact, String> surnameColumn;

    @FXML
    private TableColumn<Contact, String> nameColumn;

    @FXML
    private TableColumn<Contact, String> phonenumberColumn;

    @FXML
    private TableColumn<Contact, Integer> ageColumn;


    public void createContact() {
        String surname = surnameColumn.getText();
        String name = nameColumn.getText();
        String phoneNumber = phonenumberColumn.getText();
        String age = ageColumn.getText();

        contactService.createContact(surname, name, phoneNumber, new Integer(age));
    }

    @FXML
    public void initialize() {
       // tableAddressBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);// in a case when we want to choose few notes
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableAddressBook.setItems(contactService.showAllContacts());
    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        // если нажата не кнопка - выходим из метода
        if (!(source instanceof Button)) {
            return;
        }
        Button clickedButton = (Button) source;
        Contact selectedContact = (Contact) tableAddressBook.getSelectionModel().getSelectedItem();


        switch (clickedButton.getId()) {
            case "btnAdd":
                System.out.println("add " + selectedContact);
//                editDialogController.setPerson(new Person());
//                showDialog();
//                addressBookImpl.add(editDialogController.getPerson());
                break;

            case "btnEdit":
                System.out.println("edit " + selectedContact);
//                if (!personIsSelected(selectedPerson)) {
//                    return;
//                }
//
//                editDialogController.setPerson(selectedPerson);
//                showDialog();
                break;

            case "btnDelete":
                System.out.println("delete " + selectedContact);
//                if (!personIsSelected(selectedPerson)) {
//                    return;
//                }
//
//                addressBookImpl.delete(selectedPerson);
                break;
        }


    }
}