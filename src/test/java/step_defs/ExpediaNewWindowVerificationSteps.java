package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utilities.ConfigReader;

import java.util.Iterator;
import java.util.Set;

public class ExpediaNewWindowVerificationSteps {
    WebDriver driver;
    BasePage expediaHome = new BasePage();

    @Given("^the user is on the main expedia page$")
    public void the_user_is_on_the_main_expedia_page() throws Throwable {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @When("^the user clicks on 'list your property button'$")
    public void the_user_clicks_on_list_your_property_button() throws Throwable {
        expediaHome.ListYourPropertyButton.click();
    }

    @Then("^the new tab should open$")
    public void the_new_tab_should_open() throws Throwable {
        String parentPage = driver.getWindowHandle();
        Set<String> openTabs = driver.getWindowHandles();
        /*for (String tab: openTabs) {
            if(!tab.equals(parentPage)){
                driver.switchTo().window(tab);
            }
        }*/
        Iterator<String> iter = openTabs.iterator();
        while(iter.hasNext()){
                String childPage = iter.next();
                if(!parentPage.equals(childPage)){
                    driver.switchTo().window(childPage);
                    System.out.println(driver.getTitle());
                }
        }
    }

    @Then("^how much could you earn text is be displayed$")
    public void how_much_could_you_earn_text_is_be_displayed() throws Throwable {
        //div[@id='calc-data']//h2
        WebElement earnings = driver.findElement(By.xpath("//div[@id='calc-data']//h2"));
        Assert.assertTrue(earnings.isDisplayed());
    }


}
