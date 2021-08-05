package com.botscrew.university.service;

import org.springframework.stereotype.Service;

@Service
public class MenuPrinter {

    private static final String MENU_TEXT =
            "To use app commands you need to choose number from 1 to 5:\n" +
                    "1. Who is head of department\n" +
                    "2. Show department statistics\n" +
                    "3. Show the average salary for the department\n" +
                    "4. Show count of employees for the department\n" +
                    "5. Global search by template\n" +
                    "6. Exit\n" +
                    "Enter your number: ";

    public void printMenu() {
        System.out.println(MENU_TEXT);
    }
}
