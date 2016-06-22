package com.company;

import java.util.ArrayList;

/**
 * Created by GaBi on 10.04.2016.
 */

public class View {
    // Text's constants
    public static final String INPUT_DATA = "Input your data.";
    public static final String INPUT_NAME = "Input name: ";
    public static final String INPUT_SURNAME = "Input surname: ";
    public static final String INPUT_NICKNAME = "Input nickname: ";
    public static final String INPUT_MAIL = "Input mail: ";
    public static final String INPUT_PHONE = "Input phone: ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String NOTEBOOK = "Notebook data: ";
    // TODO: 10.04.2016 set other messages about input by the same way

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndMessage(String message1, String message2){
        System.out.println(message1 + message2);
    }

    public void printMessageAndNotebook(String message, ArrayList<String> notebook){
        System.out.println(message + notebook);
    }


}
