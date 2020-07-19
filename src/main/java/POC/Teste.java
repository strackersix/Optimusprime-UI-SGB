package POC;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.DriverFactory;
import _CORE.Parametros;

public class Teste extends DriverFactory {

	@Test
	public void NewRelic() throws InterruptedException, IOException {

		// Url
		driver.manage().window().maximize();
		driver.get("https://login.newrelic.com/login");
		
		//login
		driver.findElement(By.id("login_email")).sendKeys("gabriel.souza@doc88.com.br");
		driver.findElement(By.id("login_password")).sendKeys("G@briel@123456");
		driver.findElement(By.id("login_submit")).click();
		
		//powerview-QA
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class = 'app_name']/a[text() = 'Powerview - QA']")));
		driver.findElement(By.xpath("//td[@class = 'app_name']/a[text() = 'Powerview - QA']")).click();
		
		//Events - Errors
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class = 'second_level'])[2]/li[2]/a")));
		driver.findElement(By.xpath("(//ul[@class = 'second_level'])[2]/li[2]/a")).click();
		
		//First
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class = 'second_level'])[2]/li[2]/a")));
		driver.findElement(By.xpath("//table[@id = 'errors']/thead/tr/th[1]")).click();
		Thread.sleep(1000);
		
		//Acessar ultimo erro. 
		driver.findElement(By.xpath("(//tbody)[1]/tr[1]/td[5]/a")).click();
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class = 'action_bar clearfix']/li/a)[1]")));		
				
		// Screeshot
		Thread.sleep(2000);
		WebDriver augmentedDriver = new Augmenter().augment(driver);
	    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File( Parametros.DiretorioScreenshot + File.separator + "EVIDENCIA.jpg"));
		
			
	}

}
