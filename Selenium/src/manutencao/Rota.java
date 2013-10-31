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
import org.openqa.selenium.support.ui.Select;

import util.Login;

public class Rota {
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
	public void testRota() throws Exception {
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
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[11]/a")).click();

		// Adicionar Rota
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
				if (isElementPresent(By.id("btn_save_and_close")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();

		String routeKey = "Route_" + (int) Math.floor(Math.random() * 1000);
		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys(routeKey);
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//form/div[2]/div[4]/div/div[1]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("Route_" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.xpath("//form/div[2]/div[4]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[7]/li/a")).click();
		driver.findElement(By.id("hasHelper")).click();
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[1]/div/input")).clear();

		dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[1]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[1]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[2]/div/input")).clear();
		calendar.add(Calendar.DATE, 1);
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[2]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[2]/div/input")).clear();
		calendar.add(Calendar.DATE, 1);
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[2]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.id("plannedCost")).clear();
		driver.findElement(By.id("plannedCost")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("btn_save_and_close")).click();

		// Adicionar Paradas
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
		driver.findElement(By.id("searchFilter")).sendKeys(routeKey);
		Thread.sleep(3000);
		// Warning: waitForTextPresent may require manual changes
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
				if (isElementPresent(By.id("btn_save_and_add_stop")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_add_stop")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_save_and_close")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys("Stop_" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		new Select(driver.findElement(By.id("placement"))).selectByIndex(1);
		driver.findElement(By.id("plannedSize1")).clear();
		driver.findElement(By.id("plannedSize1")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("plannedSize2")).clear();
		driver.findElement(By.id("plannedSize2")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("plannedSize3")).clear();
		driver.findElement(By.id("plannedSize3")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("plannedPickupSize1")).clear();
		driver.findElement(By.id("plannedPickupSize1")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("plannedPickupSize2")).clear();
		driver.findElement(By.id("plannedPickupSize2")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("plannedPickupSize3")).clear();
		driver.findElement(By.id("plannedPickupSize3")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("btn_save_and_close")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_exit")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_exit")).click();

		// Adicionar Motorista
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
		driver.findElement(By.id("searchFilter")).sendKeys(routeKey);
		Thread.sleep(3000);
		// Warning: waitForTextPresent may require manual changes
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
				if (isElementPresent(By.id("btn_save_and_add_stop")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_show_assign_driver_to_route")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_save_assign_driver")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div[5]/form/div[2]/div/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[7]/li/a")).click();
		driver.findElement(By.id("btn_save_assign_driver")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_exit")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_exit")).click();

		// Adicionar Equipamento
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
		driver.findElement(By.id("searchFilter")).sendKeys(routeKey);
		Thread.sleep(3000);
		// Warning: waitForTextPresent may require manual changes
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
				if (isElementPresent(By.id("btn_save_and_add_stop")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_show_assign_equipment_to_route")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_save_assign_equipment")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div[5]/form/div[2]/div/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[8]/li/a")).click();
		driver.findElement(By.id("btn_save_assign_equipment")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_exit")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("btn_exit")).click();

		// Editar Rota
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
		driver.findElement(By.id("searchFilter")).sendKeys(routeKey);
		Thread.sleep(3000);
		// Warning: waitForTextPresent may require manual changes
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
				if (isElementPresent(By.id("btn_save_and_close")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("origin_description")).clear();
		driver.findElement(By.id("origin_description")).sendKeys("");
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("");
		driver.findElement(By.id("destination_description")).clear();
		driver.findElement(By.id("destination_description")).sendKeys("");
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[2]/div/input")).clear();
		driver.findElement(By.id("plannedCost")).clear();
		driver.findElement(By.id("plannedCost")).sendKeys("");
		driver.findElement(By.id("hasHelper")).click();
		driver.findElement(By.id("lastStopIsDestination")).click();
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("Route_" + (int) Math.floor(Math.random() * 1000));
		calendar = Calendar.getInstance();
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[1]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[1]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[2]/div/input")).clear();
		calendar.add(Calendar.DATE, 1);
		driver.findElement(By.xpath("//div[3]/div[3]/div/div[2]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[2]/div/input")).clear();
		calendar.add(Calendar.DATE, 1);
		driver.findElement(By.xpath("//div[3]/div[4]/div/div[2]/div/input")).sendKeys(dateFormat.format(calendar.getTime()));
		driver.findElement(By.id("plannedCost")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("btn_save_and_close")).click();

		// Excluir Rota
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
		driver.findElement(By.id("searchFilter")).sendKeys(routeKey);
		Thread.sleep(3000);
		// Warning: waitForTextPresent may require manual changes
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
