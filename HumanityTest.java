import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HumanityTest {

    WebDriver driver;


   @BeforeSuite
   public void Setup(){
       System.setProperty("webdriver.chrome.driver","C:\\Users\\Korisnik\\Desktop\\Selenium\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("http://humanity.com");
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

   }

   @BeforeTest
   public void StartBrowser(){
       String title="Online Employee Scheduling Software - Humanity";
       String username="igor_z@live.com";
       String pw="Test123!";

       Assert.assertEquals(driver.getTitle().equals(title),true);

       driver.findElement(By.linkText("Log In")).click();
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pw);
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);


   }

   @BeforeMethod
   public void checkTitle(){
   }

    @Test
    public void addEmployeeNoEmail(){

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver,"Name","LastName","");

   }

    @Test
    public void addEmployeeNoData(){

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver,"","","");

    }

    @Test
    public void addEmployeeNoNameWithLastNameEmail(){

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver,"","NOOOOOO","NOOOOO");

    }

    @Test
    public void addEmployeeNoNameWithLastName(){

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver,"","NOOOOO","");

    }

    @Test
    public void addEmployeeNoNameWithEmail(){

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver,"","","NOOOOOOO");

    }

    @Test
    public void addEmployeeNoEmailNoLastName() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver, "Name", "", "");

    }

    @Test
    public void addEmployeeAllData() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver, "Name", "LastName", "email");

    }

    @Test
    public void addEmployeeAllDataValidEmail() {

        String email=Employee.randomEmail();

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver, "ValidEmail", "ValidEmail", email);

    }

    @Test
    public void addEmployeeNoLastName() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployee(driver, "Name", "", "email");

    }


    @Test
    public void clockInOut(){

        Clock.goToClock(driver);
        Clock.clickClockIN(driver);
        Clock.clickClockOUT(driver);

    }


    // LNO - Have Letters,Numbers and Other
    // N   - Have Only Numbers etc
    // LO  - Have Letters and Other etc.

    @Test
    public void addEmployeeNameOnlyLNO() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployeeOnlyName(driver,"dsgh123#$%");

    }

    @Test
    public void addEmployeeNameOnlyLN() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployeeOnlyName(driver,"dsgh123");

    }

    @Test
    public void addEmployeeNameOnlyLO() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployeeOnlyName(driver,"dsgh#$%");

    }

    @Test
    public void addEmployeeNameOnlyNO() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployeeOnlyName(driver,"123#$%");

    }

    @Test
    public void addEmployeeNameOnlyN() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployeeOnlyName(driver,"123@#$%^");

    }

    @Test
    public void addEmployeeNameOnlyO() {

        Employee.goToStaff(driver);
        Employee.goToAddEmployee(driver);
        Employee.addEmployeeOnlyName(driver,"*()@#$%^");

    }


    @AfterMethod
    public void goToDashboard(){
        driver.get("https://qatest2.humanity.com/app/dashboard/");
    }

    @AfterSuite
    public void end(){
       driver.quit();
    }




}
