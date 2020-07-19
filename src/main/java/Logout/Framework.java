package Logout;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class Framework extends BasePage {

	
	public void GoLogout () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		UsuarioLogado();
		Sair();
		
		Assert.assertEquals("Acessar Blue PowerView", ValidacaoLogout());
			
	}
	
	public void Url ( String url ) {
		
		driver.get(url);
		
	}
	
	public void UsuarioLogado() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id = 'dropdown-user']")));
		driver.findElement(By.xpath("//button[@id = 'dropdown-user']")).click();
						
	}
	
	public void Sair() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id = 'dropdown-user']")));
		WebElement element = driver.findElement(By.xpath("(//li/a[@role = 'menuitem']/form)[1]/span"));
		Actions click = new Actions(driver).click(element);
		click.build().perform();
		
	}
		
	public String ValidacaoLogout () {
				
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id = 'be-login']")));		
		return driver.findElement(By.xpath("//button[@id = 'be-login']")).getText();
	
	}
	
	public void F11 () {
		
		try {
			
			Robot robot = new Robot();
			
			robot.keyPress(KeyEvent.VK_F11);
			robot.keyRelease(KeyEvent.VK_F11);
			
		} catch (AWTException e) {

		}
		
	}
	
	public void LerArquivoTXT () throws IOException {
				
		LerArquivoTXT(TestLogout.BugArquivoTXT);
		
	}
	

	
	
}







