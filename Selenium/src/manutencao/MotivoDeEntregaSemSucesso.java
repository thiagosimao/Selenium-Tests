package manutencao;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.Login;

public class MotivoDeEntregaSemSucesso {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://gmhomolog.greenmile.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMotivoDeEntregaSemSucesso() throws Exception {
		new Login().LoginProcess(driver);
		
		// Abrir a tela
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li/a")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[4]/ul/li[3]/a")).click();

		// Adicionar Motivo
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_novo")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_novo")).click();
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

		String undeliverableKey = "Undeliverable_" + (int) Math.floor(Math.random() * 1000);
		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys(undeliverableKey);
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("Undeliverable_" + (int) Math.floor(Math.random() * 1000));
		new Select(driver.findElement(By.id("type"))).selectByIndex(1);
		driver.findElement(By.id("btn_save")).click();

		// Editar Motivo
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_novo")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("searchFilter")).clear();
		driver.findElement(By.id("searchFilter")).sendKeys(undeliverableKey);
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
				if (isElementPresent(By.id("btn_save")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys("");
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("");
		driver.findElement(By.id("organization_description")).clear();
		driver.findElement(By.id("organization_description")).sendKeys("");
		new Select(driver.findElement(By.id("type"))).selectByIndex(0);
		undeliverableKey = "Undeliverable_" + (int) Math.floor(Math.random() * 1000);
		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys(undeliverableKey);
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("Undeliverable_" + (int) Math.floor(Math.random() * 1000));
		new Select(driver.findElement(By.id("type"))).selectByIndex(2);
		driver.findElement(By.id("btn_save")).click();

		// Excluir Motivo
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_novo")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("searchFilter")).clear();
		driver.findElement(By.id("searchFilter")).sendKeys(undeliverableKey);
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

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
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
