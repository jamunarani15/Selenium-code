package automation.selenium.testScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.selenium.baseTests.baseTest;
public class testScript extends baseTest {

	
	@Test
	public void serch() {
		  WebElement srchBox = driver.findElement(By.name("q")); 
		  srchBox.clear();
		  srchBox.sendKeys("hello");
		 
	}
	
	

	 
}
