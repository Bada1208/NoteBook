package com.sysoiev.notebook.view.impl;

import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.view.CmdLineService;

public class CmdLineServiceImpl implements CmdLineService {

        private ContactService contactService;

        public CmdLineServiceImpl(ContactService contactService){
            this.contactService = contactService;
        }


        @Override
        public void showMenu(){
            System.out.println("Menu");

    }
}
