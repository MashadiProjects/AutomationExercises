package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationExercise {

    WebDriver driver;

    @Test
    public void registerUser() {
        this.driver = new ChromeDriver();

        // Use driver instance to open web browser,maximize the window and navigate to the specified home page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        /* Now verify that the user is on the Home page by assigning the text
        of the element to a variable and verifying it The variable is being
        assigned to everything that follows the = sign. We are saying go to
        the element and get the text of the element(Home) and save it in the variable homePageTitle */

        //String homePageTitle = driver.findElement(By.xpath("//a[normalize-space()='Home']")).getText();

        /* Now do the assertion/validation to verify that the text of the element is indeed "Home" by
        comparing the text in the stored variable homePageTitle to the expected text which is "Home" */
        /* During execution, the real text from the website will be stored in the variable
        homePageText,so if in the code it was misspelt, the test will fail*/
        // Assert.assertEquals(homePageTitle,"Home");

        //the line below does the same as the 2 above
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).isDisplayed();


    }


    @Test
    public void signup() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the login link to be clickable and then click it
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/login']")));
        loginLink.click();

        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();


        // Populate the signup form
        driver.findElement(By.name("name")).sendKeys("Marang");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("rangki@work.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        driver.findElement(By.id("id_gender1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Test1*");


      /* Dropdown selections
       Use selectByVisibleText() if you know the label the user sees.
       Use selectByValue() if you're working with backend values.
       Use selectByIndex() when order matters.*/

        WebElement dayDropdownElement = driver.findElement(By.id("days"));
        Select dropdown = new Select(dayDropdownElement);
        dropdown.selectByValue("4");

        WebElement monthDropdownElement = driver.findElement(By.id("months"));
        Select dropdown2 = new Select(monthDropdownElement);
        dropdown2.selectByVisibleText("December");

        WebElement yearDropdownElement = driver.findElement(By.id("years"));
        Select dropdown3 = new Select(yearDropdownElement);
        dropdown3.selectByIndex(41);


        // Locate the 1st checkbox
        WebElement checkbox = driver.findElement(By.id("newsletter")); // Use your actual ID
        // Check if it's already selected
        if (!checkbox.isSelected()) {
            checkbox.click(); // Select the checkbox
        }
        // Locate the 1st checkbox
        WebElement checkbox2 = driver.findElement(By.id("optin"));
        // Check if it's already selected
        if (!checkbox2.isSelected()) {
            checkbox2.click(); // Select the checkbox

        }


        // Fill in the address form
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Marang");
        driver.findElement(By.id("last_name")).sendKeys("Molefe");
        driver.findElement(By.id("company")).sendKeys("Kgosi Holdings");
        driver.findElement(By.id("address1")).sendKeys("85 Inner Way");
        driver.findElement(By.id("address2")).sendKeys("Suite 456");

        // Correct way to handle a dropdown
        WebElement countryDropdownElement = driver.findElement(By.id("country"));
        Select dropdown4 = new Select(countryDropdownElement);
        dropdown4.selectByVisibleText("Singapore");

        driver.findElement(By.id("state")).sendKeys("Gauteng");
        driver.findElement(By.id("city")).sendKeys("Pretoria");
        driver.findElement(By.id("zipcode")).sendKeys("2000");
        driver.findElement(By.id("mobile_number")).sendKeys("0834567890");

        // Click the Create Account button
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        // Wait for the account creation to complete
        Thread.sleep(2000);
    }
}


//    @AfterTest
//    public void closeBrowser(){
//        driver.quit();
//    }




