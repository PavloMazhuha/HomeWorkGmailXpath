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

        Driver.waitElement(gmailMainPage.getOpenNewMessageFormButton());

        gmailMainPage.clickOnOpenNewMeggageFormButton();
        gmailMainPage.setRecipientEmail(TestData.LOGIN);
        gmailMainPage.setSubject("subject");
        gmailMainPage.setBody("body");
        gmailMainPage.clickSendMessageButton();
        gmailMainPage.clickRefreshButton();
        Driver.waitElement(gmailMainPage.getLinkForTestEmail());

        Assert.assertEquals(gmailMainPage.getLinkForTestEmail().isDisplayed(),true);

        gmailMainPage.selectCheckBoxFotTestEmail();
        gmailMainPage.clickDeleteButton();

    }

    @After
    public void clearup () {
        Driver.getInstance().close();
    }
}
