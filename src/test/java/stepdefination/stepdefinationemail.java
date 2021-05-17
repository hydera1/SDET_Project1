package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.hooks;

public class stepdefinationemail {
	
	WebDriver driver = hooks.driver;

	 @Given("^Go to upskill url$")
	    public void Go_to_upskill_url() {
	        driver.get("http://elearningm1.upskills.in/");
	    }

	    @When("^enter \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void enter_something_and_something(String username, String password){
	        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(username);
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	    }

	    @Then("^click on send message$")
	    public void click_on_send_message() {
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	    }

	    @And("^click on login$")
	    public void click_on_login()  {
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       		
	    }

	    @And("^click on compose link and type email$")
	    public void click_on_compose_link_and_type_email() throws InterruptedException {

	       driver.findElement(By.linkText("Compose")).click();
	     driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Hyd");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id='select2-compose_message_users-results']/li[1]")).click();
	     driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Subject");
	     Thread.sleep(5000);
	   //  driver.findElement(By.xpath("//div[@id='cke_1_contents']//iframe"));

	     WebElement iframe = driver.findElement(By.cssSelector(".cke_wysiwyg_frame"));;
	        driver.switchTo().frame(iframe);

	        Thread.sleep(3000);
			 
			driver.findElement(By.xpath("/html/body")).sendKeys("Message");
			driver.switchTo().defaultContent();
	      }

	    @And("^validate successful message$")
	    public void validate_successful_message() throws InterruptedException {
	    	Thread.sleep(3000);
	    	String msg = driver.findElement(By.className("alert-success")).getText();
	        System.out.println(msg);
	    }
}
