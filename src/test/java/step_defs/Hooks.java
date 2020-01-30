package step_defs;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.EnvironmentManager;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().manage().window().maximize();
        EnvironmentManager.setUp();
        //set up your environment
        //anything else that may be needed to be set up before every single scenario in your framework
    }

    @After
    public void tearDown(Scenario scenario){
        //clean up after every test
        try{
            //taking screenshot and adding to the report
            if(scenario.isFailed()){
              final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
              scenario.embed(screenshot, "image/png");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


        Driver.closeDriver();
    }





}
