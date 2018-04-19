package com.sysoiev.notebook.dataAccessObject;

import com.sysoiev.notebook.model.Contact;

public interface ContactDao {
    /**
     * Интерфейс описывающий основное поведение работы с различными вариантами долгострочного хранения данных.
     * (файловая система, БД и т.д.)
     */

    void saveContact(Contact contact);

    void removeContact();

    void showAll();
}