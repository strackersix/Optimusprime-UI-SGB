package Telemetria;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class CardDemandaForaPonta extends BasePage {
	
	public void Go () throws InterruptedException {
		
		String Mes = "Nov";
		String Ano = "2019";
		String GrupoEconomico_5 = "POWERVIEW BALANCO";
		String GrupoEmpresa_5 = "POWERVIEW BALANCO";
		String GrupoUnidade_5 = "POWERVIEW BALANCO UNID 1";
					
		Url(Parametros.UrlPowerView);
		MinhaConta();
		Telemetria();
		
		int count = 1; 
		int tentativa = 1;
		
		do {
						
			GrupoEconomico(GrupoEconomico_5);
			Empresa(GrupoEmpresa_5);
			Unidade(GrupoUnidade_5);
			Periodo(Mes, Ano);
			WaitDashboard();
			
			--count;
			
		} while (count != 0);
		
		Thread.sleep(3000);
		
		Assert.assertEquals("Demanda Fora Ponta" + "\n" +
				"Máxima Registrada -" + "\n" +
				"0,00 kW" + "\n" +
				"Última Leitura" + "\n" + 
				"453,12 kW" + "\n" +
				"Usado: %" + "\n" +
				"/ KW", DemandaPontaForaPonta());
				
	}
	
	
	public void Url ( String url ) {
		
		driver.get(url);
			
	}
	
	public void MinhaConta () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")));
		driver.findElement(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")).click();
	
	}
	
	public void Telemetria () {
		
		driver.findElement(By.xpath("(//li/a[@href=\"/telemetria/medicao\"])[2]")).click();
		
	}
	
	public void OpenInspecionarF12 () throws InterruptedException {
		
		try {
			
			Robot robot = new Robot();
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_I);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_P);
			Thread.sleep(2000);
			
			int count = 7;
			while (count != 0) {
			
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				--count;
				
			}
			
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			
		
		} catch (AWTException e) {

			e.printStackTrace();
			
		}
				
	}
	
	public void CloseInspecionarF12 () {
		
		try {
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_I);

		} catch (AWTException e) {

			e.printStackTrace();
			
		}
		
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
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li[@class = 'SelectItemGroup__ul__li'])[2]")));
		Thread.sleep(500);
		driver.findElement(By.xpath("(//ul/li[@class = 'SelectItemGroup__ul__li'])[2]")).click();
				
	}
	
	public void Unidade ( String unidade ) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class = 'SelectInput__content'])[3]")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).clear();
		driver.findElement(By.xpath("//input[@placeholder = 'Pesquisar']")).sendKeys(unidade);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class = 'SelectAccordion__content__inner'])[3]")));
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class = 'SelectAccordion__content__inner'])[3]")).click();

	}
		
	public void Periodo ( String mes, String ano ) {
		
		driver.findElement(By.xpath("//div[@class = 'datepicker']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
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
	
	public String DemandaPonta () {
		 
		return driver.findElement(By.xpath("(//section[@class = 'f-card demand-widget p--base br--base m-- color--background--white color--text--font-base'])[1]")).getText();
				
	}
	
	public String DemandaPontaForaPonta () throws InterruptedException {
		 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[@class = 'f-card demand-widget p--base br--base m-- color--background--white color--text--font-base'])[2]")));
		Thread.sleep(1000);
		return driver.findElement(By.xpath("(//section[@class = 'f-card demand-widget p--base br--base m-- color--background--white color--text--font-base'])[2]")).getText();
				
	}
	
	public void BuArquivoTXT () {
		
		LerArquivoTXT(TestCardDemandaForaPonta.BugArquivoTXT);
		
	}
	
	
	

}
