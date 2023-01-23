package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorTransitionsPage extends MainPage {

    private final By bunSection = By.xpath("//span[text()='Булки']");
    private final By sauceSection = By.xpath("//span[text()='Соусы']");
    private final By toppingSection = By.xpath("//span[text()='Начинки']");
    private final By activeSection = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");

    public ConstructorTransitionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBunSection() {
        driver.findElement(bunSection).click();
    }

    public void clickSauceSection() {
        driver.findElement(sauceSection).click();
    }

    public void clickToppingSection() {
        driver.findElement(toppingSection).click();
    }

    public String textFromActiveSection() {
        return driver.findElement(activeSection).getText();
    }
}