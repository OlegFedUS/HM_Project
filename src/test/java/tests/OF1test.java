package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.List;

public class OF1test extends BaseTest {

    @Test
    public void webTest(){

        getDriver().get("https://www.noob-club.ru/");

        getDriver().findElement(By.linkText("войдите")).click();

        WebElement user = (new WebDriverWait(getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//dd/input[@name='user']")));
        user.sendKeys("abc@yahoo.com");

        WebElement password = getDriver().findElement(By.xpath("//dd/input[@name='passwrd']"));
        password.sendKeys("abc123");

        getDriver().findElement(By.xpath("//input[@class='button_submit']")).click();

        WebElement error = getDriver().findElement(By.xpath("//p[contains(text(), 'Такого пользователя не существует.')]"));

        String error_text = error.getText();

        Assert.assertEquals(error_text, "Такого пользователя не существует.");

        getDriver().findElement(By.xpath("//img[@src='/static/images/logo.png']")).click();

        getDriver().findElement(By.linkText("Какие предметы, контент и системы пропадут с выходом Wrath of the Lich King Classic")).click();

        List<WebElement> text = getDriver().findElements(By.xpath("//div[@class='inner']"));


        for (int i = 0; i < text.size(); i++){
            System.out.println(text.get(i));
            Assert.assertTrue(text.get(i).getText().toLowerCase().contains("wrath of the lich king"));
        }



    }
}
