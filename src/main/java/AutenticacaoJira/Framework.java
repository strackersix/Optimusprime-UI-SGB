package AutenticacaoJira;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.DriverFactory;

public class Framework extends DriverFactory{
	
		
	public void UrlJira ( String UrlJira ) {
		
		driver.get(UrlJira);
		
	}
	
	public void Maximizar () {
		
		driver.manage().window().maximize();
		
	}
	
	public void Usuario ( String usuario ) {
		
		driver.findElement(By.id("username")).sendKeys(usuario);
		
	}
				
	public void Senha ( String senha ) {
		
		driver.findElement(By.id("login-submit")).click();
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		driver.findElement(By.id("password")).sendKeys(senha);
		
	}
			
	public void Entrar () {
		
		driver.findElement(By.id("login-submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button[@id = 'createGlobalItem']")));
		
	}

}
