package email.selenium.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

/**
 * Created by GaBi on 16.06.2016.
 *
 */
public class InBoxPage extends BasePage {

//    @FindBy(xpath = ".//a[contains(@title, 'Account Google')]")
    @FindBy(xpath = ".//a[contains(@title, 'Аккаунт Google')]")
    private WebElement account;

    @FindBy(xpath = "//div[@class='z0']/div[@role='button']")
    private WebElement createLetterButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement enterEmailBox;

    @FindBy(xpath = "//b[@class='Jd-JU']")
    private WebElement hintEmail;

    @FindBy(name = "subjectbox")
    private WebElement subjectBox;

    @FindBy(xpath = "//div[@class='a1 aaA aMZ']")
    private WebElement addAttachmentButton;

    @FindBy(className = "dO")
    private WebElement attachmentLink;

    @FindBy(xpath = "//div[@class='J-J5-Ji']/div[2][@role='button']")
    private WebElement sendButton;

    public String getAccountTitle(){
        return account.getAttribute("title");
    }

    public void clickOnCreateLetterButton(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(createLetterButton));
        createLetterButton.click();
    }

    public void clickOnEnterEmailBox(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(enterEmailBox));
        enterEmailBox.click();
    }

    public void clearEnterEmailBox(){
        enterEmailBox.clear();
    }

    public void enterReceiversEmail(String receiversEmail){
        enterEmailBox.sendKeys(receiversEmail);
    }

    public void useHintOfEmail(){
        try{
            if (hintEmail.isEnabled()){
                hintEmail.click();
            }
        } catch (ElementNotFoundException e){}
    }

    public void clickSubjectBox(){
        subjectBox.click();
    }

    public void clearSubjectBox(){
        subjectBox.clear();
    }

    public void enterSubject(String subjectOfLetter){
        subjectBox.sendKeys(subjectOfLetter);
    }

    public void clickAddAttachmentButton(){
        addAttachmentButton.click();
    }

    public void addAttachment(String fileForUpload) throws IOException{
        // Add attachment using AutoIT
        Runtime.getRuntime().exec(fileForUpload);
        // Wait while attachment is loading
        WebDriverWait waitForAttachment = new WebDriverWait(driver, 15);
        waitForAttachment.until(ExpectedConditions.elementToBeClickable(attachmentLink));
    }

    public void clickOnSendButton(){
        // Click on button Send letter
        sendButton.click();
    }
}
