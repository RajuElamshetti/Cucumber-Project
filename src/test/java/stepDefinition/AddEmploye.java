package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmploye {
	WebDriver driver;
	String Expected = "";
	String Actual = "";
	
	@Given("^user navigate url \"([^\"]*)\" with browser$")
	public void user_navigate_url_with_browser(String Url) throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(Url);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enter_username_as_and_password_as(String username, String password) throws Throwable {
	   driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
	   driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	   
	}

	@When("^user click login button$")
	public void user_click_login_button() throws Throwable {
	    driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

	@When("^user click pim$")
	public void user_click_pim() throws Throwable {
	   driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	}

	@When("^user click add button$")
	public void user_click_add_button() throws Throwable {
	    driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
	}

	@When("^user enter fname as \"([^\"]*)\"$")
	public void user_enter_fname_as(String fname) throws Throwable {
	   driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname);
	}

	@When("^user enter mname as \"([^\"]*)\"$")
	public void user_enter_mname_as(String mname) throws Throwable {
	    driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(mname);
	}

	@When("^user enter lname as \"([^\"]*)\"$")
	public void user_enter_lname_as(String lname) throws Throwable {
	    driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
	}

	@When("^user capture employeeid before adding$")
	public void user_capture_employeeid_before_adding() throws Throwable {
	    Expected = driver.findElement(By.xpath("//input[@id='employeeId']")).getAttribute("value");
	}

	@When("^user click save button$")
	public void user_click_save_button() throws Throwable {
	   driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	}

	@When("^user capture employeeid after adding$")
	public void user_capture_employeeid_after_adding() throws Throwable {
	   Actual = driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']")).getAttribute("value");
	}

	@Then("^user validate employeeid$")
	public void user_validate_employeeid() throws Throwable {
		 if (Expected.equalsIgnoreCase(Actual))
		    {
		    	System.out.println("Add employee success::"+Expected);
		    }
		    else
		    {
		    	System.out.println("Add employee Fail::"+Expected);
		    }
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	   driver.close();
	}


}
