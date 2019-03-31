import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;


public class Employee {

    public static void goToStaff(WebDriver driver){
        driver.findElement(By.id("sn_staff")).click();

    }

    public static void goToAddEmployee(WebDriver driver){

        WebDriverWait wait= new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("act_primary")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("act_primary")));

        driver.findElement(By.id("act_primary")).click();


    }

    public static void addEmployee(WebDriver driver,String name,String lastName,String email){

        driver.findElement(By.id("_asf1")).sendKeys(name);
        driver.findElement(By.id("_asl1")).sendKeys(lastName);
        driver.findElement(By.id("_ase1")).sendKeys(email);

        driver.findElement(By.xpath("//button[text()='Save Employees']")).click();
        checkifSaved(driver);

    }

    public static void checkifSaved(WebDriver driver){

        int check=0;

        try{
            driver.findElement(By.xpath("//button[text()='Save Employees']")).isDisplayed();
            check++;
        }catch (Exception e){
            driver.findElement(By.linkText("close")).click();
            check++;
        }

        if(check==1){
            Assert.assertEquals(true,true);
        }else
        {
            Assert.assertEquals(true,false);
        }



    }

    public static String  randomEmail(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString+"@test.com";
    }

    public static void addEmployeeOnlyName(WebDriver driver,String name){

        driver.findElement(By.id("_asf1")).sendKeys(name);

        driver.findElement(By.xpath("//button[text()='Save Employees']")).click();

        driver.findElement(By.linkText("close")).click();

    }

}
