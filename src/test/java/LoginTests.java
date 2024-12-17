import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(description = "Başarılı kullanıcı girişi kontrolü")
    public void SuccessfulLogin() throws InterruptedException {
        loginPage.fillMail(mail)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);
        assertEqualsText("Hesabım", mainPage.getUserInfo());
    }

    @Test(description = "Başarısız kullanıcı girişi kontrolü")
    public void unSuccessfulLogin() throws InterruptedException {
        loginPage.fillMail("zeynep@outlook.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test(description = "Geçersiz karakter girişi kontrolü")
    public void validateLogin() throws InterruptedException {
        loginPage.fillMail("zeynepoutlook.com")
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
/*
    @Test(description = "Max-min karakter kontrolü")
    public void maxMinCharacterControl() throws InterruptedException {
        loginPage.clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "Lütfen e-posta ve/veya şifre alanını doldurunuz.");

        loginPage.fillMail("ksgökdhglhugşdhgidzgjzsşrghıaegjsgnzsşghıairtjpgodfmgjldxkdfnbzlkdhfgorgıspfmzslfbnxdışheipıjfsmddmjvzdfghdzşfgoıhgkgheslgaeşgnzşgawfnlkfxdgjdşzjgzi")
                .fillPassword("ldgjxdşogjihudiphobzdşfbjzoşdıghaşoıfjszlghseroituaweşfjdhgşaekmzdfhbzhıjiagkzRŞhjseşywğfzlihesripğıxfljhphmfjlhiğrhıdrğyıiHmfşthojesidxşhjosrthy")
                .clickLogin();

        sleep(3000);
        assertEqualsText(loginPage.getErrorMessage(), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
 */
}
