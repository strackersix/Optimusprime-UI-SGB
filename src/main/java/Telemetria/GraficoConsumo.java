package Telemetria;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class GraficoConsumo extends BasePage {

	public void Go () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		MinhaConta();
		Telemetria();
		GrupoEconomico("POWERVIEW BALANCO");
		Empresa("POWERVIEW BALANCO");
		Unidade("POWERVIEW BALANCO UNID 1");
		Periodo("Nov", "2019");
		WaitDashboard();
		PageDown();		
		
		Assert.assertEquals("01/11 01:…", ConsumoDia1());
		Assert.assertEquals("07/11 22:00", ConsumoDia7());
		
	}
	
	public void Url ( String url ) {
		
		driver.get(url);
		
	}
	
	public void MinhaConta () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")));
		driver.findElement(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")).click();
	
	}
	
	public void Telemetria () throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li/a[@href=\"/telemetria/medicao\"])[2]")).click();
		
	}	
	
	public void GrupoEconomico ( String grupoEconomico ) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class = 'SelectInput__placeholder'])[1]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class = 'SelectInput__placeholder'])[1]")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).clear();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).sendKeys(grupoEconomico);
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class ='SelectItemGroup__ul'])[1]")));
		Thread.sleep(500);
		driver.findElement(By.xpath("(//ul[@class ='SelectItemGroup__ul'])[1]")).click();
				
	}
	
	public void Empresa ( String empresa ) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class = 'SelectInput__content'])[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).clear();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).sendKeys(empresa);
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li[@class = 'SelectItemGroup__ul__li'])[2]")));
		Thread.sleep(500);
		driver.findElement(By.xpath("(//ul/li[@class = 'SelectItemGroup__ul__li'])[2]")).click();
				
	}
	
	public void Unidade ( String unidade ) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class = 'SelectInput__content'])[3]")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).clear();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).sendKeys(unidade);
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class = 'SelectItemGroup__ul'])[3]")));
		Thread.sleep(500);
		driver.findElement(By.xpath("(//ul[@class = 'SelectItemGroup__ul'])[3]")).click();

	}
		
	public void Periodo ( String mes, String ano ) {
		
		driver.findElement(By.xpath("//div[@class = 'datepicker']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'mx-btn mx-btn-text mx-btn-icon-double-left']")));
		String AnoDisponivel = driver.findElement(By.xpath("//button[@class = 'mx-btn mx-btn-text']")).getText();
		
		if (!AnoDisponivel.equalsIgnoreCase(ano)) {
			
			do {
				driver.findElement(By.xpath("//button[@class = 'mx-btn mx-btn-text mx-btn-icon-double-left']")).click();
				AnoDisponivel = driver.findElement(By.xpath("//button[@class = 'mx-btn mx-btn-text']")).getText();
			} while (!AnoDisponivel.equalsIgnoreCase(ano));			

		}

		driver.findElement(By.xpath("//table[@class = 'mx-table mx-table-month']/tr/td/div[text() = '"+mes+"' ]")).click();
		
	}
		
	public void WaitDashboard () throws InterruptedException {
						
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class = 'numeric-measurement']/span)[1]")));
		Thread.sleep(5000);
		
	}
	
	public void PageDown () {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy (0, 100)");
		
	}
			
	public String ConsumoDia1 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[2]/*/*[text() = '01/11 01:…']")));
		return driver.findElement(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[2]/*/*[text() = '01/11 01:…']")).getText();
				
	}
			
	public String ConsumoDia7 () {
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[2]/*/*[text() = '07/11 22:00']")));
		return driver.findElement(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[2]/*/*[text() = '07/11 22:00']")).getText();
				
	}	

	public void BugArquivoTXT () {
		
		LerArquivoTXT(TestGraficoConsumo.BugArquivoTXT);
		
	}
	
	
}
