import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features", glue = "steps")
public class MyTest {
    @Test
    public void runTests(){
    }
}
