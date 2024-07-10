package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
    @FindBy(xpath = "//a[@class='login']")
    WebElement loginBtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement logoImage;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement searchBox;

}
