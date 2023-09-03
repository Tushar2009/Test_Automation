package ExtentReportBasicDemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoExtentReport {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark= new ExtentSparkReporter("ExtentTest.html");
	WebDriver driver;
	
	@BeforeTest
	public void BrowserLaunch() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
		extent.attachReporter(spark);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\KunalProject123\\Drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
	}
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
	
	/*@Test
	public void TestCase_001() {
		ExtentTest test=extent.createTest("Verify the page title").assignAuthor("VA");
		test.info("I am verifying the page title ");
		String title = driver.getTitle().toString();
		test.info("Captured page title = "+title);
		if(title.equals("google")) {
			test.pass("Page title title is verified successfully");
		}
		else
		{
			test.fail("Page title Cannot be verified successfully");
		}
	}*/
	@Test
	public void TestCase_001() {
		ExtentTest test=extent.createTest("Verify the login details").assignAuthor("VA");
		test.info("I am verifying the login button");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		//test.info("Captured page title = "+title);
		test.info("Login details send");
		//By clickable = By.id("item_4_title_link");
		String actualUrl="https://www.saucedemo.com/inventory.html"; 
		String expectedUrl= driver.getCurrentUrl();
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
			test.pass("Login is successful");
		}
		else {
			test.fail("Login is not successful");
		}
		/*if(title.equals("google")) {
			test.pass("Page title title is verified successfully");
		}
		else
		{
			test.fail("Page title Cannot be verified successfully");
		}*/
	}
	@Test
	public void TestCase_002() {
		ExtentTest test=extent.createTest("Verify the cart updated").assignAuthor("VA");
		test.info("I am verifying the cart option");
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		test.info("Add to Cart is clicked");
		WebElement addtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		//WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
	    if(addtocart.isDisplayed()) {
	    	test.fail("Add to Cart is not successful");
		}
		else {
			test.pass("Add to cart is successful");
		}
		
	}
	@Test
	public void TestCase_003() {
		ExtentTest test=extent.createTest("Is Shopping ID is displayed").assignAuthor("VA");
		test.info("I am verifying shopping id");
		//driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Kunal");
		driver.findElement(By.id("last-name")).sendKeys("Dureja");
		driver.findElement(By.id("postal-code")).sendKeys("147001");
		driver.findElement(By.id("continue")).click();
		WebElement status = driver.findElement(By.className("summary_value_label"));
		
		if(status.isDisplayed()) {
	    	test.pass("Shopping Id is displayed successful: " + status.getAttribute("innerHTML"));
		}
		else {
			test.fail("Shopping Id is not displayed successful");
		}	
	}
	@Test
	public void TestCase_004() {
		ExtentTest test = extent.createTest ("Checking the FINISH command").assignAuthor ("VA");
		try {
		    driver.findElement(By.name("finish")).click();
		    test.pass("User is processed the order");
		    test.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		catch(Exception e) {
		    test.fail("User is not able to process the order" + e.getMessage());
		}
	}
	public static String capturescreenshot(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) ;
		File destinationFilePath = new File("src/../images/screenshot" + System.currentTimeMillis()+".png");
		String absolutePathlocation = destinationFilePath.getAbsolutePath();
		try{
		    FileUtils.copyFile(srcFile, destinationFilePath);
		}catch (IOException e){
		    // TODO Auto-generated catch block. 
		    e.printStackTrace();
		}
		return absolutePathlocation;
	}

}
