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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import util.Login;

public class Eventos {
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
	public void testEventos() throws Exception {
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
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[8]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[8]/ul/li/a")).click();

		// Adicionar Eventos
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
				if (isElementPresent(By.id("btn_save_up")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		String eventDesc = "Event_" + (int) Math.floor(Math.random() * 1000);
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(eventDesc);
		driver.findElement(By.id("messagebody")).clear();
		driver.findElement(By.id("messagebody")).sendKeys("Event_" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.xpath("//div[4]/div[2]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//div[4]/div[2]/div/div[4]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		new Select(driver.findElement(By.id("eventModes"))).selectByIndex(1);
		driver.findElement(By.id("acknow")).click();
		
		Actions builder = new Actions(driver);
		WebElement dropElement = driver.findElement(By.id("show-no-checks"));
		WebElement dropElementActions = driver.findElement(By.id("show-no-actions"));
		WebElement dragElement;
		Action dragAndDrop;
		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li/ul/li/a"));
		//builder.dragAndDrop(dragElement, dropElement).perform();
		//dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		//dragAndDrop.perform();
		
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		Thread.sleep(1000L);
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("check_deviation_distance")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("check_deviation_distance")).clear();
		driver.findElement(By.id("check_deviation_distance")).sendKeys("" + (int) Math.floor(Math.random() * 100000));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li/ul/li[2]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("off_planned_maxDeviationMinutes")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("off_planned_maxDeviationMinutes")).clear();
		driver.findElement(By.id("off_planned_maxDeviationMinutes")).sendKeys("" + (int) Math.floor(Math.random() * 100000));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li[2]/ul/li/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("gps_gap_distanceMeters")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("gps_gap_distanceMeters")).clear();
		driver.findElement(By.id("gps_gap_distanceMeters")).sendKeys("" + (int) Math.floor(Math.random() * 1000));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li[2]/ul/li[2]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("late_gps_timeIntervalMinutes")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("late_gps_timeIntervalMinutes")).clear();
		driver.findElement(By.id("late_gps_timeIntervalMinutes")).sendKeys("" + (int) Math.floor(Math.random() * 100));

		dragElement = driver.findElement(By.xpath("//ul/li[2]/ul/li[4]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("drive_home_distance_meters")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("drive_home_distance_meters")).clear();
		driver.findElement(By.id("drive_home_distance_meters")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("drive_home_time_minutes")).clear();
		driver.findElement(By.id("drive_home_time_minutes")).sendKeys("" + (int) Math.floor(Math.random() * 100));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li[3]/ul/li/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("unplanned_stop_time_minutes")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("unplanned_stop_time_minutes")).clear();
		driver.findElement(By.id("unplanned_stop_time_minutes")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("unplanned_defaultRadius")).clear();
		driver.findElement(By.id("unplanned_defaultRadius")).sendKeys("" + (int) Math.floor(Math.random() * 100));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li[4]/ul/li[2]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("route_deviation_maximumRouteDeviationMeters")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("route_deviation_maximumRouteDeviationMeters")).clear();
		driver.findElement(By.id("route_deviation_maximumRouteDeviationMeters")).sendKeys("" + (int) Math.floor(Math.random() * 10000));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li[4]/ul/li[3]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("distanceMeters")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("distanceMeters")).clear();
		driver.findElement(By.id("distanceMeters")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		new Select(driver.findElement(By.id("operator"))).selectByIndex(1);

		dragElement = driver.findElement(By.xpath("//ul/li[4]/ul/li[4]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("stopcancel_reasons")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		new Select(driver.findElement(By.id("stopcancel_reasons"))).selectByIndex(0);

		dragElement = driver.findElement(By.xpath("//ul/li[4]/ul/li[5]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("undeliverable_reasons")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		new Select(driver.findElement(By.id("undeliverable_reasons"))).selectByIndex(0);

		dragElement = driver.findElement(By.xpath("//ul/li[4]/ul/li[6]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("osd_over")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		new Select(driver.findElement(By.id("osd_over"))).selectByIndex(0);
		new Select(driver.findElement(By.id("osd_shorts"))).selectByIndex(0);
		new Select(driver.findElement(By.id("osd_damaged"))).selectByIndex(0);

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li[5]/ul/li/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("service_time_percentualVar")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("service_time_percentualVar")).clear();
		driver.findElement(By.id("service_time_percentualVar")).sendKeys("" + (int) Math.floor(Math.random() * 100));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[5]/ul/li/ul/li/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("action_db_username")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("action_db_username")).clear();
		driver.findElement(By.id("action_db_username")).sendKeys("User_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_db_password")).clear();
		driver.findElement(By.id("action_db_password")).sendKeys("password_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_db_url")).clear();
		driver.findElement(By.id("action_db_url")).sendKeys("url_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_db_driverClass")).clear();
		driver.findElement(By.id("action_db_driverClass")).sendKeys("JDBC_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_db_statement")).clear();
		driver.findElement(By.id("action_db_statement")).sendKeys("Query_" + (int) Math.floor(Math.random() * 100));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[5]/ul/li/ul/li[2]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElementActions).release(dropElementActions).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("action_email_to")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("action_email_to")).clear();
		driver.findElement(By.id("action_email_to")).sendKeys("Email_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_email_from")).clear();
		driver.findElement(By.id("action_email_from")).sendKeys("EmailFrom_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_email_subject")).clear();
		driver.findElement(By.id("action_email_subject")).sendKeys("Assunto_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_email_body")).clear();
		driver.findElement(By.id("action_email_body")).sendKeys("Mensagem_" + (int) Math.floor(Math.random() * 100));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[5]/ul/li/ul/li[3]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElementActions).release(dropElementActions).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("action_http_url")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("action_http_url")).clear();
		driver.findElement(By.id("action_http_url")).sendKeys("url_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_http_data")).clear();
		driver.findElement(By.id("action_http_data")).sendKeys("Dados_" + (int) Math.floor(Math.random() * 100));

		dragElement = driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/div/div[5]/ul/li/ul/li[4]/a"));
		dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElementActions).release(dropElementActions).build();
		dragAndDrop.perform();

		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("action_sms_to")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("action_sms_to")).clear();
		driver.findElement(By.id("action_sms_to")).sendKeys("Para_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("action_sms_text")).clear();
		driver.findElement(By.id("action_sms_text")).sendKeys("Texto_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("btn_save_up")).click();

		// Editar Eventos
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
		driver.findElement(By.id("searchFilter")).sendKeys(eventDesc);
		Thread.sleep(3000);
		// Warning: waitForTextPresent may require manual changes
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

		driver.findElement(By.cssSelector("a.table-action-editlink")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("btn_save_up")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("");
		driver.findElement(By.id("messagebody")).clear();
		driver.findElement(By.id("messagebody")).sendKeys("");
		driver.findElement(By.id("organization_description")).clear();
		driver.findElement(By.id("organization_description")).sendKeys("");
		driver.findElement(By.id("eventtype_description")).clear();
		driver.findElement(By.id("eventtype_description")).sendKeys("");
		new Select(driver.findElement(By.id("eventModes"))).selectByIndex(0);
		driver.findElement(By.id("acknow")).click();
		eventDesc = "Event_" + (int) Math.floor(Math.random() * 1000);
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(eventDesc);
		driver.findElement(By.id("messagebody")).clear();
		driver.findElement(By.id("messagebody")).sendKeys("Event_" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.xpath("//div[4]/div[2]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//div[4]/div[2]/div/div[4]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		new Select(driver.findElement(By.id("eventModes"))).selectByIndex(1);
		driver.findElement(By.id("acknow")).click();
		driver.findElement(By.id("btn_save_up")).click();

		// Excluir Eventos
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
		driver.findElement(By.id("searchFilter")).sendKeys(eventDesc);
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
