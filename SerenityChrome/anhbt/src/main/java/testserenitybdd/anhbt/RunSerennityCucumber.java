package testserenitybdd.anhbt;


	import cucumber.api.CucumberOptions;
	import net.serenitybdd.cucumber.CucumberWithSerenity;
	import org.junit.runner.RunWith;

	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(features="src/main/java/featurefiles/Browser.feature")
	public class RunSerennityCucumber {}
