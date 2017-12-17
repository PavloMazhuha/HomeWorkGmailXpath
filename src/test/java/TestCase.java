import Pages.GmailMainPage;
import Pages.LoginPage;
import Pages.PasswordPage;
import Utils.Driver;
import Utils.TestData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TestCase {
    @Before
    public void startBrowser () {
        Driver.getInstance().get("http://gmail.com");
    }

    @Test
    public void mainTest () {
        LoginPage loginPage = PageFactory.initElements(Driver.getInstance(), LoginPage.class);
        PasswordPage passwordPage = PageFactory.initElements(Driver.getInstance(), PasswordPage.class);
        GmailMainPage gmailMainPage = PageFactory.initElements(Driver.getInstance(), GmailMainPage.class);

        loginPage.setEmail(TestData.LOGIN);
        loginPage.clickNextButton();

        passwordPage.setPassword(TestData.PASSWORD);
        passwordPage.clickNextButton();

        Driver.waitElement(gmailMainPage.getSendButton());

        gmailMainPage.clickOnSendButton();
        gmailMainPage.setRecipientEmail(TestData.LOGIN);
        gmailMainPage.setSubject("subject");
        gmailMainPage.setBody("body");
        gmailMainPage.clickSendMessageButton();
        gmailMainPage.clickRefreshButton();

        Assert.assertEquals(gmailMainPage.getFirstCheckBox().isDisplayed(),true);
        Assert.assertEquals(gmailMainPage.getInboxLink().getText(), "Inbox (1)");

        gmailMainPage.selectCheckBox();
        gmailMainPage.clickDeleteButton();
        Assert.assertEquals(gmailMainPage.getInboxLink().getText(), "Inbox");

    }

    @After
    public void clearup () {
        Driver.getInstance().close();
    }
}
