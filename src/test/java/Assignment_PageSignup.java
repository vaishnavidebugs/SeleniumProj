import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment_PageSignup {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Page title is : " + title);
        Thread.sleep(2000);

        //userdata
        String userName = "Vaishnavi";
        String email ="Random76@gmail.com";
        String password = "Test@123";
        String firstName = "Vaishnavi";
        String lastName = "Tester";
        String company = "Test@co";
        String address1 = "Thousand lights";
        String address2 = "Anna Salai";
        String state = "Tamilnadu";
        String city = "Chennai";
        String zipcode = "600001";
        String mobileNumber = "9876543210";


        //To click the signup link
        WebElement signUpLink = driver.findElement(By.xpath("//i[contains(@class,'lock')]//parent::a"));
        signUpLink.click();
        Thread.sleep(2000);

        //Verify the login/signup page is displayed
        WebElement titleDisplay = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        String loginTitle = titleDisplay.getText();
        WebElement signUpTitleDisplay = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        String signUpTitle = signUpTitleDisplay.getText();
        if (loginTitle.contains("Login to your account") || signUpTitle.contains("New User Signup!")) {
            System.out.println("Please login or sign up!");
        } else {
            System.out.println("Please reload the page again!");
        }

        //To Signup
        WebElement userNameWebElement = driver.findElement(By.xpath("//input[@name =\"name\"]"));
        userNameWebElement.sendKeys(userName);
        WebElement emailWebElement = driver.findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']"));
        emailWebElement.sendKeys(email);
        WebElement signupButton = driver.findElement(By.xpath("//button[text()='Signup']"));
        signupButton.click();

        //Verify the signup page title
        WebElement accDetailsTitle = driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]"));
        String signupTitle = accDetailsTitle.getText();
        if (signupTitle.contains("Enter Account Information")) {
            System.out.println("You are on the right page! Please fill in the required information!");
        } else {
            System.out.println("Please reload the page");
        }

        //To fill the information
        WebElement salutation = driver.findElement(By.xpath("//input[@id='id_gender2']"));
        salutation.click();
        WebElement reqName = driver.findElement(By.xpath("//input[@id ='name']"));
        String nameValue = reqName.getAttribute("value");
        if (userName.equals(nameValue)) {
            System.out.println("Name value matches the expected!");
        } else {
            System.out.println("Name value doesn't match!");
        }
        WebElement reqEmail = driver.findElement(By.xpath("//input[@id ='email']"));
        String emailvalue = reqEmail.getAttribute("value");
        if (email.equals(emailvalue)) {
            System.out.println("Email value matches the expected!");
        } else {
            System.out.println("Email value doesn't match!");
        }
        //Entering password
        WebElement passwordWebElement = driver.findElement(By.id("password"));
        passwordWebElement.sendKeys(password);

        //Entering DOB
        WebElement dateWebElement = driver.findElement(By.xpath("//select[@id='days']"));
        WebElement monthWebElement = driver.findElement(By.xpath("//select[@id='months']"));
        WebElement yearWebElement = driver.findElement(By.xpath("//select[@id='years']"));
        Select date = new Select(dateWebElement);
        Select month = new Select(monthWebElement);
        Select year = new Select(yearWebElement);
        date.selectByValue("1");
        month.selectByVisibleText("November");
        year.selectByIndex(21);
        System.out.println("Selected Date of Birth");

        //select checkboxes
        WebElement newsLetterCheckBox = driver.findElement(By.id("newsletter"));
        newsLetterCheckBox.click();
        WebElement splOffersCheckBox = driver.findElement((By.id("optin")));
        splOffersCheckBox.click();
        System.out.println("Selected both the newsletter and special offers checkboxes!");

        //Verify the Address information section
        WebElement addressInfoSectionWebElement = driver.findElement(By.xpath("//b[contains(text(),'Address Information')]"));
        String addressTitle = addressInfoSectionWebElement.getText();
        if (addressTitle.contains("Address Information")) {
            System.out.println("Address section is displayed! Please fill in the required Address information!");
        } else {
            System.out.println("Please reload the page");
        }

        //Entering address details
        WebElement firstNameWebElement = driver.findElement(By.id("first_name"));
        firstNameWebElement.sendKeys(firstName);
        WebElement lastNameWebElement = driver.findElement(By.id("last_name"));
        lastNameWebElement.sendKeys(lastName);
        WebElement companyWebElement = driver.findElement(By.id("company"));
        companyWebElement.sendKeys(company);
        WebElement address1WebElement = driver.findElement(By.id("address1"));
        address1WebElement.sendKeys(address1);
        WebElement address2WebElement = driver.findElement(By.id("address2"));
        address2WebElement.sendKeys(address2);
        WebElement stateWebElement = driver.findElement(By.id("state"));
        stateWebElement.sendKeys(state);
        WebElement cityWebElement = driver.findElement(By.id("city"));
        cityWebElement.sendKeys(city);
        WebElement zipWebElement = driver.findElement(By.id("zipcode"));
        zipWebElement.sendKeys(zipcode);
        WebElement phoneWebElement = driver.findElement(By.id("mobile_number"));
        phoneWebElement.sendKeys(mobileNumber);

        //click Create account
        WebElement createAccountBtn = driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
        createAccountBtn.click();
        System.out.println("Successfully created the user account!");
        Thread.sleep(2000);

        //verify the message
        WebElement successMsg1 = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]"));
        String successMsg1Txt = successMsg1.getText();
        WebElement successMsg2 = driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]"));
        String successMsg2Txt = successMsg2.getText();
        WebElement successMsg3 = driver.findElement(By.xpath("//p[contains(text(),'You can now take advantage of member privileges to enhance your online shopping experience with us.')]"));
        String successMsg3Txt = successMsg3.getText();
        System.out.println(successMsg1Txt);
        System.out.println(successMsg2Txt);
        System.out.println(successMsg3Txt);
        WebElement continueBtn = driver.findElement(By.xpath("//a[text()='Continue']"));
        continueBtn.click();
        Thread.sleep(3000);

        //verify username
        WebElement userNameVerification = driver.findElement(By.xpath("//i[@class='fa fa-user']//following-sibling::b"));
        String user= userNameVerification.getText();
        if(userName.contains(user)){
            System.out.println("User name appears in the dashboard!");
        }
        else{
            System.out.println("User name doesn't appear correctly!");
        }
        driver.quit();
    }




    }
