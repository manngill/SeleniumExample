import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputBoxTest2 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSingleInputField() throws InterruptedException  {
		// Setup Selenium + Chrome
		System.setProperty("webdriver.chrome.driver","/Users/macstudent/Desktop/chromedriver");
	 WebDrive driver = new ChromeDriver();
		
		// Tell Selenium what page to test
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		/*
		 * 1. FIND the textbox    (id = user-message)
		 * 2. Type "HELLO WORLD" into the textbox (.sendKeys("..."))
		 * 3. FIND the button  (cssSelectors = form#get-input button)
		 * 4. CLICK on the button (.click())
		 * 5. FIND the output message thing (id = display)
		 * 6. CHECK the output message  (expectedResult = "HELLO WORLD")  
		 * 			(.getText());
		 */
		
		WebElement textBox = driver.findElement(By.id("user-message"));
		textBox.sendKeys("HELLO WORLD!");
		
		WebElement button = driver.findElement(By.cssSelector("form#get-input button"));
		button.click();	
		
		WebElement outputSpan = driver.findElement(By.id("display"));
		String outputMessage = outputSpan.getText();		//actual output
		
		assertEquals("HELLO WORLD!", outputMessage);
		
		// At end of test case, wait for a few seconds, then close the browser
		Thread.sleep(1000);				// OPTION 1
		TimeUnit.SECONDS.sleep(1);		// OPTION 2
		driver.close();
	}
	
	@Test
	public void testTwoInputFields() throws InterruptedException {
		/*
		 * 1. FIND the textbox 1    (id = sum1)
		 * 2. Type "50" into the textbox (.sendKeys("..."))
		 * 3. FIND the textbox 2    (id = sum2)
		 * 2. Type "70" into the textbox (.sendKeys("..."))
		 * 3. FIND the button  (cssSelectors = form#gettotal button)
		 * 4. CLICK on the button (.click())
		 * 5. FIND the output message thing (id = displayvalue)
		 * 6. CHECK the output message  (expectedResult = "HELLO WORLD")  
		 * 			(.getText());
		 */
		
		// Setup selenium
		System.setProperty("webdriver.chrome.driver","/Users/macstudent/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		// tell seleinum which page you want to visit
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		// write your test case code
		// ---------------------------
		
		WebElement textBox1 = driver.findElement(By.id("sum1"));
		textBox1.sendKeys("50");

		WebElement textBox2 = driver.findElement(By.id("sum2"));
		textBox2.sendKeys("70");
		
		WebElement button = driver.findElement(By.cssSelector("form#gettotal button"));
		button.click();	
		
		WebElement outputSpan = driver.findElement(By.id("displayvalue"));
		String outputMessage = outputSpan.getText();		//actual output
		
		assertEquals("120", outputMessage);
		
		// ---------------------------
		// sleep + close the browser
		TimeUnit.SECONDS.sleep(2);		// OPTION 2
		driver.close();
		
	}

}
