package pl.sages.bank.steps;

import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

public class BackgroundSteps {

    static final Logger log = Logger.getLogger(BackgroundSteps.class);

    @Before
    public void before(Scenario scenario) throws IOException, InterruptedException {
        log.info("Before Scenario Step");
    }

    @After
    public void after(Scenario scenario) throws SQLException, IOException, InterruptedException {
        log.info("After Scenario Step");
        if (scenario.isFailed()) {
            log.warn("Scenario Failed!");
        }
    }

}
