package testserenitybdd.anhbt;

import java.io.File;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertNotEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class StepDefElementText {
	private WebDriver driver;
	public void setUp(String page) throws Exception {
		
		File file = new File("C:\\newPrj\\Driver\\MicrosoftWebDriver.exe");

	    System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setBrowserName("Edge");
	    capabilities.setCapability("browser_version", "12.0");
	    capabilities.setCapability("os", "Windows");
	    capabilities.setCapability("os_version", "10");
	    capabilities.setCapability("resolution", "1024x768");
	    driver = new EdgeDriver(capabilities);
	    driver.get(page);
	}
	//Scenario: Answer the prompt box
	
	public WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return driver.findElement(locator);
			}
		});
	}
	
	@Given("^the page \"([^\"]*)\" is visited first of all$")
	public void the_page_is_visited(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		setUp(arg1);
		//Thread.sleep(10000);
		System.out.println("Go to page "+arg1);
	}
	@Then("^assert that the text \"([^\"]*)\" element is the text \"([^\"]*)\"$")
	public void assert_that_the_text_element_is(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String selector=parts[1];
		String result = driver.findElement(By.cssSelector(selector)).getText();
		Assert.assertEquals(result, arg2);
		System.out.println("Assert "+ arg2 +" is the text : "+result);
	}
	@Then("^assert that the text \"([^\"]*)\" element is not \"([^\"]*)\"$")
	public void assert_that_the_text_element_is_not(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String selector=parts[1];
		String result = driver.findElement(By.cssSelector(selector)).getText();
		assertNotEquals(result,arg2);
		System.out.println("Assert "+ result +" is not the text : "+arg2 );
	}

	@Then("^assert that the text \"([^\"]*)\" element has \"([^\"]*)\"$")
	public void assert_that_the_text_element_has(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String selector=parts[1];
		String result = driver.findElement(By.cssSelector(selector)).getText();
		Assert.assertTrue("Text is not included", result.contains(arg2));
		System.out.println("Assert "+ result +" contain the text : "+arg2 );
	}

	@Then("^assert that the text \"([^\"]*)\" element does not have \"([^\"]*)\"$")
	public void assert_that_the_text_element_does_not_have(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String selector=parts[1];
		String result = driver.findElement(By.cssSelector(selector)).getText();
		Assert.assertTrue("Text is present!", !result.contains(arg2));
		System.out.println("Assert "+ result +" does not have the text : "+arg2 );
	}
}
