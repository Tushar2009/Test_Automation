package MyPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
//		this next line is used to initialize all the dependencies
		PageFactory.initElements(rdriver,this);
	}
	//@FindBy(name="uid")
	@FindBy(name="user-name")
	WebElement txtUserName;

	//@FindBy(name="password")
	@FindBy(name="password")
	WebElement txtPassword;

	//@FindBy(name="btnLogin")
	@FindBy(name="login-button")
	WebElement btnlogin;
	
	@FindBy(name="add-to-cart-sauce-labs-backpack")
	WebElement addtocart;
	
	@FindBy(xpath="/html/body/div/div/div/div[1]/div[1]/div[3]/a")
	WebElement shoppingbtn;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement continue1;
	
	@FindBy(name="finish")
	WebElement finish;

	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	//public void clickSubmit()
	public void clickSubmit()
	{
		btnlogin.click();
		//btnlogin.sendKeys(btn);
	}
	
	public void AddtocartSubmit()
	{
		addtocart.click();
		//btnlogin.sendKeys(btn);
	}
	
	public void ShoppingSubmit()
	{
		shoppingbtn.click();
		//btnlogin.sendKeys(btn);
	}
	
	public void CheckoutSubmit()
	{
		checkout.click();
		//btnlogin.sendKeys(btn);
	}
	
	public void setFirstName(String fname)
	{
		firstname.sendKeys(fname);
		//btnlogin.sendKeys(btn);
	}
	
	public void setLastName(String lname)
	{
		lastname.sendKeys(lname);
		//btnlogin.sendKeys(btn);
	}
	
	public void setPostalCode(String pcode)
	{
		postalcode.sendKeys(pcode);
		//btnlogin.sendKeys(btn);
	}
	
	public void ContinueSubmit()
	{
		continue1.click();
		//btnlogin.sendKeys(btn);
	}
	
	public void FinishSubmit()
	{
		finish.click();
		//btnlogin.sendKeys(btn);
	}


}
//summary

// for all the different pages of the web application i.e login page,add to cart page etc.
// so there will be different files for that pages in the myPageobjects package
