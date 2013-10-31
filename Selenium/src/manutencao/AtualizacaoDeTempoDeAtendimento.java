package manutencao;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class AtualizacaoDeTempoDeAtendimento {
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
	public void testAtualizacaoDeTempoDeAtendimento() throws Exception {
		new Login().LoginProcess(driver);
		
		// Abrir Atualização de Tempo de Atendimento
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/a")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[13]/a")).click();

		// Pesquisar Atualização de Tempo de Atendimento
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_calculate_results")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//div[2]/div[3]/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//form/div[2]/div[4]/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[7]/li/a")).click();
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();

		driver.findElement(By.xpath("//div[3]/div[3]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[3]/div/div/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[3]/div[4]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[4]/div/div/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.id("minimumMumberOfValidDeliveries")).clear();
		driver.findElement(By.id("minimumMumberOfValidDeliveries")).sendKeys("" + (int) Math.floor(Math.random() * 10));
		driver.findElement(By.id("minSecondsOnDeliveries")).clear();
		driver.findElement(By.id("minSecondsOnDeliveries")).sendKeys(
						  (int) Math.floor(Math.random() * 24) + ":"
						+ (int) Math.floor(Math.random() * 60) + ":"
						+ (int) Math.floor(Math.random() * 60));
		driver.findElement(By.id("maxSecondsOnDeliveries")).clear();
		driver.findElement(By.id("maxSecondsOnDeliveries")).sendKeys(
						  (int) Math.floor(Math.random() * 24) + ":"
						+ (int) Math.floor(Math.random() * 60) + ":"
						+ (int) Math.floor(Math.random() * 60));
		driver.findElement(By.id("defaultHelperFixedTimeSecs")).clear();
		driver.findElement(By.id("defaultHelperFixedTimeSecs")).sendKeys(
						  (int) Math.floor(Math.random() * 24) + ":"
						+ (int) Math.floor(Math.random() * 60) + ":"
						+ (int) Math.floor(Math.random() * 60));
		driver.findElement(By.id("defaultNonHelperFixedTimeSecs")).clear();
		driver.findElement(By.id("defaultNonHelperFixedTimeSecs")).sendKeys(
						  (int) Math.floor(Math.random() * 24) + ":"
						+ (int) Math.floor(Math.random() * 60) + ":"
						+ (int) Math.floor(Math.random() * 60));
		driver.findElement(By.id("btn_calculate_results")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btnRejectSelected")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btnRejectAll")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btnAcceptSelected")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("buttonEventCheckBox")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btnSaveLayout")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

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
