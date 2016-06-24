package testserenitybdd.anhbt;


import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import static org.junit.Assert.assertNotEquals;

public class StepDefAttribute {
	private WebDriver driver;
	public void setUp(String page) throws Exception {

	System.setProperty("webdriver.chrome.driver", "C://Users/voyeu/Documents/new/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	
	@Given("^the page \"([^\"]*)\" is visited first$")
	public void the_page_is_visited(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		setUp(arg1);
		//Thread.sleep(10000);
		System.out.println("Go to page "+arg1);
	}
	
	@Then("^assert that the \"([^\"]*)\" attribute of \"([^\"]*)\" is \"([^\"]*)\" text$")
	public void assert_that_the_attribute_of_is_text(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg2.split("=");
		String name=parts[1];
		assertEquals(arg3, driver.findElement(By.xpath(name)).getAttribute(arg1));
		System.out.println("Assert text of alt attribute is : "+arg3);
	}

	@Then("^assert that the \"([^\"]*)\" attribute of \"([^\"]*)\" is \"([^\"]*)\" string$")
	public void assert_that_the_attribute_of_is_string(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg2.split("=");
		String name=parts[1];
		assertEquals(arg3, driver.findElement(By.xpath(name)).getAttribute(arg1));
		System.out.println("Assert text of title attribute is : "+arg3);
	}

	@Then("^assert that the \"([^\"]*)\" attribute of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void assert_that_the_attribute_of_is(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg2.split("=");
		String name=parts[1];
		assertEquals(arg3, driver.findElement(By.xpath(name)).getAttribute(arg1));
		System.out.println("Assert text of scr attribute is : "+arg3);
	}

	@SuppressWarnings("deprecation")
	@Then("^assert that the \"([^\"]*)\" attribute of \"([^\"]*)\" has \"([^\"]*)\"$")
	public void assert_that_the_attribute_of_has(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg2.split("=");
		String name=parts[1];
		String result = driver.findElement(By.xpath(name)).getAttribute(arg1);
		if(result.contains(arg3)){
			System.out.println(result+" has "+arg3);
		}
		else{
			System.out.println(result+" doesn't have "+arg3);
		}
		Assert.assertTrue("Text not found!", result.contains(arg3));
	}

	@SuppressWarnings("deprecation")
	@Then("^assert that the \"([^\"]*)\" attribute of \"([^\"]*)\" does not have \"([^\"]*)\"$")
	public void assert_that_the_attribute_of_does_not_have(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg2.split("=");
		String name=parts[1];
		String result = driver.findElement(By.xpath(name)).getAttribute(arg1);
		if(result.contains(arg3)){
			System.out.println(result+" has "+arg3);
		}
		else{
			System.out.println(result+" doesn't have "+arg3);
		}
		Assert.assertTrue("Text found!", !result.contains(arg3));
	}

	@Then("^assert that the \"([^\"]*)\" attribute of \"([^\"]*)\" is not \"([^\"]*)\"$")
	public void assert_that_the_attribute_of_is_not(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg2.split("=");
		String name=parts[1];
		String result = driver.findElement(By.xpath(name)).getAttribute(arg1);
		assertNotEquals(result,arg3);
	
	}

}
