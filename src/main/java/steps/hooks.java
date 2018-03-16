package steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import utils.GetProperties;

public class hooks {

    @Before
    public void BeforeScenario(Scenario scenario){
        GetProperties.GetProperties();
        System.out.println("Running Scenario : "+ scenario.getName());
    }
}
