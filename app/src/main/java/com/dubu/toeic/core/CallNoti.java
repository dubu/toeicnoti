package com.dubu.toeic.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * User: kingkingdubu
 * Date: 14. 2. 22
 * Time: 오전 3:36
 */
public class CallNoti  {
    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("https://www.parse.com/apps/toeicnoti/push_notifications/new");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("user_session[email]"));
        element.sendKeys("kozazz@hanmail.net");
        element = driver.findElement(By.name("user_session[email]"));
        element.sendKeys("4989aaparse");
        element.submit();

        // And now use this to visit Google
        driver.get("https://www.parse.com/apps/toeicnoti/push_notifications/new");

        // Find the text input element by its name
        WebElement element2 = driver.findElement(By.name("data"));

        // Enter something to search for
        element2.sendKeys("hi noties");

        // Now submit the form. WebDriver will find the form for us from the element
        element2.submit();




        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
    }
}