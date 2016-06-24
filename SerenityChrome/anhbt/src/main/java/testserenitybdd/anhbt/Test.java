package testserenitybdd.anhbt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class Test {
	private static WebDriver driver;
	public void setUp(String page) throws Exception {

	System.setProperty("webdriver.chrome.driver", "C://Users/voyeu/Documents/new/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          Test test = new Test();
          String page = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_hidden";
          test.setUp(page);
          //List<WebElement> elements = new ArrayList<WebElement>();
         String name ="iframeResult";
          By by = By.id(name);
  		WebElement iFrame = test.findElement(driver, by, 60)  ;
  		driver.switchTo().frame(iFrame);
  		System.out.println("Go inside the frame "+name);
  		String content = "<!DOCTYPE html>\r\n<html>\r\n<body>\r\n\r\n<form action=\"demo_form.asp\">\r\n  First name: <input type=\"text\" name=\"fname\"><br>\r\n  <input type=\"hidden\" name=\"country\" value=\"VIETNAM\">\r\n  <input type=\"submit\" value=\"Submit\">\r\n</form>\r\n\r\n<p>Notice that the hidden field above is not shown to a user.</p>\r\n\r\n</body>\r\n</html>";
  		driver.switchTo().defaultContent();
  		driver.findElement(By.xpath(".//*[@id='textareaCode']")).clear();
  		driver.findElement(By.xpath(".//*[@id='textareaCode']")).sendKeys(content);
  		driver.findElement(By.xpath("html/body/div[2]/ul/li[4]/button")).click();
  		WebElement iFrame2 = test.findElement(driver, by, 60)  ;
  		driver.switchTo().frame(iFrame2);
  		boolean isVisible = driver.findElement(By.name("country")).isDisplayed();
        if(isVisible){
        	System.out.println("Visible");
        }else {
        	System.out.println("Invisible");
        }
        }

}
