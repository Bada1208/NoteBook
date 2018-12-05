package com.sysoiev.notebook;

import com.sysoiev.notebook.config.AppSpringDataConfig;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.dao.SpringContactDao;

import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.view.CmdLineService;
import com.sysoiev.notebook.view.impl.CmdLineServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SpringDataApp {

     static ContactService contactService;

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppSpringDataConfig.class);

        SpringContactDao springContactDao = context.getBean(SpringContactDao.class);
        CmdLineService cmdLineService = context.getBean(CmdLineService.class);
        //CmdLineService cmd = new CmdLineServiceImpl(contactService);


        cmdLineService.runMenu();
        /*System.out.println("List of contacts is:");

        for (Contact c : springContactDao.getAllContacts()) {
            System.out.println(c);
        }*/

        context.close();
    }
}
