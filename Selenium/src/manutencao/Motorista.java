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

public class Motorista {
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
	public void testMotorista() throws Exception {
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
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[5]/ul/li/a")).click();

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

		String driverName = "Driver_" + (int) Math.floor(Math.random() * 1000);
		// Informações Gerais
		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(driverName);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("Driver_" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[4]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.id("adpFileNumber")).clear();
		driver.findElement(By.id("adpFileNumber")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.xpath("//div[2]/div[4]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		new Select(driver.findElement(By.id("unitSystem"))).selectByIndex(1);
		// Dados de Contato
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("phone2")).clear();
		driver.findElement(By.id("phone2")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(1);
		new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(2);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("email" + (int) Math.floor(Math.random() * 1000) + "@email.com");
		// Endereço
		driver.findElement(By.id("addressLine1")).clear();
		driver.findElement(By.id("addressLine1")).sendKeys("Address" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("addressLine2")).clear();
		driver.findElement(By.id("addressLine2")).sendKeys("Complement" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("City" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
		driver.findElement(By.id("district")).clear();
		driver.findElement(By.id("district")).sendKeys("District" + (int) Math.floor(Math.random() * 1000));
		// Geocodificação
		driver.findElement(By.id("latitude")).clear();
		driver.findElement(By.id("latitude")).sendKeys("" + (int) Math.random() * 100);
		driver.findElement(By.id("longitude")).clear();
		driver.findElement(By.id("longitude")).sendKeys("" + (int) Math.random() * 100);
		driver.findElement(By.id("geocodingQuality")).clear();
		driver.findElement(By.id("geocodingQuality")).sendKeys("" + (int) Math.floor(Math.random() * 3 + 1));
		// Licença
		driver.findElement(By.id("licenseNumber")).clear();
		driver.findElement(By.id("licenseNumber")).sendKeys("" + (int) Math.floor(Math.random() * 1000000000));
		driver.findElement(By.xpath("//div[6]/div[4]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[6]/div[4]/div/div/div/input")).sendKeys(((int) Math.floor(Math.random()) * 30 + 1) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1)) + "\\" + ((int) Math.floor(Math.random() * 2050 + 1)));
		// Valor
		driver.findElement(By.xpath("//div[7]/div[4]/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[7]/li")).click();
		// Situação do Motorista
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[1]/div/input")).sendKeys(((int) Math.floor(Math.random() * 30 + 1)) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1)) + "\\" + ((int) Math.floor(Math.random() * 2015 + 1)));
		driver.findElement(By.xpath("//div[8]/div[4]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[8]/div[4]/div/div/div/input")).sendKeys(((int) Math.floor(Math.random() * 30 + 1)) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1)) + "\\" + ((int) Math.floor(Math.random() * 2015 + 1)));
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[2]/div/input")).sendKeys(((int) Math.floor(Math.random() * 30 + 1)) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1)) + "\\" + ((int) Math.floor(Math.random() * 2015 + 1)));
		// Segurança
		driver.findElement(By.xpath("//div[9]/div[3]/div/div/div/select/option")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [addSelection |
		// id=organizations.organization_id | index=0]]
		driver.findElement(By.id("btn_save")).click();

		// Editar Motoristas
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
		driver.findElement(By.id("searchFilter")).sendKeys(driverName);
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

		// Limpar Campos
		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys("");
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("");
		driver.findElement(By.id("organization_description")).clear();
		driver.findElement(By.id("organization_description")).sendKeys("");
		driver.findElement(By.id("adpFileNumber")).clear();
		driver.findElement(By.id("adpFileNumber")).sendKeys("");
		driver.findElement(By.id("preferedLocale_description")).clear();
		driver.findElement(By.id("preferedLocale_description")).sendKeys("");
		new Select(driver.findElement(By.id("unitSystem"))).selectByIndex(0);
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys("");
		driver.findElement(By.id("phone2")).clear();
		driver.findElement(By.id("phone2")).sendKeys("");
		new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(0);
		new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(0);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("addressLine1")).clear();
		driver.findElement(By.id("addressLine1")).sendKeys("");
		driver.findElement(By.id("addressLine2")).clear();
		driver.findElement(By.id("addressLine2")).sendKeys("");
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("");
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("");
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("");
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("");
		driver.findElement(By.id("district")).clear();
		driver.findElement(By.id("district")).sendKeys("");
		driver.findElement(By.id("latitude")).clear();
		driver.findElement(By.id("latitude")).sendKeys("");
		driver.findElement(By.id("longitude")).clear();
		driver.findElement(By.id("longitude")).sendKeys("");
		driver.findElement(By.id("geocodingQuality")).clear();
		driver.findElement(By.id("geocodingQuality")).sendKeys("");
		driver.findElement(By.id("licenseNumber")).clear();
		driver.findElement(By.id("licenseNumber")).sendKeys("");
		driver.findElement(By.id("driverProfileCost_description")).clear();
		driver.findElement(By.id("driverProfileCost_description")).sendKeys("");
		// Informações Gerais
		// ERROR: Caught exception [ERROR: Unsupported command [getEval | | ]]
		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(driverName);
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[4]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.id("adpFileNumber")).clear();
		driver.findElement(By.id("adpFileNumber")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.xpath("//div[2]/div[4]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		new Select(driver.findElement(By.id("unitSystem"))).selectByIndex(2);
		// Dados de Contato
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("phone2")).clear();
		driver.findElement(By.id("phone2")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(3);
		new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(4);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("email" + (int) Math.floor(Math.random() * 1000) + "@email.com");
		// Endereço
		driver.findElement(By.id("addressLine1")).clear();
		driver.findElement(By.id("addressLine1")).sendKeys("Address" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("addressLine2")).clear();
		driver.findElement(By.id("addressLine2")).sendKeys("Complement" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("City" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
		driver.findElement(By.id("district")).clear();
		driver.findElement(By.id("district")).sendKeys("District" + (int) Math.floor(Math.random() * 1000));
		// Geocodificação
		driver.findElement(By.id("latitude")).clear();
		driver.findElement(By.id("latitude")).sendKeys("" + (int) Math.random() * 100);
		driver.findElement(By.id("longitude")).clear();
		driver.findElement(By.id("longitude")).sendKeys("" + (int) Math.random() * 100);
		driver.findElement(By.id("geocodingQuality")).clear();
		driver.findElement(By.id("geocodingQuality")).sendKeys("" + (int) Math.floor(Math.random() * 3 + 1));
		// Licença
		driver.findElement(By.id("licenseNumber")).clear();
		driver.findElement(By.id("licenseNumber")).sendKeys("" + (int) Math.floor(Math.random() * 1000000000));
		driver.findElement(By.xpath("//div[6]/div[4]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[6]/div[4]/div/div/div/input")).sendKeys(((int) Math.floor(Math.random() * 30 + 1)) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1))+ "\\" + ((int) Math.floor(Math.random() * 2050 + 1)));
		// Valor
		driver.findElement(By.xpath("//div[7]/div[4]/div/div/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[7]/li/a")).click();
		// Situação do Motorista
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[1]/div/input")).sendKeys(((int) Math.floor(Math.random() * 30 + 1)) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1)) + "\\" + ((int) Math.floor(Math.random() * 2050 + 1)));
		driver.findElement(By.xpath("//div[8]/div[4]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[8]/div[4]/div/div/div/input")).sendKeys(((int) Math.floor(Math.random() * 30 + 1)) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1)) + "\\" + ((int) Math.floor(Math.random() * 2050 + 1)));
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//div[8]/div[3]/div/div[2]/div/input")).sendKeys(((int) Math.floor(Math.random() * 30 + 1)) + "\\"
								+ ((int) Math.floor(Math.random() * 12 + 1)) + "\\" + ((int) Math.floor(Math.random() * 2050 + 1)));
		// Segurança
		driver.findElement(By.xpath("//div[9]/div[3]/div/div/div/select/option")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [addSelection |
		// id=organizations.organization_id | index=0]]
		driver.findElement(By.id("btn_save")).click();

		// Excluir Motoristas
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
		driver.findElement(By.id("searchFilter")).sendKeys(driverName);
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
