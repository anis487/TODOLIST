package Com.MdwebProject.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	public static WebDriver driver = new ChromeDriver();
	static SoftAssert sa = new SoftAssert();

	@Given("^the website Todo List is opened$")
	public void the_website_Todo_List_is_opened() throws Throwable {

		Thread.sleep(20000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(" KO !!! the page of Todo List is not opened ", driver.getTitle().contains("Todo List"));

	}

	@When("^All fields are not filled$")
	public void all_fields_are_not_filled() throws Throwable {
		WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
		WebElement PassWord = driver.findElement(By.xpath("//input[@type='password']"));
		Thread.sleep(4000);

		Email.clear();
		PassWord.clear();

	}

	@Then("^The submit button  is disabled$")
	public void the_submit_button_is_disabled() throws Throwable {
		WebElement ButtonSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		Thread.sleep(4000);

		Assert.assertTrue("KO !!! the ", !ButtonSubmit.isEnabled());

	}

	@Then("^The Tasks and Logout links are not displayed$")
	public void the_Tasks_and_Logout_links_are_not_displayed() throws Throwable {
		WebElement LogoutLink = driver.findElement(By.xpath("//a[@href='/' and text()='Déconnexion']"));
		WebElement TaskLink = driver.findElement(By.xpath("//a[@href='/tasks' and text()='Tâches']"));
		Thread.sleep(4000);

		sa.assertTrue(!TaskLink.isDisplayed(), "KO!!! the Asks Link is  displayed");
		sa.assertTrue(!LogoutLink.isDisplayed(), "KO!!! the Logout Link is displayed");
		sa.assertAll();
	}

	@When("^I enter the incorrect mail$")
	public void i_enter_the_incorrect_mail() throws Throwable {
		WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
		Thread.sleep(4000);
		Email.sendKeys("mail@pass.com");

	}

	@When("^I enter incorrect the password$")
	public void i_enter_incorrect_the_password() throws Throwable {
		WebElement PassWord = driver.findElement(By.xpath("//input[@type='password']"));
		PassWord.sendKeys("password");

	}

	@When("^I click Connexion button$")
	public void i_click_Connexion_button() throws Throwable {

		WebElement ButtonSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		Thread.sleep(4000);
		ButtonSubmit.click();
	}

	@Then("^The message Alerte is displayed$")
	public void the_message_Alerte_is_displayed() throws Throwable {

		WebElement Message = driver.findElement(By.xpath("//div[text()='Désolé, les identifiants sont incorrects.']"));
		Thread.sleep(4000);
		Assert.assertTrue("!!!KO, ALerte message is not displayed",
				Message.getText().contains("Désolé, les identifiants sont incorrects"));

	}

	@When("^I enter the correct mail$")
	public void i_enter_the_correct_mail() throws Throwable {

		WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
		Thread.sleep(4000);
		Email.clear();
		Email.sendKeys("test@test.com");

	}

	@When("^I enter correct the password$")
	public void i_enter_correct_the_password() throws Throwable {

		WebElement PassWord = driver.findElement(By.xpath("//input[@type='password']"));
		Thread.sleep(4000);
		PassWord.clear();
		PassWord.sendKeys("test");
	}

	@Then("^The page of Tasks is opened$")
	public void the_page_of_Tasks_is_opened() throws Throwable {

		Thread.sleep(4000);
		Assert.assertTrue("!!! KO ,The page of Tasks is not opened",
				driver.getCurrentUrl().contains("http://localhost:3000/tasks"));

	}

	@Then("^The Tasks and Logout links are displayed$")
	public void the_Tasks_and_Logout_links_are_displayed() throws Throwable {

		WebElement LogoutLink = driver.findElement(By.xpath("//a[@href='/' and text()='Déconnexion']"));
		WebElement TaskLink = driver.findElement(By.xpath("//a[@href='/tasks' and text()='Tâches']"));
		Thread.sleep(4000);
		Assert.assertTrue("KO!!! the Asks Link is not displayed", TaskLink.isDisplayed());
		Assert.assertTrue("KO!!! the Logout Link is not displayed", LogoutLink.isDisplayed());

	}

	@When("^All fields of Task page are not filled$")
	public void all_fields_of_Task_page_are_not_filled() throws Throwable {

		WebElement DecrTache = driver
				.findElement(By.xpath("//label[text()='Description de la tâche en une ligne']/following::input[1]"));
		WebElement NomTache = driver.findElement(By.xpath("//label[text()='Nom de la tâche']/following::input[1]"));

		Thread.sleep(4000);
		NomTache.clear();
		DecrTache.clear();
		WebElement BuutonAddTask = driver.findElement(By.xpath("//button[text()='Ajouter la tâche']"));
		Thread.sleep(4000);
		BuutonAddTask.click();

	}

	@Then("^The task button  is disabled$")
	public void the_task_button_is_disabled() throws Throwable {

		WebElement BuutonAddTask = driver.findElement(By.xpath("//button[text()='Ajouter la tâche']"));
		Thread.sleep(4000);
		Assert.assertTrue("KO !!! the ", !BuutonAddTask.isEnabled());

	}

	@When("^I enter the task name$")
	public void i_enter_the_task_name() throws Throwable {

		WebElement NomTache = driver.findElement(By.xpath("//label[text()='Nom de la tâche']/following::input[1]"));
		Thread.sleep(4000);
		NomTache.sendKeys("developement");

	}

	@When("^I enter the task description$")
	public void i_enter_the_task_description() throws Throwable {

		WebElement DecrTache = driver
				.findElement(By.xpath("//label[text()='Description de la tâche en une ligne']/following::input[1]"));

		Thread.sleep(4000);
		DecrTache.sendKeys("JAVASCRIPT");

	}

	@When("^I click add task button \"(.*?)\"$")
	public void i_click_add_task_button(String arg1) throws Throwable {

		WebElement BuutonAddTask = driver.findElement(By.xpath("//button[text()='Ajouter la tâche']"));
		Thread.sleep(4000);
		BuutonAddTask.click();

	}

	@Then("^The task is created in list$")
	public void the_task_is_created_in_list() throws Throwable {

		WebElement ListNomTache = driver.findElement(By.xpath("//h2[text()='Liste des tâches']//following::b[1]"));
		WebElement ListDescrTache = driver.findElement(By.xpath("//h2[text()='Liste des tâches']//following::span"));
		Thread.sleep(4000);

		Assert.assertTrue("!!!KO, Task name is not created", ListNomTache.getText().contains("developement"));
		Assert.assertTrue("!!!KO, Task decription is not created",
				ListDescrTache.getText().contains("JAVASCRIPT"));

	}

	@Then("^Data is saved in StorageLocal$")
	public void data_is_saved_in_StorageLocal() throws Throwable {

	  
	   String Item=getItemFromLocalStorage("tasks");
	   Assert.assertTrue("!!!KO, Task name is not saved in storageLocal", Item.contains("developement"));
	   Assert.assertTrue("!!!KO, Task name is not saved in storageLocal", Item.contains("JAVASCRIPT"));
	   Assert.assertTrue("!!!KO, Task name is not saved in storageLocal", Item.contains("false"));
	}

	 public static String getItemFromLocalStorage(String key) {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", key));
	 }
	 
	 @When("^I edit the task statut to completed$")
	 public void i_edit_the_task_statut_to_completed() throws Throwable {
		 
		 WebElement Statut = driver.findElement(By.xpath("//h2[text()='Liste des tâches']//following::span[2]"));
		Statut.click();
	     
	 }

	 @Then("^The statut completed is displayed$")
	 public void the_statut_completed_is_displayed() throws Throwable {
	     
		 WebElement Statut = driver.findElement(By.xpath("//h2[text()='Liste des tâches']//following::span[2]"));

			Assert.assertTrue("!!!KO, The statut completed is not displayed", Statut.getText().contains("Complétée"));
	     
	     	 
	 }

	 @Then("^The statut is modified in StorageLocal$")
	 public void the_statut_is_modified_in_StorageLocal() throws Throwable {
	     
		  String Item=getItemFromLocalStorage("tasks");
		   Assert.assertTrue("!!!KO, The statut is not modified in StorageLoca", !Item.contains("false"));

	     
	 }

	 @When("^I delete the task$")
	 public void i_delete_the_task() throws Throwable {
		 
		 WebElement BtnSupp = driver.findElement(By.xpath("//a[text()='Supprimer']"));
		 BtnSupp.click();
	     
	     
	 }

	 @Then("^The task is deleted in list$")
	 public void the_task_is_deleted_in_list() throws Throwable {
		
		
			WebElement AuTache = driver.findElement(By.xpath("//h2[text()='Liste des tâches']//following::div[1]"));
			Thread.sleep(4000);

			Assert.assertTrue("!!!KO, Task is not teleted", AuTache.getText().contains("Aucune tâche n'a encore été créée"));

		
	     
	     
	 }

	 @Then("^The task is deleted in StorageLocal$")
	 public void the_task_is_deleted_in_StorageLocal() throws Throwable {
		 
		  String Item=getItemFromLocalStorage("tasks");
		   Assert.assertTrue("!!!KO, Task name is not deleted in storageLocal", !Item.contains("developement"));
		   Assert.assertTrue("!!!KO, Task name is not deleted in storageLocal", !Item.contains("JAVASCRIPT"));
		   

		 
	     
	     
	 }
	 
	 

}
