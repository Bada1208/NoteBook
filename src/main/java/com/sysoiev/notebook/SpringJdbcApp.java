package com.sysoiev.notebook;

import com.sysoiev.notebook.config.AppSpringJdbcConfig;

import com.sysoiev.notebook.view.CmdLineService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SpringJdbcApp {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppSpringJdbcConfig.class);

       // SpringContactDao springContactDao = context.getBean(SpringContactDao.class);

        CmdLineService cmdLineService = context.getBean(CmdLineService.class);

        //it launches menu in order to enter data from console
        cmdLineService.runMenu();

        context.close();
    }
}
