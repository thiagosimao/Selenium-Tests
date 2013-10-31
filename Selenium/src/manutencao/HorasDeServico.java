package manutencao;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class HorasDeServico {
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
	public void testHorasDeServico() throws Exception {
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
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[9]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[9]/ul/li[2]/a")).click();

		// Pesquisa Horas de Serviço
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btnSendFilterHOSMap")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//form/div[2]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//form/div[3]/div/input")).clear();
		driver.findElement(By.xpath("//form/div[3]/div/input")).sendKeys("01/01/2013");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		driver.findElement(By.xpath("//form/div[4]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.id("btnSendFilterHOSMap")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div[3]/ul/li/a")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div[3]/ul/li[2]/a")).click();
		driver.findElement(By.id("btnHideLogBook")).click();
		driver.findElement(By.id("btnCleanFilterHOSMap")).click();
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
