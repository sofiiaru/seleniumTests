package tests;

import drivers.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.FlightsPage;
import utilities.ConfigReader;

import java.util.Set;

public class TestingPOM {

    @Test
    public void test1(){
        WebDriver driver = Driver.getDriver();
        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);

        BasePage expediaHome = new BasePage();
        //expediaHome.ListYourPropertyButton.click();
        //expediaHome.FlightsButton.click();
        expediaHome.clickFlightsButton();
    }

    @Test
    public void test2(){
        WebDriver driver = Driver.getDriver();
        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);

        BasePage expediaHome = new BasePage();
        expediaHome.FlightsButton.click();

        FlightsPage flight = new FlightsPage();
        flight.originInputField.sendKeys("Chicago, IL");
        flight.destinationInputField.sendKeys("Tampa, FL");
        flight.searchButton.click();
    }

    @Test
    public void test3(){
        WebDriver driver = Driver.getDriver();
        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);

        BasePage expediaHome = new BasePage();

        expediaHome.moveToTheBottomOfThePage();

        expediaHome.globalSites.get(2).click();

    }

    @Test
    public void testWindowHandles(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
        driver.findElement(By.id("button1")).click();

        String mainPage = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window: windows){
            if(!window.equals(mainPage))
                driver.switchTo().window(window);
        }

        driver.manage().window().maximize();

        WebElement enrollButton = driver.findElement(By.linkText("Enroll Your Self"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click;", enrollButton);


    }




}
