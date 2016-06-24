package testserenitybdd.anhbt;


import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefBrowser {
	private WebDriver driver,driver1;
	public void setUp(String page) throws Exception {

	System.setProperty("webdriver.chrome.driver", "C://Users/voyeu/Documents/new/chromedriver.exe");
    driver = new ChromeDriver();
    
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
	
	@Given("^the home page is visited$")
	public void the_home_page_is_visited() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String homePage = "https://google.com/";
		setUp(homePage);
		System.out.println("Open the home page");
	}

	@Given("^the page \"([^\"]*)\" is visited one$")
	public void the_page_is_visited_one(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get(arg1);
	    System.out.println("Open the page : "+arg1);
	}

	@Given("^the page is refreshed$")
	public void the_page_is_refreshed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().refresh();
		System.out.println("Refresh web page");
	}

	@Given("^maximize the window$")
	public void maximize_the_window() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().window().maximize();
		System.out.println("Maximize the window ");
	}

	@Given("^go backward one page$")
	public void go_backward_one_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().back();
		System.out.println("Go back one page ");
	}

	@Given("^go forward one page$")
	public void go_forward_one_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().forward();
		System.out.println("Go forward one page ");
	}

	@Given("^the page \"([^\"]*)\" is opened on another window$")
	public void the_page_is_opened_on_another_window(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		driver1 = new ChromeDriver();
		driver1.get(arg1);
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Open "+arg1+" on new window ");
	}
	// Todo thay lai tham so arg1 cho bodyText.contains
	@Then("^assert that the \"([^\"]*)\" text is present$")
	public void assert_that_the_text_is_present(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String bodyText = driver1.findElement(By.tagName("body")).getText();
		Assert.assertTrue("Text is not present !", bodyText.contains(arg1));
		System.out.println("Assert "+ arg1 +" is present");
	}

	@Then("^assert that the \"([^\"]*)\" text is not present$")
	public void assert_that_the_text_is_not_present(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String bodyText = driver1.findElement(By.tagName("body")).getText();
		Assert.assertTrue("Text is present!", !bodyText.contains(arg1));
		System.out.println("Assert "+ arg1 +" is not present");
	}

	@Then("^assert that the page title is \"([^\"]*)\"$")
	public void assert_that_the_page_title_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver1.getTitle();
		String expectedTitle = arg1;
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Assert "+ arg1 +" is page title");
	}

	@Then("^assert that the page title is not \"([^\"]*)\"$")
	public void assert_that_the_page_title_is_not(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver1.getTitle();
		String expectedTitle = arg1;
		assertNotEquals(actualTitle,arg1);
		System.out.println("Assert "+ arg1 +" is not page title");
	}

	@Then("^assert that the page title has \"([^\"]*)\"$")
	public void assert_that_the_page_title_has(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver1.getTitle();
		Assert.assertTrue("Text not found!", actualTitle.contains(arg1));
		if(actualTitle.contains(arg1)){
			System.out.println(actualTitle+" has "+arg1);
		}
		else{
			System.out.println(actualTitle+" doesn't have "+arg1);
		}
		
	}

	@Then("^assert that the page title does not have \"([^\"]*)\"$")
	public void assert_that_the_page_title_does_not_have(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver1.getTitle();
		Assert.assertTrue("Text not found!", !actualTitle.contains(arg1));
		if(actualTitle.contains(arg1)){
			System.out.println(actualTitle+" has "+arg1);
		}
		else{
			System.out.println(actualTitle+" doesn't have "+arg1);
		}
	}

	@Then("^assert that the url is \"([^\"]*)\"$")
	public void assert_that_the_url_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   String url = driver1.getCurrentUrl();
	   Assert.assertEquals(url, arg1);
		System.out.println("Assert "+ arg1 +" is current url");
	
	}

	@Then("^assert that the url is not \"([^\"]*)\"$")
	public void assert_that_the_url_is_not(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String url = driver1.getCurrentUrl();
		assertNotEquals(url, arg1);
			System.out.println("Assert "+ arg1 +" is not current url");
	}

	@When("^window dimension is changed with size \\((\\d+),(\\d+)\\)$")
	public void window_dimension_is_changed_with_size(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver1.manage().window().setPosition(new Point(0, 0));
		driver1.manage().window().setSize(new Dimension(arg1,arg2));
		System.out.println("Window dimention is changed with size : "+arg1+" , "+arg2);
	}

	@When("^scroll up or down in screen with value \\((\\d+),(\\d+)\\)$")
	public void scroll_up_or_down_in_screen_with_value(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String scroll = "window.scrollBy("+arg1+","+arg2+")";
		JavascriptExecutor jse = (JavascriptExecutor)driver1;
		jse.executeScript(scroll, "");
		System.out.println("Scoll up or down in screen with value : "+arg1+" , "+arg2);
	}

	@When("^window is moved to location with coordinates \\((\\d+),(\\d+)\\) one$")
	public void window_is_moved_to_location_with_coordinates_one(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver1.manage().window().setPosition(new Point(arg1, arg2));
		System.out.println("window is moved to location with coordinates : "+arg1+" , "+arg2);
	}

	@When("^close current window one$")
	public void close_current_window_one() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver1.close();
	    System.out.println("close current window");
	}

	@When("^switch back to the original window one$")
	public void switch_back_to_the_original_window_one() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Set<String> allWindows =  driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		}
		System.out.println("switch back to the original window");
	}

	@When("^open \"([^\"]*)\" link in new window and switch to it$")
	public void open_link_in_new_window_and_switch_to_it(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1];
		WebElement link = driver.findElement(By.linkText(name));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(6000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		          }
		       }
		   System.out.println("Open "+arg1+" link in new window and switch to it");
	}

	@When("^close current window two$")
	public void close_current_window_two() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	    System.out.println("close current window");
	}

	@When("^switch back to the original window two$")
	public void switch_back_to_the_original_window_two() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Set<String> allWindows =  driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		}
		System.out.println("switch back to the original window");
	}

	@When("^open \"([^\"]*)\" dialog and switch to it$")
	public void open_dialog_and_switch_to_it(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String selector=parts[1];
		driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/a/img")).click();
		String master = driver.getWindowHandle();
		//logic for waiting for the popup, checking the size to become greater than 1 or breaking after sometime to avoid the infinite loop.
		int timeCount = 1;

		do
		{
		   driver.getWindowHandles();
		   Thread.sleep(200);
		   timeCount++;
		   if ( timeCount > 50 ) 
		   {
		       break;
		   }
		}
		while ( driver.getWindowHandles().size() == 1 );

		//Assigning the handles to a set
		Set<String> handles = driver.getWindowHandles();
		//Switching to the popup window.
		for ( String handle : handles )
		{
		    if(!handle.equals(master))
		    {
		         driver.switchTo().window(handle);
		    }
		}
		System.out.println("open dialog and switch to it");
	}

	@When("^window is moved to location with coordinates \\((\\d+),(\\d+)\\) two$")
	public void window_is_moved_to_location_with_coordinates_two(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().window().setPosition(new Point(arg1, arg2));
		System.out.println("window is moved to location with coordinates : "+arg1+" , "+arg2);
	}

	@When("^maximize the window one$")
	public void maximize_the_window_one() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().window().maximize();
		System.out.println("Maximize the window ");
	}

	@When("^close current window three$")
	public void close_current_window_three() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	    System.out.println("close current window");

	}

	@When("^switch back to the original window three$")
	public void switch_back_to_the_original_window_three() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Set<String> allWindows =  driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		}
		System.out.println("switch back to the original window");
	}

	@When("^window dimension is changed with size \\((\\d+),(\\d+)\\) one$")
	public void window_dimension_is_changed_with_size_one(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().window().setSize(new Dimension(arg1,arg2));
		System.out.println("Window dimention is changed with size : "+arg1+" , "+arg2);
	}

	@When("^window is moved to location with coordinates \\((\\d+),(\\d+)\\) three$")
	public void window_is_moved_to_location_with_coordinates_three(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().window().setPosition(new Point(arg1, arg2));
		System.out.println("window is moved to location with coordinates : "+arg1+" , "+arg2);
	}


}
