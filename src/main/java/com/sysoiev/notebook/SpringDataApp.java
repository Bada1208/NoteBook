package com.sysoiev.notebook;

import com.sysoiev.notebook.config.AppSpringDataConfig;
import com.sysoiev.notebook.model.Contact;
import com.sysoiev.notebook.dao.SpringContactDao;

import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.view.CmdLineService;
import com.sysoiev.notebook.view.impl.CmdLineServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;

public class SpringDataApp {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppSpringDataConfig.class);

        SpringContactDao springContactDao = context.getBean(SpringContactDao.class);

        CmdLineService cmdLineService = context.getBean(CmdLineService.class);

        //it launches menu in order to enter data from console
        cmdLineService.runMenu();

        context.close();
    }
}
