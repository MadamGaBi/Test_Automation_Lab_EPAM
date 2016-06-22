package email.steps;

/**
 * Created by GaBi on 16.06.2016.
 */
public class Data {
    String login;
    String invalidLogin;
    String password;
    String receiversEmail;
    String subjectOfLetter;
    String pleaseEnterYourEmailMessage;
    String pleaseEnterAValidEmailAddress;
    String url;
    String fileForUpload;

    Data(){
        this.login = "bila.galyna@gmail.com";
        this.invalidLogin = "@%abc";
        this.password = "***********";
        this.receiversEmail = "bila.galyna@gmail.com";
        this.subjectOfLetter = "TEST";
//        this.pleaseEnterYourEmailMessage = "Please enter your email.";
        this.pleaseEnterYourEmailMessage = "Введите адрес электронной почты.";
//        this.pleaseEnterAValidEmailAddress = "Please enter a valid email address.";
        this.pleaseEnterAValidEmailAddress = "Введите допустимый адрес электронной почты.";
        this.url = "https://mail.google.com";
        this.fileForUpload = "FileForUpload.exe";
    }
}
