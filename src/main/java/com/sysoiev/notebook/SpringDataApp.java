package com.sysoiev.notebook;

import com.sysoiev.notebook.config.AppSpringDataConfig;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.dao.SpringContactDao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDataApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppSpringDataConfig.class);

        SpringContactDao springContactDao = context.getBean(SpringContactDao.class);

        System.out.println("List of contacts is:");

        for (Contact c : springContactDao.getAllContacts()) {
            System.out.println(c);
        }

        context.close();
    }
}
