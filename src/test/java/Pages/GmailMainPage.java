package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMainPage {
    WebDriver driver;

    @FindBy (xpath = "//span[@email='test.mazhuha@gmail.com']/ancestor::td/preceding-sibling::td[2]/div")
    private WebElement checkboxForTestEmail;

    public WebElement getLinkForTestEmail() {
        return linkForTestEmail;
    }

    @FindBy (xpath = "//span[@email='test.mazhuha@gmail.com' and not(following-sibling::*)]")
    private WebElement linkForTestEmail;

    @FindBy (xpath = "//div[contains(@class, 'T-I-KE') and @role='button']")
    private WebElement openNewMessageFormButton;

    @FindBy (xpath = "//textarea[@name='to']")
    private WebElement recipientEmail;

    @FindBy (xpath = "//input[@name='subjectbox']")
    private WebElement subjectBox;

    @FindBy (xpath = "//div[@role='textbox']")
    private WebElement bodyBox;

    @FindBy (xpath = "//div[contains(@aria-label,'Send')]")
    private WebElement sendMessageButton;

    @FindBy (xpath = "//div[@role='checkbox']")
    private WebElement firstCheckBox;

    @FindBy (xpath = "//div[@aria-label='Delete']")
    private WebElement deleteButton;

    @FindBy (xpath = "//div[@title='Refresh']")
    private WebElement refreshButton;

    @FindBy (xpath = "//a[@href='https://mail.google.com/mail/#inbox']")
    private WebElement inboxLink;

    public WebElement getInboxLink() {
        return inboxLink;
    }

    public WebElement getOpenNewMessageFormButton() {
        return openNewMessageFormButton;
    }

    public WebElement getFirstCheckBox() {
        return firstCheckBox;
    }

    public GmailMainPage (WebDriver driver) {this.driver = driver;}

    public void clickOnOpenNewMeggageFormButton() {
        openNewMessageFormButton.click();
    }

    public void setRecipientEmail(String email) {
        recipientEmail.sendKeys(email);
    }

    public void setSubject (String subject){
        subjectBox.sendKeys(subject);
    }

    public void setBody(String body) {
        bodyBox.sendKeys(body);
    }

    public void clickSendMessageButton () {
        sendMessageButton.click();
    }

    public void selectCheckBoxFotTestEmail() {
        checkboxForTestEmail.click();
    }

    public void clickDeleteButton () {
        deleteButton.click();
    }

    public void clickRefreshButton (){
        refreshButton.click();
    }

}
