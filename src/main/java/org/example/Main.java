package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    protected static WebDriver driver;


    protected static String productName1 = "Cucumber";
    protected static String productName2 = "Brocolli";
    protected static String productName3 = "Carrot";
    protected static String promoC = " test 11";


    public static void navigateTo(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }




    public static void addingProduct1(String nameOfProduct1)
    {
        List<WebElement> productList = driver.findElements(By.cssSelector("h4.product-name"));

        System.out.println(productList);
        for (int i = 0 ; i < productList.size(); i++ )
        {
            String productName1 = productList.get(i).getText();
            if(productName1.contains(nameOfProduct1) )
            {
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

            }



        }


    }

    public static void addingProduct2(String nameOfProduct2) throws InterruptedException {
        List<WebElement> productList = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0 ; i < productList.size(); i++ )
        {
            String productName1 = productList.get(i).getText();
            if(productName1.contains(nameOfProduct2))
            {
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }

    }


    public static void addingProduct3(String nameOfProduct3) throws InterruptedException {
        Thread.sleep(5000);

        List<WebElement> productList = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0 ; i < productList.size(); i++ )
        {
            String productName1 = productList.get(i).getText();
            if(productName1.contains(nameOfProduct3))
            {
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }


    }

    public static void clickOnCart (){
        WebElement cartIcon = driver.findElement(By.cssSelector(".cart-icon"));
        cartIcon.click();


        WebElement processToCheck = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
        processToCheck.click();
    }
    public static void applyPromocode (String promoCode){

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
        WebElement promocode = driver.findElement(By.xpath("//input[@class='promoCode']"));
        promocode.sendKeys(promoCode);

        WebElement apply = driver.findElement(By.xpath("//button[@class='promoBtn']"));
        apply.click();

        WebDriverWait waitI = new WebDriverWait(driver , Duration.ofSeconds(5));
        waitI.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

        String printInfo = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        System.out.println(printInfo);
    }




    public static void main(String[] args) throws InterruptedException {

        navigateTo();
        addingProduct1(productName1);
        addingProduct2(productName2);
        addingProduct3(productName3);
        clickOnCart();
        applyPromocode(promoC);

    }
}
