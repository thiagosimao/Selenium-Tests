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

public class Localidades {
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
	public void testLocalidades() throws Exception {
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
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[3]/ul/li[6]/ul/li/a")).click();

		// Adicionar Localidades
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

		// Dados da Localidade
		String localeKey = "" + (int) Math.floor(Math.random() * 1000000);
		driver.findElement(By.id("key")).clear();
		driver.findElement(By.id("key")).sendKeys(localeKey);
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("Locale_" + (int) Math.floor(Math.random() * 100));
		new Select(driver.findElement(By.id("locationType_id"))).selectByIndex(1);
		// Endereço
		driver.findElement(By.id("addressLine1")).clear();
		driver.findElement(By.id("addressLine1")).sendKeys("Address_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("City_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("" + (int) Math.floor(Math.random() * 10000000));
		driver.findElement(By.id("district")).clear();
		driver.findElement(By.id("district")).sendKeys("District_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("addressLine2")).clear();
		driver.findElement(By.id("addressLine2")).sendKeys("Complement_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
		// Dados de Contato
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("phone2")).clear();
		driver.findElement(By.id("phone2")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("email" + (int) Math.floor(Math.random() * 1000) + "@email.com");
		new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(1);
		new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(2);
		// Geocodificação
		driver.findElement(By.id("latitude")).clear();
		driver.findElement(By.id("latitude")).sendKeys("" + (int) Math.random() * 100);
		driver.findElement(By.id("longitude")).clear();
		driver.findElement(By.id("longitude")).sendKeys("" + (int) Math.random() * 100);
		new Select(driver.findElement(By.id("geocodingQuality"))).selectByIndex(1);
		driver.findElement(By.id("deliveryRadius")).clear();
		driver.findElement(By.id("deliveryRadius")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		// Tipos de Tempo de Atendimento
		new Select(driver.findElement(By.id("serviceTimeType_id"))).selectByIndex(1);
		// Tipos de Janela de Atendimento
		new Select(driver.findElement(By.id("timeWindowType_id"))).selectByIndex(1);
		// Tempo de Atendimento Específico do Cliente
		driver.findElement(By.id("helperFixedTimeSecs")).clear();
		driver.findElement(By.id("helperFixedTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("helperVarTimeSecs")).clear();
		driver.findElement(By.id("helperVarTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("nonHelperFixedTimeSecs")).clear();
		driver.findElement(By.id("nonHelperFixedTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("nonHelperVarTimeSecs")).clear();
		driver.findElement(By.id("nonHelperVarTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		// Instruções
		driver.findElement(By.id("deliveryInstructions")).clear();
		driver.findElement(By.id("deliveryInstructions")).sendKeys("Instructions_" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("fixedCost")).clear();
		driver.findElement(By.id("fixedCost")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("perSize1Rate")).clear();
		driver.findElement(By.id("perSize1Rate")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("btn_save")).click();

		// Editar Localidades
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
		driver.findElement(By.id("searchFilter")).sendKeys(localeKey);
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

		// Limpar Campos
		driver.findElement(By.id("organization_description")).clear();
		driver.findElement(By.id("organization_description")).sendKeys("");
		driver.findElement(By.id("accountType_description")).clear();
		driver.findElement(By.id("accountType_description")).sendKeys("");
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("");
		driver.findElement(By.id("addressLine1")).clear();
		driver.findElement(By.id("addressLine1")).sendKeys("");
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("");
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("");
		driver.findElement(By.id("district")).clear();
		driver.findElement(By.id("district")).sendKeys("");
		driver.findElement(By.id("addressLine2")).clear();
		driver.findElement(By.id("addressLine2")).sendKeys("");
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("");
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("");
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys("");
		driver.findElement(By.id("phone2")).clear();
		driver.findElement(By.id("phone2")).sendKeys("");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(0);
		new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(0);
		driver.findElement(By.id("latitude")).clear();
		driver.findElement(By.id("latitude")).sendKeys("");
		driver.findElement(By.id("longitude")).clear();
		driver.findElement(By.id("longitude")).sendKeys("");
		new Select(driver.findElement(By.id("geocodingQuality"))).selectByIndex(0);
		driver.findElement(By.id("deliveryRadius")).clear();
		driver.findElement(By.id("deliveryRadius")).sendKeys("");
		new Select(driver.findElement(By.id("serviceTimeType_id"))).selectByIndex(0);
		new Select(driver.findElement(By.id("timeWindowType_id"))).selectByIndex(0);
		driver.findElement(By.id("helperFixedTimeSecs")).clear();
		driver.findElement(By.id("helperFixedTimeSecs")).sendKeys("");
		driver.findElement(By.id("helperVarTimeSecs")).clear();
		driver.findElement(By.id("helperVarTimeSecs")).sendKeys("");
		driver.findElement(By.id("nonHelperFixedTimeSecs")).clear();
		driver.findElement(By.id("nonHelperFixedTimeSecs")).sendKeys("");
		driver.findElement(By.id("nonHelperVarTimeSecs")).clear();
		driver.findElement(By.id("nonHelperVarTimeSecs")).sendKeys("");
		driver.findElement(By.id("deliveryInstructions")).clear();
		driver.findElement(By.id("deliveryInstructions")).sendKeys("");
		driver.findElement(By.id("fixedCost")).clear();
		driver.findElement(By.id("fixedCost")).sendKeys("");
		driver.findElement(By.id("perSize1Rate")).clear();
		driver.findElement(By.id("perSize1Rate")).sendKeys("");
		// Preencher Campos
		// Dados da Localidade
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
		driver.findElement(By.xpath("//div[2]/div[3]/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("Locale_" + (int) Math.floor(Math.random() * 100));
		// Endereço
		driver.findElement(By.id("addressLine1")).clear();
		driver.findElement(By.id("addressLine1")).sendKeys("Address_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("City_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("" + (int) Math.floor(Math.random() * 10000000));
		driver.findElement(By.id("district")).clear();
		driver.findElement(By.id("district")).sendKeys("District_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("addressLine2")).clear();
		driver.findElement(By.id("addressLine2")).sendKeys("Complement_" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
		// Dados de Contato
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("phone2")).clear();
		driver.findElement(By.id("phone2")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("email" + (int) Math.floor(Math.random() * 1000) + "@email.com");
		new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(3);
		new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(4);
		// Geocodificação
		driver.findElement(By.id("latitude")).clear();
		driver.findElement(By.id("latitude")).sendKeys("" + (int) Math.random() * 100);
		driver.findElement(By.id("longitude")).clear();
		driver.findElement(By.id("longitude")).sendKeys("" + (int) Math.random() * 100);
		new Select(driver.findElement(By.id("geocodingQuality"))).selectByIndex(2);
		driver.findElement(By.id("deliveryRadius")).clear();
		driver.findElement(By.id("deliveryRadius")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		// Tipos de Tempo de Atendimento
		new Select(driver.findElement(By.id("serviceTimeType_id"))).selectByIndex(2);
		// Tipos de Janela de Atendimento
		new Select(driver.findElement(By.id("timeWindowType_id"))).selectByIndex(1);
		// Tempo de Atendimento Específico do Cliente
		driver.findElement(By.id("helperFixedTimeSecs")).clear();
		driver.findElement(By.id("helperFixedTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("helperVarTimeSecs")).clear();
		driver.findElement(By.id("helperVarTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("nonHelperFixedTimeSecs")).clear();
		driver.findElement(By.id("nonHelperFixedTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		driver.findElement(By.id("nonHelperVarTimeSecs")).clear();
		driver.findElement(By.id("nonHelperVarTimeSecs")).sendKeys("" + (int) Math.floor(Math.random() * 100));
		// Instruções
		driver.findElement(By.id("deliveryInstructions")).clear();
		driver.findElement(By.id("deliveryInstructions")).sendKeys("Instructions_" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("fixedCost")).clear();
		driver.findElement(By.id("fixedCost")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("perSize1Rate")).clear();
		driver.findElement(By.id("perSize1Rate")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
		driver.findElement(By.id("btn_save")).click();

		// Excluir Localidades
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
		driver.findElement(By.id("searchFilter")).sendKeys(localeKey);
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
