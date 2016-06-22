package search;

import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import search.selenium.BaseSelenium;

/**
 * Created by BIL on 16.06.2016.
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)
public class RunAcceptanceTest {

    @BeforeClass
    public static void initSelenium(){
    BaseSelenium.init();
}
    @AfterClass
    public static void closeSelenium(){
        BaseSelenium.close();
    }
}
