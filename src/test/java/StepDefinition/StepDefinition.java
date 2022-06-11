package StepDefinition;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition {
	WebDriver driver = new ChromeDriver();

@Given("User should launch the application by entering valid URL")
public void user_should_launch_the_application_by_entering_valid_URL() {
    // Write code here that turns the phrase above into concrete actions
//	System.setProperty("webdriver.chrome.driver","C:\\Users\\002OER744\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	driver.get("http://retailm1.upskills.in/");
	driver.manage().window().maximize();
}

@Given("Click on Account icon")
public void click_on_Account_icon() {
    // Write code here that turns the phrase above into concrete actions
	
	WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a"));
	Actions actions = new Actions(driver);
	actions.moveToElement(mainMenu);
	WebElement subMenu = driver.findElement(By.xpath("//ul[@class='dropdown-menu tb_list_1']/li/a"));
	actions.moveToElement(subMenu);
	actions.click().build().perform();
}

@Given("Click on Register button")
public void click_on_Register_button() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
}

@When("Fill registration form and Submit details")
public void fill_registration_form_and_Submit_details_and_verify(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
	
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(data.get(0).get("firstname"));
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data.get(0).get("lastName"));
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get(0).get("email"));
	driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(data.get(0).get("telephone"));
	driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys(data.get(0).get("address1"));
	driver.findElement(By.xpath("//input[@name='address_2']")).sendKeys(data.get(0).get("address2"));
	driver.findElement(By.xpath("//input[@name='city']")).sendKeys(data.get(0).get("City"));
	driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(data.get(0).get("postalcode"));
	driver.findElement(By.xpath("//select[@name='country_id']")).click();
	driver.findElement(By.xpath("//select[@name='country_id']/option[@value='99']")).click();
	
	//select[@name='zone_id']
	driver.findElement(By.xpath("//select[@name='zone_id']")).click();
	driver.findElement(By.xpath("//select[@name='zone_id']/option[@value='1489']")).click();
	
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(0).get("password"));
	driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(data.get(0).get("confirm password"));
	
}

@When("Click on No radio button in Subscribe")
public void click_on_No_radio_button_in_Subscribe() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='0']")).click();
}

@When("Click on I have read and agree to the Privacy Policy checkbox")
public void click_on_I_have_read_and_agree_to_the_Privacy_Policy_checkbox() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath("//label[@class='checkbox']/input[@name='agree']")).click();
}

@Then("Click on Continue button")
public void click_on_Continue_button() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath("//input[@type='submit']")).click();
}

@Then("Message should get displayed on next page with Continue button")
public void message_should_get_displayed_on_next_page_with_Continue_button() throws InterruptedException {
	
	String confMsg=driver.findElement(By.xpath("//div[@class='tb_text_wrap tb_sep']/p")).getText();
    Thread.sleep(2000);
    Assert.assertEquals("Congratulations! Your new account has been successfully created!", confMsg, "Congratulations! Your new account has been successfully created!");
    driver.findElement(By.xpath("//a[@class='btn btn-primary']")).isDisplayed();
    driver.close();
	
}



}