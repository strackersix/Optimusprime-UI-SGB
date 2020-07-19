package _UnitTest_Base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import _CORE.DriverFactory;

public class Testes extends DriverFactory {
		

	String diretorio = "C:\\Automacao\\Evidencias";
	String descricaoSchreenshot = "TestLogin_" + "random.";
	public void Screenshot () throws InterruptedException {
		
		try {
		
			Thread.sleep(2000);
			WebDriver augmentedDriver = new Augmenter().augment(driver);
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(screenshot, new File( diretorio + File.separator + descricaoSchreenshot));
	    
		} catch (Exception e) {

			Assert.fail("Por cargas d'agua não conseguiu tirar screenshot");
			
		}
		
	}
	
	
}
