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

public class StepDefinition2 {
	WebDriver driver = new ChromeDriver();

@Given("User should launch the application by entering URL")
public void user_should_launch_the_application_by_entering_URL() {
    // Write code here that turns the phrase above into concrete actions
//	System.setProperty("webdriver.chrome.driver","C:\\Users\\002OER744\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	driver.get("http://retailm1.upskills.in/");
	driver.manage().window().maximize();
}

@Given("Click on Account")
public void click_on_Account_icon() {
    // Write code here that turns the phrase above into concrete actions
	
	WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a"));
	Actions actions = new Actions(driver);
	actions.moveToElement(mainMenu);
	WebElement subMenu = driver.findElement(By.xpath("//ul[@class='dropdown-menu tb_list_1']/li/a"));
	actions.moveToElement(subMenu);
	actions.click().build().perform();
}
@When("Enter valid Credentails in textboxes")
public void enter_valid_Credentails_in_textboxes(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
	List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get(0).get("Email"));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(0).get("Password"));

}

@When("Click on Login")
public void click_on_Login() {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.xpath("//input[@value='Login']")).click();
}

@Then("My Account Page is displayed.")
public void my_Account_Page_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath("//div[@id='System_nyHsmShk']//h2")).isDisplayed();
    driver.close();
}
}