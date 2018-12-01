package com.sysoiev.notebook;

import com.sysoiev.notebook.config.AppSpringDataConfig;
import com.sysoiev.notebook.model.Contact;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDbApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppSpringDataConfig.class);

        Contact contact = context.getBean(Contact.class);
    }
}
