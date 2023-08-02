package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue={"stepDefination","helper"},tags="@Reg",
plugin={"html:target/testReport/cucumber.html","json:target/jsonReport/cucumber.json"})
public class TestRunner {
	

}
