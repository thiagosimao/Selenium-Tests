package seguranca;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Usuario {
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
	public void testUsuario() throws Exception {
		driver.get("http://gmqualidade.greenmile.com");
		driver.findElement(By.id("login_username")).sendKeys("selenium-test");
		driver.findElement(By.id("login_password")).sendKeys("123");
		driver.findElement(By.id("btn_sign_in")).click();
		
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

		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/ul/li[4]/ul/li/a")).click();
		
		// Adicionar Usuário
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.id("btn_novo"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.id("btn_novo")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.id("btn_save"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Informações Gerais
	    String userKey = "User_"+ (int) Math.floor(Math.random() * 1000);
	    driver.findElement(By.id("key")).clear();
	    driver.findElement(By.id("key")).sendKeys(userKey);
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(userKey);
	    driver.findElement(By.id("login")).clear();
	    driver.findElement(By.id("login")).sendKeys(userKey);
	    driver.findElement(By.xpath("//div[2]/div[3]/div/div[4]/div/div")).click();
	    driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
	    driver.findElement(By.id("adpFileNumber")).clear();
	    driver.findElement(By.id("adpFileNumber")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
	    driver.findElement(By.xpath("//div[2]/div[4]/div/div[3]/div/div")).click();
	    driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
	    new Select(driver.findElement(By.id("unitSystem"))).selectByIndex(1);
	    // Dados de Contato
	    driver.findElement(By.id("phone1")).clear();
	    driver.findElement(By.id("phone1")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
	    driver.findElement(By.id("phone2")).clear();
	    driver.findElement(By.id("phone2")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("email" + (int) Math.floor(Math.random() * 1000) + "@email.com");
	    new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(1);
	    new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(1);
	    // Endereço
	    driver.findElement(By.id("addressLine1")).clear();
	    driver.findElement(By.id("addressLine1")).sendKeys("Address_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("addressLine2")).clear();
	    driver.findElement(By.id("addressLine2")).sendKeys("Complement_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("City_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("zipCode")).clear();
	    driver.findElement(By.id("zipCode")).sendKeys("" + (int) Math.floor(Math.random() * 10000000));
	    driver.findElement(By.id("district")).clear();
	    driver.findElement(By.id("district")).sendKeys("District_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("state")).clear();
	    driver.findElement(By.id("state")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
	    driver.findElement(By.id("country")).clear();
	    driver.findElement(By.id("country")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
	    // Geocodificação
	    driver.findElement(By.id("latitude")).clear();
	    driver.findElement(By.id("latitude")).sendKeys("" + (int) Math.floor(Math.random() * 1000000000));
	    driver.findElement(By.id("longitude")).clear();
	    driver.findElement(By.id("longitude")).sendKeys("" + (int) Math.floor(Math.random() * 1000000000));
	    driver.findElement(By.id("geocodingQuality")).clear();
	    driver.findElement(By.id("geocodingQuality")).sendKeys("" + (int) Math.floor(Math.random() * 5 + 1));
	    // Segurança
	    new Select(driver.findElement(By.id("organizations.organization_id"))).selectByIndex(0);
	    new Select(driver.findElement(By.id("groups_id"))).selectByIndex(0);
	    driver.findElement(By.id("btn_save")).click();
	    
	    // Editar Usuário
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.id("btn_novo"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.id("searchFilter")).clear();
	    driver.findElement(By.id("searchFilter")).sendKeys(userKey);
	    // Warning: waitForTextPresent may require manual changes
	    Thread.sleep(3000);
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("a.table-action-editlink")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.id("btn_save"))) break; } catch (Exception e) {}
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
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("");
	    driver.findElement(By.id("preferedLocale_description")).clear();
	    driver.findElement(By.id("preferedLocale_description")).sendKeys("");
	    new Select(driver.findElement(By.id("unitSystem"))).selectByIndex(0);
	    driver.findElement(By.id("phone1")).clear();
	    driver.findElement(By.id("phone1")).sendKeys("");
	    driver.findElement(By.id("phone2")).clear();
	    driver.findElement(By.id("phone2")).sendKeys("");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("");
	    new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(0);
	    new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(0);
	    driver.findElement(By.id("addressLine1")).clear();
	    driver.findElement(By.id("addressLine1")).sendKeys("");
	    driver.findElement(By.id("addressLine2")).clear();
	    driver.findElement(By.id("addressLine2")).sendKeys("");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("");
	    driver.findElement(By.id("zipCode")).clear();
	    driver.findElement(By.id("zipCode")).sendKeys("");
	    driver.findElement(By.id("district")).clear();
	    driver.findElement(By.id("district")).sendKeys("");
	    driver.findElement(By.id("state")).clear();
	    driver.findElement(By.id("state")).sendKeys("");
	    driver.findElement(By.id("country")).clear();
	    driver.findElement(By.id("country")).sendKeys("");
	    driver.findElement(By.id("latitude")).clear();
	    driver.findElement(By.id("latitude")).sendKeys("");
	    driver.findElement(By.id("longitude")).clear();
	    driver.findElement(By.id("longitude")).sendKeys("");
	    driver.findElement(By.id("geocodingQuality")).clear();
	    driver.findElement(By.id("geocodingQuality")).sendKeys("");
	    // Adicionar Dados
	    // Informações Gerais
	    userKey = "User_"+ (int) Math.floor(Math.random() * 1000);
	    driver.findElement(By.id("key")).clear();
	    driver.findElement(By.id("key")).sendKeys(userKey);
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(userKey);
	    driver.findElement(By.xpath("//div[2]/div[3]/div/div[4]/div/div")).click();
	    driver.findElement(By.xpath("//html/body/ul[5]/li/a")).click();
	    driver.findElement(By.id("adpFileNumber")).clear();
	    driver.findElement(By.id("adpFileNumber")).sendKeys("" + (int) Math.floor(Math.random() * 1000));
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
	    driver.findElement(By.xpath("//div[2]/div[4]/div/div[3]/div/div")).click();
	    driver.findElement(By.xpath("//html/body/ul[6]/li/a")).click();
	    new Select(driver.findElement(By.id("unitSystem"))).selectByIndex(1);
	    // Dados de Contato
	    driver.findElement(By.id("phone1")).clear();
	    driver.findElement(By.id("phone1")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
	    driver.findElement(By.id("phone2")).clear();
	    driver.findElement(By.id("phone2")).sendKeys("" + (int) Math.floor(Math.random() * 100000000));
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("email" + (int) Math.floor(Math.random() * 1000) + "@email.com");
	    new Select(driver.findElement(By.id("phone1Type"))).selectByIndex(1);
	    new Select(driver.findElement(By.id("phone2Type"))).selectByIndex(1);
	    // Endereço
	    driver.findElement(By.id("addressLine1")).clear();
	    driver.findElement(By.id("addressLine1")).sendKeys("Address_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("addressLine2")).clear();
	    driver.findElement(By.id("addressLine2")).sendKeys("Complement_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("City_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("zipCode")).clear();
	    driver.findElement(By.id("zipCode")).sendKeys("" + (int) Math.floor(Math.random() * 10000000));
	    driver.findElement(By.id("district")).clear();
	    driver.findElement(By.id("district")).sendKeys("District_" + (int) Math.floor(Math.random() * 100));
	    driver.findElement(By.id("state")).clear();
	    driver.findElement(By.id("state")).sendKeys("" + (int) Math.floor(Math.random() * 10000));
	    driver.findElement(By.id("country")).clear();
	    driver.findElement(By.id("country")).sendKeys("" + (int) Math.floor(Math.random() * 100000));
	    // Geocodificação
	    driver.findElement(By.id("latitude")).clear();
	    driver.findElement(By.id("latitude")).sendKeys("" + (int) Math.floor(Math.random() * 1000000000));
	    driver.findElement(By.id("longitude")).clear();
	    driver.findElement(By.id("longitude")).sendKeys("" + (int) Math.floor(Math.random() * 1000000000));
	    driver.findElement(By.id("geocodingQuality")).clear();
	    driver.findElement(By.id("geocodingQuality")).sendKeys("" + (int) Math.floor(Math.random() * 5 + 1));
	    // Segurança
	    new Select(driver.findElement(By.id("organizations.organization_id"))).selectByIndex(0);
	    new Select(driver.findElement(By.id("groups_id"))).selectByIndex(0);
	    driver.findElement(By.id("btn_save")).click();
	    
	 // Excluir Usuário
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.id("btn_novo"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.id("searchFilter")).clear();
	    driver.findElement(By.id("searchFilter")).sendKeys(userKey);
	    // Warning: waitForTextPresent may require manual changes
	    Thread.sleep(3000);
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("span.slick-column-name > input[type=\"checkbox\"]")).click();
	    driver.findElement(By.id("buttonEventCheckBox")).click();
	    String  a = closeAlertAndGetItsText();
	    driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/ul/li[2]/span[2]")).click();
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