package Login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class Framework extends BasePage {

	
	public void GoLogin () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		Usuario(Parametros.UsuarioPowerView);
		Senha(Parametros.SenhaPowerView);
		BtnAcessar();

		Assert.assertEquals("Gabriel Oliveira Conrado de Souza", ConfirmaNome());
		PermitirNotificacoes();
		
	}
	
	public void TrocarMonitor () {
		
		try {
		
			Robot robot = new Robot();
			
			robot.keyPress(KeyEvent.VK_WINDOWS);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_LEFT);
			robot.keyRelease(KeyEvent.VK_WINDOWS);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_LEFT);
		
		} catch (AWTException e) {
						
		}
			
	}
	
	public void Url ( String Url ) throws InterruptedException {

		driver.manage().window().maximize();
		driver.get(Url);
		
	}
	
	public void F11 () {
		
		try {
			
			Robot robot = new Robot();
			
			robot.keyPress(KeyEvent.VK_F11);
			robot.keyRelease(KeyEvent.VK_F11);

		} catch (AWTException e) {

		}

		
	}

	public void Usuario(String usuario) {
		
		driver.findElement(By.name("login")).clear();
		driver.findElement(By.name("login")).sendKeys(usuario);

	}

	public void Senha(String senha) {

		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(senha);

	}

	public void BtnAcessar() throws InterruptedException {
													
		driver.findElement(By.id("be-login")).click();
		Thread.sleep(2000);
		
	}
	
	public String ConfirmaNome () {
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("be-menu-profile-name")));
		return driver.findElement(By.id("be-menu-profile-name")).getText();
		
	}
	
	public void PermitirNotificacoes () {
		
		try {
			
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {

			e.printStackTrace();
			
		}
	}

	public void LerArquivoTXT () throws IOException {
		
		LerArquivoTXT(TestLogin.BugArquivoTXT);
	
	}
	
	
	
}
