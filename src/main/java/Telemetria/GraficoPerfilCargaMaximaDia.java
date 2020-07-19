package Telemetria;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class GraficoPerfilCargaMaximaDia extends BasePage {
		
		
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
		MaximaDia();
		
		Assert.assertEquals("2019-11-01" + "\n" + 
							"2019-11-06" + "\n" + 
							"2019-11-11" + "\n" + 
							"2019-11-16" + "\n" + 
							"2019-11-21" + "\n" + 
							"2019-11-26", ValidaGraficoPerfilCargaMes());
		
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
			robot.keyPress(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_J);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_D);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_P);
			Thread.sleep(1000);
			
			int count = 7;
			while (count != 0) {
			
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				--count;
				
			}
			
			Thread.sleep(1000);
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
			robot.keyPress(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_J);

		} catch (AWTException e) {

			e.printStackTrace();
			
		}
		
	}
	
	public void GrupoEconomico ( String grupoEconomico ) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class = 'f-icon SelectInput__placeholderIcon'])[1]")));
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
	
	public String PerfilCargaDia1 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[1]/*/*[text() = '01/11 0…']")));
		return driver.findElement(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[1]/*/*[text() = '01/11 0…']")).getText();
				
	}
			
	public String PerfilCargaDia7 () {
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[1]/*/*[text() = '01/11 0…']/../../*/*[text() = '07/11 21:15']")));
		return driver.findElement(By.xpath("(//*[@class = 'highcharts-axis-labels highcharts-xaxis-labels'])[1]/*/*[text() = '01/11 0…']/../../*/*[text() = '07/11 21:15']")).getText();
				
	}
	
	public void MaximaDia () throws InterruptedException {
		 
		driver.findElement(By.xpath("(//label[@class = 'f-checkbox__wrapper'])[1]")).click();
		Thread.sleep(2000);
								
	}
	
	public void PeriodoMes ( String dataInicio , String dataFim  ) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class = 'mx-datepicker mx-datepicker-range'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class = 'mx-table mx-table-date']/tbody/tr/td[@class = 'cell active']/div[text() = '"+dataInicio+"']/..")).click();
		driver.findElement(By.xpath("//table[@class = 'mx-table mx-table-date']/tbody/tr/td[@class = 'cell']/div[text() = '"+dataFim+"']/..")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class = 'BaseChart__Content']/div)[1][@class = 'highcharts-container ']")));
				
	}

	public String ValidaGraficoPerfilCargaMes () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div/div/div/div/div[@class = 'mx-datepicker mx-datepicker-range disabled']/../../../../../../../*[2]/div/div/div/div/*[1]/*[21]")));
		return driver.findElement(By.xpath("//div/div/div/div/div/div/div[@class = 'mx-datepicker mx-datepicker-range disabled']/../../../../../../../*[2]/div/div/div/div/*[1]/*[21]")).getText();
		
	}
	
	public void BugArquivoTXT () {
		
		LerArquivoTXT(TestGraficoPerfilCargaMaximaDia.BugArquivoTXT);
		
	}
	
}
