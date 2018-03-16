package utils;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        features = {"src/main/resources/features/"},
        dryRun = false,
        glue="steps",
        format = {"pretty","html:target/Destination"}
)
public class TestRunner {
}
