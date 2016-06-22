package com.company;

import java.util.ArrayList;

/**
 * Created by GaBi on 10.04.2016.
 * class of program logic of creating notebook
 */

public class Model {
    private String name;
    private String surName;
    private String nickName;
    private String comment;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String eMail;
    private String skype;
    private String dateOfNote;
    private String dateOfChange;
    private String address;

    private ArrayList<String> notebook;

    public Model() {
    }

    public Model(String name, String surName, String nickName, String comment,
                 String group, String homePhone, String mobilePhone, String eMail,
                 String skype, String dateOfNote, String dateOfChange, String address) {
        this.name = name;
        this.surName = surName;
        this.nickName = nickName;
        this.comment = comment;
        this.group = group;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.eMail = eMail;
        this.skype = skype;
        this.dateOfNote = dateOfNote;
        this.dateOfChange = dateOfChange;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getDateOfNote() {
        return dateOfNote;
    }

    public void setDateOfNote(String dateOfNote) {
        this.dateOfNote = dateOfNote;
    }

    public String getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(String dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getNotebook() {
        return notebook;
    }

    public void setNotebook(ArrayList<String> notebook) {
        this.notebook = notebook;
    }

    // The Program logic

    /**
     * this method overrides toString
     * @return String with data about user
     */

    @Override
    public String toString() {
        return "UserData { " +
                "name=" + name + '\n' +
                "surName=" + surName + '\n' +
                "nickName=" + nickName + '\n' +
                "comment=" + comment + '\n' +
                "group=" + group + '\n' +
                "homePhone=" + homePhone + '\n' +
                "mobilePhone=" + mobilePhone + '\n' +
                "eMail=" + eMail + '\n' +
                "skype=" + skype + '\n' +
                "dateOfNote=" + dateOfNote + '\n' +
                "dateOfChange=" + dateOfChange + '\n' +
                "address=" + address + '\n' +
                '}';
    }

    /** TODO: 10.04.2016
     * this method adds new data to notebook
     * @return notebook
     */
    /*
    public ArrayList<String> addDataToNotebook() {
        notebook.add(toString());
        return notebook;
    }
    */
}
