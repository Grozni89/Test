import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Clock {

    public static void goToClock(WebDriver driver){

        driver.findElement(By.id("sn_timeclock")).click();

    }

    public static void clickClockIN(WebDriver driver){

        driver.findElement(By.xpath("//li[@class='clockedOut static'] //a[@href='#']")).click();

    }

    public static void clickClockOUT(WebDriver driver){

        driver.findElement(By.xpath("//li[@id='tc_tl_st'] //a[@class='clockGo']")).click();

    }


}
