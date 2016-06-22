package search.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import search.selenium.BaseSelenium;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by BIL on 16.06.2016.
 *
 */
public class BaseStepDef extends BaseSelenium{
    @Given("^I set search request \"([^\"]*)\"$")
    public void iSetSearchRequest(String searchRequest){
        driver.get("http://ebay.com");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//input[@id='gh-ac']")).sendKeys(searchRequest);
    }

    @When("^I perform search$")
    public void iPerformSearch() throws Throwable {
        driver.findElement(By.xpath(".//input[@id='gh-btn']")).click();
    }

    @Then("^the tern query \"([^\"]*)\" should be the first in the Search Result grid$")
    public void theTernQueryShouldBeTheFirstInTheSearchResultGrid(String expectedPhrase) throws Throwable {
        String firstSnippet = driver.findElement(By.xpath(".//ul[@id='ListViewInner']/li[1]")).getText();
        assertThat(firstSnippet, containsString(expectedPhrase));
    }
}
