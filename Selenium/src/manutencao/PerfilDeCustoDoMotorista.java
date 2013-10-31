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

import util.Login;

public class PerfilDeCustoDoMotorista {
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
	public void testPerfilDeCustoDoMotorista() throws Exception {
		new Login().LoginProcess(driver);
		
		// Abrir Tela
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
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[5]/ul/li[2]/a")).click();

		// Adicionar Perfil
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

		String profileDesc = "Profile_" + (int) Math.floor(Math.random() * 1000);
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(profileDesc);
		driver.findElement(By.xpath("//form/div[2]/div[4]/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.id("fixedRouteCost")).clear();
		driver.findElement(By.id("fixedRouteCost")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("costPerHour")).clear();
		driver.findElement(By.id("costPerHour")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("overtimeRatePerHour")).clear();
		driver.findElement(By.id("overtimeRatePerHour")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("minimumTimeHours")).clear();
		driver.findElement(By.id("minimumTimeHours")).sendKeys("" + (int) Math.floor(Math.random() * 10 + 1));
		driver.findElement(By.id("regularTimeMinutes")).clear();
		driver.findElement(By.id("regularTimeMinutes")).sendKeys("" + (int) Math.floor(Math.random() * 10 + 1));
		driver.findElement(By.id("perDistanceRateKm")).clear();
		driver.findElement(By.id("perDistanceRateKm")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("minimumDistance")).clear();
		driver.findElement(By.id("minimumDistance")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("perSize1Rate")).clear();
		driver.findElement(By.id("perSize1Rate")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("minimumSize1")).clear();
		driver.findElement(By.id("minimumSize1")).sendKeys("" + (int) Math.floor(Math.random() * 10 + 1));
		driver.findElement(By.id("btn_save")).click();

		// Editar Perfil
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
		driver.findElement(By.id("searchFilter")).sendKeys(profileDesc);
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

		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("");
		driver.findElement(By.id("organization_description")).clear();
		driver.findElement(By.id("organization_description")).sendKeys("");
		driver.findElement(By.id("fixedRouteCost")).clear();
		driver.findElement(By.id("fixedRouteCost")).sendKeys("");
		driver.findElement(By.id("costPerHour")).clear();
		driver.findElement(By.id("costPerHour")).sendKeys("");
		driver.findElement(By.id("overtimeRatePerHour")).clear();
		driver.findElement(By.id("overtimeRatePerHour")).sendKeys("");
		driver.findElement(By.id("minimumTimeHours")).clear();
		driver.findElement(By.id("minimumTimeHours")).sendKeys("");
		driver.findElement(By.id("regularTimeMinutes")).clear();
		driver.findElement(By.id("regularTimeMinutes")).sendKeys("");
		driver.findElement(By.id("perDistanceRateKm")).clear();
		driver.findElement(By.id("perDistanceRateKm")).sendKeys("");
		driver.findElement(By.id("minimumDistance")).clear();
		driver.findElement(By.id("minimumDistance")).sendKeys("");
		driver.findElement(By.id("perSize1Rate")).clear();
		driver.findElement(By.id("perSize1Rate")).sendKeys("");
		driver.findElement(By.id("minimumSize1")).clear();
		driver.findElement(By.id("minimumSize1")).sendKeys("");
		profileDesc = "Profile_" + (int) Math.floor(Math.random() * 1000);
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(profileDesc);
		driver.findElement(By.xpath("//form/div[2]/div[4]/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.id("fixedRouteCost")).clear();
		driver.findElement(By.id("fixedRouteCost")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("costPerHour")).clear();
		driver.findElement(By.id("costPerHour")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("overtimeRatePerHour")).clear();
		driver.findElement(By.id("overtimeRatePerHour")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("minimumTimeHours")).clear();
		driver.findElement(By.id("minimumTimeHours")).sendKeys("" + (int) Math.floor(Math.random() * 10 + 1));
		driver.findElement(By.id("regularTimeMinutes")).clear();
		driver.findElement(By.id("regularTimeMinutes")).sendKeys("" + (int) Math.floor(Math.random() * 10 + 1));
		driver.findElement(By.id("perDistanceRateKm")).clear();
		driver.findElement(By.id("perDistanceRateKm")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("minimumDistance")).clear();
		driver.findElement(By.id("minimumDistance")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("perSize1Rate")).clear();
		driver.findElement(By.id("perSize1Rate")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("minimumSize1")).clear();
		driver.findElement(By.id("minimumSize1")).sendKeys("" + (int) Math.floor(Math.random() * 10 + 1));
		driver.findElement(By.id("btn_save")).click();

		// Excluir Perfil
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
		driver.findElement(By.id("searchFilter")).sendKeys(profileDesc);
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
