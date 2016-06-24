package testserenitybdd.anhbt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	private WebDriver driver;
	public void setUp(String page) throws Exception {

	System.setProperty("webdriver.chrome.driver", "C://Users/voyeu/Documents/new/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(page);
    
}
}
