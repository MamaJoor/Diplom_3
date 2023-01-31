package pom;

import org.openqa.selenium.WebDriver;

public abstract class MainPage {

    protected WebDriver driver;

    protected MainPage(WebDriver driver) {
        this.driver = driver;
    }
}