package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {
    WebDriver wd;

    @BeforeMethod
    public void preConditions() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();//упровляй окном расширить
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//имплицидное ожидание отоброжения элемента
        wd.navigate().to("https://trello.com/");//открыть опликацию
    }


    @Test
    public void login1() {
        click(By.cssSelector("[href='/login']"));//нажали на логин
        pause(2000);
        type(By.cssSelector("#user"), "innayrchenko77@gmail.com");//ввели текст
        click(By.cssSelector("#login"));// нажать продолжить
        pause(2000);
        type(By.cssSelector("#password"), "12345.com");
        click(By.cssSelector("#login-submit"));// нажать войти авторизоваться
        pause(3000);
    }

    public void type(By locator, String text) {
        click(locator);//нажать
        wd.findElement(locator).clear();//очистить
        wd.findElement(locator).sendKeys(text);//вписать текст
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void postConditions() {
        wd.close();//закрой апликацию
        wd.quit();//закрой браузер

    }

}
