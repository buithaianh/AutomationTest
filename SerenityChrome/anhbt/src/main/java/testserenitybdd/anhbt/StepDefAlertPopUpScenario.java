package testserenitybdd.anhbt;



import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Function;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefAlertPopUpScenario {
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
		@Given("^the page \"([^\"]*)\" is visited$")
		public void the_page_is_visited(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			setUp(arg1);
			//Thread.sleep(10000);
			System.out.println("Scenario 1, go to page "+arg1);
		}

		@Given("^go inside the \"([^\"]*)\" frame$")
		public void go_inside_the_frame(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String[] parts = arg1.split("=");
			String name=parts[1];
			
			By by = By.id(name);
			WebElement iFrame = findElement(driver, by, 60)  ;
			driver.switchTo().frame(iFrame);
			driver.findElement(By.xpath("html/body/button")).click();
			System.out.println("Scenario 1 , go inside the frame "+arg1);

		}

		@Given("^input \"([^\"]*)\" on prompt dialog box \"([^\"]*)\"$")
		public void input_on_prompt_dialog_box(String arg1, String arg2) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(arg1);
			alert.accept();
			System.out.println("Scenario 1, input "+arg1);

		}

		@Then("^assert that the text \"([^\"]*)\" element is \"([^\"]*)\"$")
		public void assert_that_the_text_element_is(String arg1, String arg2) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String[] parts = arg1.split("=");
			String name=parts[1];
			assertEquals(arg2,driver.findElement(By.id(name)).getText());
			System.out.println("Scenario 1,assert text is : "+arg2);

		}
		//Scenario Dismiss the confirm box
		@Given("^the page \"([^\"]*)\" is visited Two$")
		public void the_page_is_visited_Two(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			setUp(arg1);
			System.out.println("Scenario 2");
		}

		@Given("^go inside the \"([^\"]*)\" frame Two$")
		public void go_inside_the_frame_Two(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String[] parts = arg1.split("=");
			String name=parts[1];
			
			By by = By.id(name);
			WebElement iFrame = findElement(driver, by, 60)  ;
			driver.switchTo().frame(iFrame);
			driver.findElement(By.xpath("html/body/button")).click();
			System.out.println("Scenario 2 , go inside the frame "+arg1);
		}

		@Given("^choose CANCEL on confirm dialog box \"([^\"]*)\" Two$")
		public void choose_CANCEL_on_confirm_dialog_box_Two(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			System.out.println("Scenario 2 choose cancel");
		}

		@Then("^assert that the text \"([^\"]*)\" element is \"([^\"]*)\" Two$")
		public void assert_that_the_text_element_is_Two(String arg1, String arg2) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String[] parts = arg1.split("=");
			String name=parts[1];
			assertEquals(arg2,driver.findElement(By.id(name)).getText());
			System.out.println("Scenario 2,assert text is : "+arg2);
		
		}
		//Scenario: Accept the confirm box
		@Given("^the page \"([^\"]*)\" is visited Three$")
		public void the_page_is_visited_Three(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			setUp(arg1);
			System.out.println("Scenario 3");
		}

		@Given("^go inside the \"([^\"]*)\" frame Three$")
		public void go_inside_the_frame_Three(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String[] parts = arg1.split("=");
			String name=parts[1];
			
			By by = By.id(name);
			WebElement iFrame = findElement(driver, by, 60)  ;
			driver.switchTo().frame(iFrame);
			driver.findElement(By.xpath("html/body/button")).click();
			System.out.println("Scenario 3 , go inside the frame "+arg1);
		}

		@Given("^choose OK on confirm dialog box \"([^\"]*)\" Three$")
		public void choose_OK_on_confirm_dialog_box_Three(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Alert alert=driver.switchTo().alert();
			alert.accept();
			System.out.println("Scenario 3 choose OK");
		}

		@Then("^assert that the text \"([^\"]*)\" element is \"([^\"]*)\" Three$")
		public void assert_that_the_text_element_is_Three(String arg1, String arg2) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String[] parts = arg1.split("=");
			String name=parts[1];
			assertEquals(arg2,driver.findElement(By.id(name)).getText());
			System.out.println("Scenario 3,assert text is : "+arg2);
		}
		//Scenario: Verify text on the popup
		@Given("^the page \"([^\"]*)\" is visited Four$")
		public void the_page_is_visited_Four(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			setUp(arg1);
			System.out.println("Scenario 4");
		}

		@Given("^go inside the \"([^\"]*)\" frame Four$")
		public void go_inside_the_frame_Four(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String[] parts = arg1.split("=");
			String name=parts[1];
			
			By by = By.id(name);
			WebElement iFrame = findElement(driver, by, 60)  ;
			driver.switchTo().frame(iFrame);
			driver.findElement(By.xpath("html/body/button")).click();
			System.out.println("Scenario 4 , go inside the frame "+arg1);
		
		}

		@Then("^assert that text on \"([^\"]*)\" popup box is \"([^\"]*)\" Four$")
		public void assert_that_text_on_popup_box_is_Four(String arg1, String arg2) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Alert alert=driver.switchTo().alert();
			String text = alert.getText();
			assertEquals(arg2,text);
			System.out.println("Scenario 4 ,assert text is : "+arg2);
		
		}
}
