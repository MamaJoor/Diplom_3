package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorTransitionsPage extends MainPage {

    private final By bunSection = By.xpath("//span[text()='Булки']");
    private final By sauceSection = By.xpath("//span[text()='Соусы']");
    private final By toppingSection = By.xpath("//span[text()='Начинки']");
    private final By activeBunSection = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Булки']");

    private final By activeSauceSection = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Соусы']");

    private final By activeToppingSection = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Начинки']");
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
    public String textFromActiveBunSection() {
        return driver.findElement(activeBunSection).getText();
    }

    public String textFromActiveSauceSection() {
        return driver.findElement(activeSauceSection).getText();
    }

    public String textFromActiveToppingSection() {
        return driver.findElement(activeToppingSection).getText();
    }
}