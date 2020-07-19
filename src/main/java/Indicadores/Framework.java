package Indicadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class Framework extends BasePage {

	public void Go () {
		
		Url(Parametros.UrlPowerView);
		MinhaConta();
		Indicadores();
		Configuracoes();
		BtnImportarPublicacoes();
		UploadArquivo();
		Enviar();
		Aguarde();		
		
	}
	
	public void Url(String url) {

		driver.get(url);

	}

	public void MinhaConta() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//li/a[@class = 'dropdown-toggle']/i[@class = 'fa fa-cog fa-fw ']/..")));
		driver.findElement(By.xpath("//li/a[@class = 'dropdown-toggle']/i[@class = 'fa fa-cog fa-fw ']/..")).click();

	}

	public void Indicadores() {

		driver.findElement(By.xpath("//li/a/span[@class = 'fa fa-sun-o fa-fw color-gray-blue']/..")).click();

	}

	public void Configuracoes() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span/i[@class = 'fa fa-download']/../..")));
		driver.findElement(By.xpath("//a/span/i[@class = 'fa fa-download']/../..")).click();

	}

	public void BtnImportarPublicacoes() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id = 'ipdo-import']")));
		driver.findElement(By.xpath("//a[@id = 'ipdo-import']")).click();

	}

	public void UploadArquivo() {

		WebElement element = driver.findElement(By.xpath("(//input[@type = 'file'])[2]"));
		element.sendKeys("C:\\Automacao\\Upload\\Indicadores\\Importação Indicadores 2020.csv");
	}

	public void Enviar() {

		driver.findElement(By.xpath("//button[@class = 'swal2-confirm swal2-styled']")).click();

	}

	public void Aguarde() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@id = 'swal2-title']")));
		String aguarde = driver.findElement(By.xpath("//h2[@id = 'swal2-title']")).getText();

		int count = 1;
		
		try {

			while (aguarde.equalsIgnoreCase("Aguarde...")) {
					
				Thread.sleep(1000);
				aguarde = driver.findElement(By.xpath("//h2[@id = 'swal2-title']")).getText();
				count++;
				System.out.println(count + " segundos de importação do relatório de Indicadores.");

			}
			
			System.out.println("\n" +  "<<< O processo de importação do relatório dos Indicadores durou: " + count + " segundos. >>>" + "\n");

		} catch (Throwable e) {
									
		}

	}
}