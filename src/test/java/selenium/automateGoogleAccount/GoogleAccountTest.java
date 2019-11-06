package selenium.automateGoogleAccount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAccountTest {

	private WebDriver webDriver;
	private WebDriverWait wait;
	public static final Integer TIMEOUT_IN_SECONDS = 60;

	@Before
	public void setUp() {
		webDriver = DriverInitializer.getDriver("chrome");
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		wait = DriverInitializer.getDriverWait(webDriver, TIMEOUT_IN_SECONDS);
	}

	@Test
	public void googleAccountShouldBeCreated() {
		webDriver.get(DriverInitializer.getProperty("google.url"));

		WebElement webElement = webDriver.findElement(By.id("gb_70"));
		webElement.click();

		// webElement = webDriver.findElement((By.cssSelector("#ow251 > span > span")));
		webElement = webDriver.findElement(By.xpath(
				"  /html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/div/span/span"));
		/// html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/div/span/span
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();

		webElement = webDriver
				.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div/span[1]/div[2]/div"));
		wait.until(ExpectedConditions.visibilityOf(webElement));

		System.out.println(webElement.isDisplayed());
		// webElement =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#initialView
		// > div.xkfVF.nnGvjf > div.JPdR6b.ILYVD.qjTEB > div > div >
		// span:nth-child(1)")));
		webElement.click();

		// #firstName
		// wait = DriverInitializer.getDriverWait(webDriver, 100);
		// /html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/input
		// webElement =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/input")));
		// Thread.sleep(10000);
		// #firstName
		// *[@id="firstName"]
		// *[@id="firstName"]
		// webElement =
		// webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/input"));
		webElement = webDriver.findElement(By.id("firstName"));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		webElement.sendKeys(DriverInitializer.getProperty("firstName"));

		webElement = webDriver.findElement(By.id("lastName"));
		webElement.sendKeys(DriverInitializer.getProperty("lastName"));

		webElement = webDriver.findElement(By.id("username"));
		webElement.sendKeys(DriverInitializer.getProperty("Username"));

		webElement = webDriver.findElement(By.name("Passwd"));
		webElement.sendKeys(DriverInitializer.getProperty("Passwd"));

		webElement = webDriver.findElement(By.name("ConfirmPasswd"));
		webElement.sendKeys(DriverInitializer.getProperty("ConfirmPasswd"));

		// firstName,lastName,Username,Passwd,ConfirmPasswd,

		webElement = webDriver.findElement(By.cssSelector("#accountDetailsNext > span > span"));
		webElement.click();

		// #accountDetailsNext > span > span

	}
	
	/*@After
	public void finish() {
		webDriver.quit();
	}*/

}
