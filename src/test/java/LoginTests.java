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
        driver.findElement(By.id("login-email")).sendKeys(mail);
        driver.findElement(By.name("login-password")).sendKeys("Abcdef123..");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        sleep(3000);
        String warningMessage = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        Assert.assertEquals(warningMessage, "E-posta adresiniz ve/veya şifreniz hatalı.");

        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys("zeynepsahin@icloud.com");
        driver.findElement(By.name("login-password")).clear();
        driver.findElement(By.name("login-password")).sendKeys(password);
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        sleep(3000);
        String warningMessage2 = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        Assert.assertEquals(warningMessage2, "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test
    public void validateLogin() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("zeynepsahin022icloud.com");
        driver.findElement(By.name("login-password")).sendKeys(password);
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        sleep(3000);
        String warningMessage = driver.findElement(By.cssSelector("[class=\"message\"]")).getText();
        Assert.assertEquals(warningMessage, "Lütfen geçerli bir e-posta adresi giriniz.");
    }
}
