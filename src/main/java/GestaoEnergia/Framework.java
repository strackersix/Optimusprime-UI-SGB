package GestaoEnergia;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GestaoEnergia.TestUsuarioExternoSemGrupoEconomicoGestaoEnergia;
import _CORE.BasePage;
import _CORE.Parametros;

public class Framework extends BasePage {
	
	
	public void Go () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		UsuarioLogado();
		Sair();
		Usuario("usuarioexterno5@gmail.com");
		Senha("Doc@123456");
		Acessar();
		
		Url(Parametros.UrlGestaoEnergia);
		
		GrupoEconomico("POWERVIEW BALANCO");
		Assert.assertEquals("No data", ValidaGrupoEconomico());
				
		Url(Parametros.UrlPowerView);
		UsuarioLogado();
		Sair();
		Usuario(Parametros.UsuarioPowerView);
		Senha(Parametros.SenhaPowerView);
		Acessar();
				
	}
	
	
	public void Url ( String url  ) {
		
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	public void UsuarioLogado () {
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id = 'dropdown-user']")));
		driver.findElement(By.xpath("//button[@id = 'dropdown-user']")).click();
		
	}
	
	public void Sair () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/a/form)[1]")));
		driver.findElement(By.xpath("(//li/a/form)[1]")).click();
		
	}
	
	public void Usuario ( String usuario ) {
		
		driver.findElement(By.xpath("//div/input[@name = 'login']")).clear();
		driver.findElement(By.xpath("//div/input[@name = 'login']")).sendKeys(usuario);
		
	}
	
	public void Senha ( String senha ) {
		
		driver.findElement(By.xpath("//div/input[@name = 'password']")).clear();
		driver.findElement(By.xpath("//div/input[@name = 'password']")).sendKeys(senha);
		
	}
	
	public void Acessar () {
		
		driver.findElement(By.xpath("//button[@id = 'be-login']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[@class = 'dropdown-toggle']")));
		
	}
	
	public void GrupoEconomico ( String grupoEconomico ) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/button[@class = 'btn-select'])[1]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div/button[@class = 'btn-select'])[1]")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div/button[@class = 'btn-select'])[1]")));
		driver.findElement(By.xpath("(//div/input[@class = 'inputFilter'])[1]")).sendKeys(grupoEconomico);
		Thread.sleep(2000);
				
	}
	
	public String ValidaGrupoEconomico () {
		
		String variavel;
		
		variavel = driver.findElement(By.xpath("//div[@class = 'empty-tab']")).getText();
		return variavel;
	}
	
	public void LerArquivoTXT () throws IOException {
		
		LerArquivoTXT(TestUsuarioExternoSemGrupoEconomicoGestaoEnergia.BugArquivoTXT);
		
	}
	
	

}
