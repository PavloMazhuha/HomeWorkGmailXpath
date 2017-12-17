package Pages;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordPage {
    WebDriver driver;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy (xpath = "//div[@id='passwordNext']")
    private WebElement nextButton;

    public PasswordPage (WebDriver driver){this.driver = driver;}

    public void setPassword (String password) {
        Driver.waitElement(nextButton);
        passwordField.sendKeys(password);
    }

    public void clickNextButton () {
        Driver.waitElement(nextButton);
        nextButton.click();
    }


}
