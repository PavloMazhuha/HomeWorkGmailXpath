package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    WebDriver driver;
    @FindBy (xpath = "//input[@id='identifierId']")
    private WebElement emailField;

    @FindBy (xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    public LoginPage (WebDriver driver) {this.driver = driver;}

    public void setEmail (String email){
        emailField.sendKeys(email);
    }

    public void clickNextButton () {
        nextButton.click();
    }
}
