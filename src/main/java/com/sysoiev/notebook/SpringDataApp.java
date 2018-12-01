package com.sysoiev.notebook;

import com.sysoiev.notebook.config.AppSpringDataConfig;
import com.sysoiev.notebook.model.Contact;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SpringDataApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppSpringDataConfig.class);

        Contact contact = context.getBean(Contact.class);

        context.close();
    }
}
