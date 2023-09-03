package MyTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import MyUtilities.ReadConfig;

// common to all the pageObjects
public class BaseClass {
	
	ReadConfig rcf = new ReadConfig();
	
	//For the logger to properties
	//public String baseURL="https://demo.guru99.com/v4/index.php";
	//public String username="mngr495504";
	//public String password="rArupEt";
	
	//For my utilities
    public String baseURL= rcf.getApplicationURL();
	public String username= rcf.getUsername();
	public String password= rcf.getPassword();
	public String firstname = rcf.getFname();
	public String lastname = rcf.getLname();
	public String postalcode = rcf.getPostalCode();
	//public String mobileno= rcf.getMobile();
	
	public static WebDriver driver;

	@BeforeClass // means As soon as the test case is started Execute this
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\KunalProject123\\Drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	//@AfterClass // Means Execute this after completion of my test case
	//public void tearDown() {
	//	driver.quit();
	//}


}