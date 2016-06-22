package com.company;

import java.util.Scanner;

/**
 * Created by GaBi on 10.04.2016.
 * class of controlling input values
 */

public class Controller {

    // The Regex
    // «Halyna»
    public static final String REGEX_NAME = "^[A-Z][a-z]{1,10}$";
    // «Bila»
    public static final String REGEX_SURNAME = "^[A-Z][a-z]{1,10}$";
    // «nickName»
    public static final String REGEX_NICKNAME = "^[A-Za-z0-9]{1,10}$";
    // «nick@mail.com»
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // «+38(044)555-55-55»
    public static final String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    // TODO: 10.04.2016 other data about user

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        model.setName(inputValueWithScanner(sc, REGEX_NAME, View.INPUT_NAME));
        model.setSurName(inputValueWithScanner(sc, REGEX_SURNAME, View.INPUT_SURNAME));
        model.setNickName(inputValueWithScanner(sc, REGEX_NICKNAME, View.INPUT_NICKNAME));
        model.seteMail(inputValueWithScanner(sc, REGEX_MAIL, View.INPUT_MAIL));
        // TODO: 10.04.2016 set other data about user by the same way
        view.printMessageAndMessage(View.INPUT_NAME, model.getName());
        view.printMessageAndMessage(View.INPUT_NICKNAME, model.getNickName());
        // TODO: 10.04.2016 print other data about user by the same way
        view.printMessage(model.toString()); // print all data about user in the notebook
        /*TODO: 10.04.2016
        model.setNotebook(model.addDataToNotebook()); // add new data in the notebook
        view.printMessageAndNotebook(View.NOTEBOOK, model.getNotebook()); // print all data in the notebook
        */
    }

    // The Utility method
    public String inputValueWithScanner(Scanner sc, String regEx, String message) {
        boolean finished = false;
        String scanner = null;
        view.printMessage(View.INPUT_DATA + message);
        while ( ! finished ) {
            scanner = sc.nextLine().trim();
            finished = scanner.matches(regEx);
            if (! finished) {
                view.printMessage(View.WRONG_INPUT_DATA + message);
            }
        }
        return scanner;
    }
}
