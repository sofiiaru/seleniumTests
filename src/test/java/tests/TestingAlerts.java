package tests;

import drivers.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestingAlerts {

    @Test
    public void testingAlerts1() throws InterruptedException{
        WebDriver driver = Driver.getDriver();

        driver.get("https://www.testandquiz.com/selenium/testing.html");
        driver.findElement(By.xpath("//button[contains(text(), 'Generate Alert Box')]")).click();

        Alert myFirstAlert = driver.switchTo().alert();
        Thread.sleep(3000);
        myFirstAlert.accept();

        WebElement dblClickButton = driver.findElement(By.id("dblClkBtn"));

        Actions action = new Actions(driver);
        action.doubleClick(dblClickButton).perform();

        Alert mySecondAlert = driver.switchTo().alert();
        Thread.sleep(2000);
        mySecondAlert.accept();

        driver.findElement(By.xpath("//button[text()='Generate Confirm Box']")).click();
        mySecondAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        mySecondAlert.dismiss();
        Assert.assertEquals("You pressed Cancel!", driver.findElement(By.id("demo")).getText());

        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        driver.findElement(By.name("prompt")).click();
        mySecondAlert = driver.switchTo().alert();
        System.out.println(mySecondAlert.getText());
        mySecondAlert.sendKeys("DevXSchool");
        Thread.sleep(2000);
        mySecondAlert.accept();
        driver.close();
    }
}
