package TestRun;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/FeautureFiles/Registration.feature","src/FeautureFiles/Log.feature"},
        glue = {"StepDefination"},
        publish = true,
        monochrome = true

)

public class TestRunner {

}
