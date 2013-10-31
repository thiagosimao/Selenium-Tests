package seguranca;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FaixaDeIP {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://gmqualidade.greenmile.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFaixaDeIP() throws Exception {
		driver.get("http://gmqualidade.greenmile.com");
		driver.findElement(By.id("login_username")).sendKeys("selenium-test");
		driver.findElement(By.id("login_password")).sendKeys("123");
		driver.findElement(By.id("btn_sign_in")).click();
		
		// Abrir Faixa de IP
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[4]/a")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[4]/ul/li[2]/a")).click();

		// Adicionar Faixa de IP
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_new")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_new")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_save")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		String ipDesc = "testIP_" + ((int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(ipDesc);
		driver.findElement(By.xpath("//div[4]/div/div/div/div[1]/input")).clear();
		driver.findElement(By.xpath("//div[4]/div/div/div/div[1]/input")).sendKeys("10.1.1." + ((int) Math.floor(Math.random() * 10)));
		driver.findElement(By.xpath("//div[4]/div/div/div/div[2]/input")).clear();
		driver.findElement(By.xpath("//div[4]/div/div/div/div[2]/input")).sendKeys("10.1.1." + ((int) Math.floor(Math.random() * 250 + 10)));
		driver.findElement(By.id("btn_save")).click();

		// Editar Faixa de IP
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_new")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("searchFilter")).clear();
		driver.findElement(By.id("searchFilter")).sendKeys(ipDesc);
		// Warning: waitForTextPresent may require manual changes
		Thread.sleep(3000);
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.cssSelector("a.table-action-editlink")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_edit")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		//ipDesc = "testIP_" + ((int) Math.floor(Math.random() * 1000));
		//driver.findElement(By.id("description")).clear();
		//driver.findElement(By.id("description")).sendKeys(ipDesc);
		driver.findElement(By.xpath("//div[4]/div/div/div/div[1]/input")).clear();
		driver.findElement(By.xpath("//div[4]/div/div/div/div[1]/input")).sendKeys("10.1.1." + ((int) Math.floor(Math.random() * 10)));
		driver.findElement(By.xpath("//div[4]/div/div/div/div[2]/input")).clear();
		driver.findElement(By.xpath("//div[4]/div/div/div/div[2]/input")).sendKeys("10.1.1." + ((int) Math.floor( Math.random() * 250 + 10)));
		driver.findElement(By.id("btn_edit")).click();

		// Excluir Faixa de IP
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_new")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("searchFilter")).clear();
		driver.findElement(By.id("searchFilter")).sendKeys(ipDesc);
		// Warning: waitForTextPresent may require manual changes
		Thread.sleep(3000);
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (driver.findElement(By.cssSelector("BODY")).getText()
						.matches("^[\\s\\S]*$"))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.cssSelector("span.slick-column-name > input[type=\"checkbox\"]")).click();
		driver.findElement(By.id("buttonEventCheckBox")).click();
		String a = closeAlertAndGetItsText();
		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/ul/li[2]/span[2]")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

}
