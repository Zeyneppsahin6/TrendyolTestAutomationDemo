import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void SuccessfulLogin() throws InterruptedException {
        loginPage.fillMail(mail)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);
        Assert.assertEquals("Hesabım", mainPage.getUserInfo());
    }

    @Test
    public void unSuccessfulLogin() throws InterruptedException {
        loginPage.fillMail("zeynep@icloud.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        Assert.assertEquals(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test
    public void validateLogin() throws InterruptedException {
        loginPage.fillMail("zeynepicloud.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        Assert.assertEquals(loginPage.getErrorMessage(), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
}
