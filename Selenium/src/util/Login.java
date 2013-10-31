package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	public void LoginProcess(final WebDriver driver){
		driver.get("http://gmqa.greenmile.com");
		driver.findElement(By.id("login_username")).sendKeys("selenium-test");
		driver.findElement(By.id("login_password")).sendKeys("123");
		driver.findElement(By.id("btn_sign_in")).click();
	}
}
