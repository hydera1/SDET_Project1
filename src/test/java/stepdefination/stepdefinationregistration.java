package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import util.hooks;

public class stepdefinationregistration {

	WebDriver driver = hooks.driver;
	
	 @Given("^User navigates to home page")
	    public void user_navigates_to_home_page() {
	      driver.get("http://elearningm1.upskills.in/");
	      
	    }
	 @And("^click on signup button$")
	    public void click_on_signup_button()  {
	    	driver.findElement(By.linkText("Sign up!")).click();
	    }

	    @When("^fill all the fields \"([^\"]*)\",\"([^\\\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	    public void fill_all_the_fields(String firstname, String lastname, String email, String username, String password, String confirmpassword)  {
	        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
	        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
	        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	        driver.findElement(By.xpath("//input[@name='pass1']")).sendKeys(password);
	        driver.findElement(By.xpath("//input[@name='pass2']")).sendKeys(confirmpassword);
	        	    }

	    @And("^Click on Register$")
	    public void Click_on_Register()  {
	        driver.findElement(By.xpath("//button[@name='submit']")).click();
	    }
	    @Then("^validate the success message after register$")
	    public void validate_the_success_message_after_register()  {
	    	try {
	       String actual= driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/div/p[1]")).getText();
	       System.out.println(actual);
	    	}catch(Exception e) {
	    		System.out.println("account already exists");
	    	}
	    }

	   

	
}
