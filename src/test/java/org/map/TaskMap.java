package org.map;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskMap {
	static WebDriver driver;

	@Given("User should launch the Browser")
	public void user_should_launch_the_Browser() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\GT Sanatorium\\Downloads\\eclipse-jee-oxygen-3a-win32-x86_64\\eclipse\\Lokesh\\CuCumberDay5\\Chrome\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.get("http://www.demo.guru99.com/telecom/");
	}

	@Given("User click the Add Tariff button")
	public void user_click_the_Add_Tariff_button() {
		   driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}

	@When("USer Should provide the Details")
	public void user_Should_provide_the_Details(io.cucumber.datatable.DataTable data) throws InterruptedException {
	  List<Map<String, String>> twodmap = data.asMaps(String.class,String.class);
	  System.out.println(twodmap);
	  driver.findElement(By.xpath("//input[@placeholder='Monthly Rental']")).sendKeys(twodmap.get(0).get("montrent"));
		driver.findElement(By.xpath("//input[@placeholder='Free Local Minutes']")).sendKeys(twodmap.get(1).get("localmint"));
		driver.findElement(By.xpath("//input[@placeholder='Free International Minutes']")).sendKeys(twodmap.get(2).get("intermint"));
		driver.findElement(By.xpath("//input[@placeholder='Free SMS Pack']")).sendKeys(twodmap.get(0).get("smspack"));
		driver.findElement(By.xpath("//input[@placeholder='Local Per Minutes Charges']")).sendKeys(twodmap.get(1).get("pmchrg"));
		driver.findElement(By.xpath("//input[@placeholder='Inter. Per Minutes Charges']")).sendKeys(twodmap.get(2).get("ipcharge"));
		driver.findElement(By.xpath("//input[@placeholder='SMS Per Charges']")).sendKeys(twodmap.get(0).get("smscharge"));
	 Thread.sleep(30000);
	}

	@Then("User Should click the Submit Button")
	public void user_Should_click_the_Submit_Button() {
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		String text =	driver.findElement(By.xpath("//h2[contains (text(), 'Congratulation ')]")).getText();
	 
	System.out.println(text);
	}



}
