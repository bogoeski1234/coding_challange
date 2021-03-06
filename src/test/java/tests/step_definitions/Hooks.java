package tests.step_definitions;



import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.utilities.ConfigurationReader;
import tests.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {



    @Before
    public void setUp(){
        System.out.println("Before hooks");
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }




    @After
    public void tearDown(Scenario scenario){
        System.out.println("After hooks");
        // check if the scenario is failed
        if (scenario.isFailed()){
            // take that screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            // attach the scenario to the report
            scenario.embed(screenshot, "image/png");
        }
        Driver.closeDriver();
    }


}
