package org.prog.session21HW;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/my-test.feature",
        glue = "org.prog.session21HW.steps"
)
public class MyCucumberRunner extends AbstractTestNGCucumberTests {


}
