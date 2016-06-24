package testserenitybdd.anhbt;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.FluentWait;
//import org.seleniumhq.jetty9.server.Response.OutputType;

import com.google.common.base.Function;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefFrame {
	private static WebDriver driver;
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
	public void fnHighlightMe(WebDriver driver,WebElement element) throws InterruptedException{
		  //Creating JavaScriptExecuter Interface
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   for (int iCnt = 0; iCnt < 3; iCnt++) {
		      //Execute javascript
		         js.executeScript("arguments[0].style.border='4px groove green'", element);
		         Thread.sleep(1000);
		         js.executeScript("arguments[0].style.border=''", element);
		   }
		 }
	public void drawBorder(WebDriver driver, WebElement element_node){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", element_node);
    }
	public void takeScreenshotElement(WebElement element) throws IOException {
	    WrapsDriver wrapsDriver = (WrapsDriver) element;
	    File screenshot = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
	    Rectangle rectangle = new Rectangle(element.getSize().width, element.getSize().height);
	    Point location = element.getLocation();
	    BufferedImage bufferedImage = ImageIO.read(screenshot);
	    BufferedImage destImage = bufferedImage.getSubimage(location.x, location.y, rectangle.width, rectangle.height);
	    ImageIO.write(destImage, "png", screenshot);
	    File file = new File("C:\\Users\\voyeu\\Documents\\norway.png");
	    FileUtils.copyFile(screenshot, file);
	}
	
	@Given("^that the page \"([^\"]*)\" is visited$")
	public void that_the_page_is_visited(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		setUp(arg1);
		//Thread.sleep(10000);
		System.out.println("Go to page "+arg1);
	}

	@Given("^we go inside the \"([^\"]*)\" frame$")
	public void we_go_inside_the_frame(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1];
		
		By by = By.id(name);
		WebElement iFrame = findElement(driver, by, 60)  ;
		driver.switchTo().frame(iFrame);
		System.out.println("Scenario 1 , go inside the frame "+arg1);

	}

	@Then("^assert that the \"([^\"]*)\" element is enabled$")
	public void assert_that_the_element_is_enabled(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1];
		Assert.assertTrue("The element is not enabled", driver.findElement(By.name(name)).isEnabled());
		System.out.println("Assert that the "+arg1+" is enabled");
	}

	@Then("^assert that the \"([^\"]*)\" element is disabled$")
	public void assert_that_the_element_is_disabled(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1];
		Assert.assertTrue("The element is enabled", !driver.findElement(By.name(name)).isEnabled());
		System.out.println("Assert that the "+arg1+" is disable");
	}

	@Then("^assert that the \"([^\"]*)\" element is present$")
	public void assert_that_the_element_is_present(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1]+"="+parts[2];
		Assert.assertTrue("The element is not prensent", driver.findElement(By.xpath(name)).isDisplayed());
		System.out.println("Assert that the "+arg1+" is present");
	}

	@Then("^assert that the \"([^\"]*)\" element is absent$")
	public void assert_that_the_element_is_absent(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1]+"="+parts[2];
		try {
			Assert.assertTrue("The element is present", !driver.findElement(By.xpath(name)).isDisplayed());
        }
        catch (NoSuchElementException exception) {
    		System.out.println("Assert that the "+arg1+" is absent");

        }
		System.out.println("Assert that the "+arg1+" is absent");
	}

	@When("^the page following \"([^\"]*)\" is visited$")
	public void the_page_following_is_visited(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver.get(arg1);
		 System.out.println("Go to page "+arg1);
	}

	@When("^that go inside the \"([^\"]*)\" frame$")
	public void that_go_inside_the_frame(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1];
		
		By by = By.id(name);
		WebElement iFrame = findElement(driver, by, 60)  ;
		driver.switchTo().frame(iFrame);
		System.out.println("Go inside the frame "+arg1);

	}

	@Then("^we assert that the \"([^\"]*)\" attribute of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void we_assert_that_the_attribute_of_is(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg2.split("=");
		String name=parts[1];
		String attributeText = driver.findElement(By.name(name)).getAttribute(arg1);
	    Assert.assertEquals(attributeText, arg3);
	    System.out.println("Assert attribute text "+attributeText +" is "+ arg3);
	}

	@Then("^assert that the \"([^\"]*)\" element is hidden$")
	public void assert_that_the_element_is_hidden(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String name=parts[1];
		
		Assert.assertTrue("The element "+arg1+"is displayed",!driver.findElement(By.name(name)).isDisplayed());
		System.out.println("Assert the element "+arg1+"is hidden");
		driver.close();
	}

	@When("^change \"([^\"]*)\" attribute of \"([^\"]*)\" into \"([^\"]*)\"$")
	public void change_attribute_of_into(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 String page = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_hidden";
         setUp(page);
         //List<WebElement> elements = new ArrayList<WebElement>();
        String name ="iframeResult";
         By by = By.id(name);
 		WebElement iFrame = findElement(driver, by, 60)  ;
 		driver.switchTo().frame(iFrame);
 		//System.out.println("Go inside the frame "+name);
 		String content = "<form action=\"demo_form.asp\">\r\n  First name: <input type=\"text\" name=\"fname\"><br>\r\n  <input type=\"display\" name=\"country\" value=\"Norway\">\r\n  <input type=\"submit\" value=\"Submit\">\r\n</form>\r\n\r\n<p>Notice that the hidden field above is not shown to a user.</p>\r\n\r\n</body>\r\n</html>\r\n";
 		driver.switchTo().defaultContent();
 		driver.findElement(By.xpath(".//*[@id='textareaCode']")).clear();
 		driver.findElement(By.xpath(".//*[@id='textareaCode']")).sendKeys(content);
 		driver.findElement(By.xpath("html/body/div[2]/ul/li[4]/button")).click();
 		
 		System.out.println("Change attribute into display");
  	}

	@Then("^assert that the \"([^\"]*)\" element is visible$")
	public void assert_that_the_element_is_visible(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
		String value=parts[1];
		String name ="iframeResult";
        By by = By.id(name);
		WebElement iFrame2 = findElement(driver, by, 60)  ;
 		driver.switchTo().frame(iFrame2);
 		boolean isVisible = driver.findElement(By.name(value)).isDisplayed();
        Assert.assertTrue("Element is not visible", isVisible);
		System.out.println("Assert that the "+arg1+" is visible");
	}

	@When("^we change \"([^\"]*)\" attribute of \"([^\"]*)\" into \"([^\"]*)\"$")
	public void we_change_attribute_of_into(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String content = "<!DOCTYPE html>\r\n<html>\r\n<body>\r\n\r\n<form action=\"demo_form.asp\">\r\n  First name: <input type=\"text\" name=\"fname\"><br>\r\n  <input type=\"display\" name=\"country\" value="+arg3+">\r\n  <input type=\"submit\" value=\"Submit\">\r\n</form>\r\n\r\n<p>Notice that the hidden field above is not shown to a user.</p>\r\n\r\n</body>\r\n</html>";
  		driver.switchTo().defaultContent();
  		driver.findElement(By.xpath(".//*[@id='textareaCode']")).clear();
  		driver.findElement(By.xpath(".//*[@id='textareaCode']")).sendKeys(content);
  		driver.findElement(By.xpath("html/body/div[2]/ul/li[4]/button")).click();
	    System.out.println("Change value attribute into : "+arg3);
	}

	@Then("^assert that this \"([^\"]*)\" attribute of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void assert_that_this_attribute_of_is(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String name ="iframeResult";
        String[] parts = arg2.split("=");
        String value = parts[1];
		By by = By.id(name);
		WebElement iFrame = findElement(driver, by, 60)  ;
 		driver.switchTo().frame(iFrame);
 		String actual = driver.findElement(By.name(value)).getAttribute(arg1);
 		Assert.assertEquals(arg3, actual);
 		System.out.println("Assert "+arg3+" is "+actual);
	}

	@When("^highlight \"([^\"]*)\" element$")
	public void highlight_element(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
        String value = parts[1];
        WebElement element = driver.findElement(By.name(value));
        fnHighlightMe(driver,element);
        System.out.println("Highlight the "+arg1+" element");
        
	}

	@When("^set bound for \"([^\"]*)\" element$")
	public void set_bound_for_element(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
        String value = parts[1];
        WebElement element = driver.findElement(By.name(value));
        drawBorder(driver,element);
        System.out.println("draw border for the "+arg1+" element");
	}

	@When("^capture image of \"([^\"]*)\" element and save as \"([^\"]*)\"$")
	public void capture_image_of_element_and_save_as(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] parts = arg1.split("=");
        String value = parts[1];
        WebElement element = driver.findElement(By.name(value));
		takeScreenshotElement(element);
		System.out.println("capture image of "+arg1+" element and save as "+arg2);
	}
}
