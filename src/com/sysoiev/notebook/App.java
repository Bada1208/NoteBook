package com.sysoiev.notebook;


import com.sysoiev.notebook.services.impl.ContactServiceImpl;
import com.sysoiev.notebook.view.CmdLineService;
import com.sysoiev.notebook.view.impl.CmdLineServiceImpl;

public class App {
    public static void main(String[] args) {
        CmdLineService cmd = new CmdLineServiceImpl(new ContactServiceImpl());
        cmd.showMenu();
    }
}
