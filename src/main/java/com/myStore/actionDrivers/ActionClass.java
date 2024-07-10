package com.myStore.actionDrivers;

import com.myStore.ActionInterface.ActionInterface;
import com.myStore.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class ActionClass extends BaseClass implements ActionInterface
{


    @Override
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    @Override
    public void click(WebDriver ldriver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();

    }

    @Override
    public boolean isDisplayed(WebDriver ldriver, WebElement ele) {

       try {
           return ele.isDisplayed();
       }catch(Exception e){
           return false;
       }
    }

    @Override
    public boolean type(WebElement ele, String text) {
        try {
            if (ele.isDisplayed()) {
                ele.clear();
                ele.sendKeys(text);
                // Consider using a logger for info messages
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean findElement(WebDriver ldriver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            // System.out.println("Location not found: "+locatorName);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element at");

            } else {
                System.out.println("Unable to locate element at");
            }
        }
        return flag;
    }

    @Override
    public boolean isSelected(WebDriver ldriver, WebElement ele) {
        try{
           return ele.isSelected();
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean isEnabled(WebDriver ldriver, WebElement ele) {
        try {
            return ele.isEnabled();
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean selectBySendkeys(String value, WebElement ele) {
        try{
            ele.sendKeys(value);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean selectByIndex(WebElement element, int index) {
        try{
            new Select(element).selectByIndex(index);
            return true;
        }catch(NoSuchElementException e) {
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean selectByValue(WebElement element, String value) {
        try{
            new Select(element).selectByValue(value);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean selectByVisibleText(String visibletext, WebElement ele) {
        try{
            new Select(ele).selectByVisibleText(visibletext);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean mouseHoverByJavaScript(WebElement locator) {
        try{
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].mouseover()",locator);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean JSClick(WebDriver driver, WebElement ele) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean switchToFrameByIndex(WebDriver driver, int index) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(index);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean switchToFrameById(WebDriver driver, String idValue) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(idValue);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean switchToFrameByName(WebDriver driver, String nameValue) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(nameValue);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean switchToDefaultFrame(WebDriver driver) {
       try{
           driver.switchTo().defaultContent();
           return true;
       }catch(Exception e){
           return false;
       }
    }

    @Override
    public void mouseOverElement(WebDriver driver, WebElement element) {

        try{
            new Actions(driver).moveToElement(element).build().perform();
        }catch(Exception e){
            e.printStackTrace();
        }
    } //no return statements since return type is void and not boolean.


    @Override
    public boolean moveToElement(WebDriver driver, WebElement ele) {
       try{
           new Actions(driver).moveToElement(ele).scrollToElement(ele);
           return true;
       }catch(Exception e){
           return false;
       }
    }

    @Override
    public boolean mouseover(WebDriver driver, WebElement ele) {
        try{
            new Actions(driver).moveToElement(ele).scrollToElement(ele);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
        try{
            new Actions(driver).dragAndDropBy(source,x,y).build().perform();
            Thread.sleep(5000);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
        try{
            new Actions(driver).dragAndDrop(source,target).perform();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
        try{
            new Actions(driver).dragAndDropBy(ele,x,y).build().perform();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean rightclick(WebDriver driver, WebElement ele) {
        try{
            Actions clicker = new Actions(driver);
            clicker.contextClick(ele).perform();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
        try{
            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
                if(driver.getTitle().contains(windowTitle)){
                    return true;
                }
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean switchToNewWindow(WebDriver driver) {
        try {
            Set<String> newWindow = driver.getWindowHandles();
            Object popup[] = newWindow.toArray();
            driver.switchTo().window(popup[1].toString());
        }catch(Exception e){
            return false;
        }
        return true;

    }

    @Override
    public boolean switchToOldWindow(WebDriver driver) {
        try {
            Set<String> oldWindow = driver.getWindowHandles();
            Object popup[] = oldWindow.toArray();
            driver.switchTo().window(popup[0].toString());
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public int getColumncount(WebElement row) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        int a = columns.size();
        System.out.println(a);
        for (WebElement column : columns){
            System.out.println(column.getText());


        }
        return a;
    }

    @Override
    public int getRowCount(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a = rows.size()-1;
        return a;

    }

    @Override
    public boolean Alert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return true;
    }

    @Override
    public boolean launchUrl(WebDriver driver, String url) {
        try{
            driver.navigate().to(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isAlertPresent(WebDriver driver) {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }

    @Override
    public String getCurrentURL(WebDriver driver) {
        String text1 = driver.getCurrentUrl();
        return text1;
    }

    @Override
    public String getTitle(WebDriver driver) {
        String text = driver.getTitle();
        return text;
    }

    @Override
    public boolean click1(WebElement locator, String locatorName) {
        try{
            locator.click();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }catch(Exception e) {
        }

    }

    @Override
    public void implicitWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Override
    public void explicitWait(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void pageLoadTimeOut(WebDriver driver, int timeOut) {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

    }

    @Override
    public String screenShot(WebDriver driver, String filename) {
        String dateName = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"\\Screenshots"+filename+"_"+dateName+".png";
        try {
            FileUtils.copyFile(source,new File(destination));
        }catch (Exception e){
            e.printStackTrace();

        }
        return dateName;
    }

    @Override
    public String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }
}
