package Certificado;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class Framework extends BasePage {
	
	
	public void GoTestGerarCertificadoPDFConsolidado () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		MinhaConta();
		Certificados();
		PageDown();
		GerarCertificadoOuRelatorio();
		GrupoEconomico("POWERVIEW BALANCO");
		AnoCertificado("2019");
		IncluirRelatorio();
		PortuguesIngles();
		GerarCertificadoPDF();
		WaitGerandoKitCertificado();
		
		Assert.assertEquals("Kit gerado com sucesso", ValidaCertificadoPDF());
		
		Ok();
		
	}
	
	public void Url ( String url ) {
		
		driver.get(url);
		
	}
	
	public void MinhaConta () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")));
		driver.findElement(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")).click();
	
	}
	
	public void Certificados () {
		
		driver.findElement(By.xpath("(//ul[@class = 'dropdown-menu'])[2]/li/a[@href = '/certificates']")).click();
		
	}
	
	public void PageDown () {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy  (0, 1000 )");
		
	}
	
	public void GerarCertificadoOuRelatorio () {
		
		driver.findElement(By.xpath("//ul/li/a[@class = 'item-list-container js-request-certificate']")).click();
				
	}
	
	public void GrupoEconomico ( String grupoEconomico ) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'token-input-be-user-main-group']")));
		driver.findElement(By.xpath("//input[@id = 'token-input-be-user-main-group']")).sendKeys(grupoEconomico);

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class = 'token-input-dropdown-facebook'])[1]/*")));
		
		String BuscandoAguarde = driver.findElement(By.xpath("(//div[@class = 'token-input-dropdown-facebook'])[1]/*")).getText();
		int count = 0;
		int TimeOut = 60;	
		
		while (BuscandoAguarde.equalsIgnoreCase("Buscando, aguarde...")) {

			BuscandoAguarde = driver.findElement(By.xpath("(//div[@class = 'token-input-dropdown-facebook'])[1]/*")).getText();
			Thread.sleep(1000);
			--TimeOut;
			System.out.println("Faltam: " + TimeOut + " segundos para reprovar o teste.");
			
			if (TimeOut == 0) {
								
				Assert.fail("O grupo econômico não foi caregado durante 60 segundos conforme o esperado.");
				
			}
			
		}
		
		driver.findElement(By.xpath("//input[@id = 'token-input-be-user-main-group']")).sendKeys(Keys.ENTER);
			
	}
	
	public void AnoCertificado ( String anoCertificado ) {
		
		WebElement element = driver.findElement(By.xpath("//select[@class = 'select_years form-control']"));
		Select select = new Select(element);
		select.selectByVisibleText(anoCertificado);
		
	}
	
	public void IncluirRelatorio () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'report']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id = 'report']")).click();
		
	}
	
	public void PortuguesIngles () {
		
		driver.findElement(By.xpath("//input[@id = 'language_all']")).click();
		
	}
	
	public void GerarCertificadoPDF () {
		
		driver.findElement(By.xpath("//button[@id = 'certificate-make']")).click();
		
	}
	
	public void WaitGerandoKitCertificado () throws InterruptedException {
		
		String text = driver.findElement(By.xpath("//h2[@id = 'swal2-title'][text() = 'Gerando kit Certificado']")).getText();
		int TimeOut = 60;	
			
		try {
		
			while (text.equalsIgnoreCase("Gerando kit Certificado")) {
	
				text = driver.findElement(By.xpath("//h2[@id = 'swal2-title'][text() = 'Gerando kit Certificado']")).getText();
				--TimeOut;
				Thread.sleep(1000);
				
				if (TimeOut == 0) {
					
					Assert.fail("Demorou mais de 60 segundos para gerar o Certificado.");
				}
					
			}
		
		} catch (Exception e) {

		}
		
	}
	
	public String ValidaCertificadoPDF () {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@id = 'swal2-title']")));
		return driver.findElement(By.xpath("//h2[@id = 'swal2-title']")).getText();
		
	}
	
	public void Ok () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'swal2-confirm swal2-styled']")));
		driver.findElement(By.xpath("//button[@class = 'swal2-confirm swal2-styled']")).click();
		
	}

	public void BugArquivoTXT () {
		
		LerArquivoTXT(TestGerarCertificadoPDFConsolidado.BugArquivoTXT);
		
	}
	
}
