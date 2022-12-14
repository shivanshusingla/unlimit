package com.unlimit.runners;

import com.unlimit.utils.Browser;
import com.unlimit.utils.Config;
import com.unlimit.utils.InitializeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/main/resources/features"}, glue = {"com.unlimit.steps", "com.unlimit.runners"}, plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json"}, monochrome = true, tags = "@Testcase1")
public class CucumberRunner {
    protected TestNGCucumberRunner testNGCucumberRunner;
    Config config;

    @BeforeSuite(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @Before
    public void openBrowser() {
        String browserName = config.getPropertyValue("browser.name");
        config.driver = InitializeDriver.initializeDriver(browserName);
        Browser.maximizeBrowser();
    }

    @After
    public void closeBrowser() {
//        config.driver.close();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() {
        config.driver.quit();
        testNGCucumberRunner.finish();
    }
}
