import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty"})
public class MyTest extends AbstractTestNGCucumberTests {

}
