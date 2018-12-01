package pl.sages.bank.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"pl.sages.bank.steps"},
        plugin = {"html:target/cukes", "json:target/cucumber-report.json"},
        format = {"pretty"},
        strict = true,
        tags = {"~@ignore", "@All"}
)
public class AllTestRunner {

}