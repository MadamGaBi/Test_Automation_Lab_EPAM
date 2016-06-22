package email.steps;

import email.selenium.pageObjects.BasePage;
import email.selenium.pageObjects.LogInPage;
import email.selenium.pageObjects.InBoxPage;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by GaBi on 16.06.2016.
 *
 */
public class StepsDefinition extends BasePage{
    LogInPage logInPage;
    InBoxPage inBoxPage;
    Data testData = new Data();

    @BeforeScenario
    public void initBrowser(){
        BasePage.init();
        logInPage = PageFactory.initElements(driver, LogInPage.class);
        inBoxPage = PageFactory.initElements(driver, InBoxPage.class);
    }

    @AfterScenario
    public void closeBrowser(){
        BasePage.close();
    }

    @Given("I am on LogInPage")
    public void givenIAmOnLogInPage() {
        driver.get(testData.url);
    }

    @When("I leave login field empty")
    public void whenILeaveLoginFieldEmpty() {
        logInPage.clearLogin();
    }

    @When("I click button \"Next\"")
    public void whenIClickButtonNext() {
        logInPage.clickNextButton();
    }

    @Then("Error message \"Please enter your email\" is shown")
    public void thenErrorMessagePleaseEnterYourEmailIsShown() {
        assertThat(logInPage.getErrorMessage(), containsString(testData.pleaseEnterYourEmailMessage));
    }

//    @Given("I am on LogInPage")
//    public void givenIAmOnLogInPage() {
//        driver.get(testData.url);
//    }

    @When("I enter an invalid login")
    public void whenIEnterAnInvalidLogin() {
        logInPage.enterLogin(testData.invalidLogin);
    }

//    @When("I click button \"Next\"")
//    public void whenIClickButtonNext() {
//        logInPage.clickNextButton();
//    }

    @Then("Error message \"Please enter a valid email address\" is shown")
    public void thenErrorMessagePleaseEnterAValidEmailAddressIsShown() {
        assertThat(logInPage.getErrorMessage(), containsString(testData.pleaseEnterAValidEmailAddress));
    }



//    @Given("I am on LogInPage")
//    public void givenIAmOnLogInPage() {
//        // PENDING
//    }
//
    @When("I enter a valid login")
    public void whenIEnterAValidLogin() {
        logInPage.enterLogin(testData.login);
    }
//
//    @When("I click button \"Next\"")
//    public void whenIClickButtonNext() {
//        // PENDING
//    }
//
    @When("I enter a valid password")
    public void whenIEnterAValidPassword() {
        logInPage.enterPassword(testData.password);
    }

    @When("I uncheck checkbox \"Stay signed in\"")
    public void whenIUncheckCheckboxStaySignedIn() {
        logInPage.uncheckStaySignedInCheckBox();
    }

    @When("I click button \"Sign in\"")
    public void whenIClickButtonSignIn() {
        logInPage.clickSignInButton();
    }

    @Then("InBoxPage of my account is opened")
    public void thenInBoxPageOfMyAccountIsOpened() {
        assertThat(inBoxPage.getAccountTitle(), containsString(testData.login));
    }

}
