package email.selenium.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by GaBi on 16.06.2016.
 *
 */
public class LogInPage extends BasePage{

    @FindBy(id = "Email")
    private WebElement loginField;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "Passwd")
    private WebElement passwordField;

    @FindBy(xpath = ".//label[@class='remember']")
    private WebElement staySignedInCheckBox;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(xpath = ".//span[@id='errormsg_0_Email']")
    private WebElement errorMessage;

    @FindBy(xpath = ".//div[@role='tabpanel'][1]")
    private WebElement sentLettersList;

    public void clearLogin(){
        loginField.clear();
    }

    public void enterLogin(String login){
        clearLogin();
        loginField.sendKeys(login);
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void clearPassword(){
        passwordField.clear();
    }

    public void enterPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        clearPassword();
        passwordField.sendKeys(password);
    }

    public void uncheckStaySignedInCheckBox(){
        staySignedInCheckBox.click();
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public String getTitleOfFirstSentLetterInList(){
        return sentLettersList.getText();
    }
}
