package com.sysoiev.notebook;


import com.sysoiev.notebook.services.impl.ContactServiceImpl;
import com.sysoiev.notebook.view.CmdLineService;
import com.sysoiev.notebook.view.impl.CmdLineServiceImpl;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        CmdLineService cmd = new CmdLineServiceImpl(new ContactServiceImpl());
        cmd.runMenu();
    }
}
