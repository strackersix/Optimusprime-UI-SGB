package Dashmaker;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class Framework extends BasePage {

	
	public void Go () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		MeuUsuario();
		Dashmaker();
		BtnDashMaker();
		Titulo("Quality Assurance.");
		
	}
	
	public void Url(String url) {

		driver.get(url);

	}

	public void MeuUsuario() {

		driver.findElement(By.xpath("//button[@id = 'dropdown-user']")).click();
		
	}

	public void Dashmaker() {

		driver.findElement(By.xpath("(//li[@role = 'presentation'])[14]")).click();

	}

	public void BtnDashMaker () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class = 'btn btn-success btn-add pull-left'])[1]")));
		driver.findElement(By.xpath("(//button[@class = 'btn btn-success btn-add pull-left'])[1]")).click();
		
	}
	
	public void Titulo ( String titulo) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name = 'title'])[3]")));
		driver.findElement(By.xpath("(//input[@name = 'title'])[3]")).sendKeys(titulo);
		
	}

	public void BugArquivoTXT () {
		
		LerArquivoTXT(TestNovoDashmaker.BugArquivoTXT);
		
	}
	
	
}
