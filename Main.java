import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class Main {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get("https://app-stg.converted.in/login");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("a.hussien@converted.in");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("heba12345");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
  Thread.sleep(2000);


        String script = "return document.querySelector('convertedin-sidebar').shadowRoot.querySelector('div.convertedin-sidebar')";

        WebElement convertedinSidebar = (WebElement) js.executeScript(script);

        // Interact with elements within the shadow DOM
        WebElement sidebar1 = convertedinSidebar.findElement(By.cssSelector("div.sidebar__container.flex.flex-column.flex-grow-1.ng-star-inserted"));
        WebElement sidebar2 = sidebar1.findElement(By.cssSelector("div.flex-grow-1.flex.flex-column.justify-content-between"));

        WebElement parentAccordion = sidebar2.findElement(By.cssSelector("div.flex.flex-column.gap-1.mb-1"));
        WebElement displayCampaigns = parentAccordion.findElement(By.cssSelector("p-accordiontab.p-element.ng-tns-c823280842-4.sidebar__main-accordion.ng-star-inserted"));
        displayCampaigns.click();
        WebElement adrollParent = parentAccordion.findElement(By.cssSelector("div.p-toggleable-content.ng-tns-c823280842-4.ng-trigger.ng-trigger-tabContent"));
        WebElement adrollchild1 = adrollParent.findElement(By.cssSelector("div.p-accordion-content.ng-tns-c823280842-4"));
        WebElement adrollchild2 = adrollchild1.findElement(By.cssSelector("ul.flex.flex-column.sidebar__subroutes.gap-1.ng-star-inserted"));
        WebElement adrollchild3 = adrollchild2.findElement(By.cssSelector("li.sidebar__subroute.ng-star-inserted"));
        WebElement adrollchild4 = adrollchild3.findElement(By.cssSelector("a.flex.justify-content-between.align-items-center.ng-star-inserted"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(adrollchild4));
        element.click();






    }
}





