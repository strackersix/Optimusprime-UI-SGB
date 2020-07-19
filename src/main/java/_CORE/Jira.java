package _CORE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Jira extends DriverFactory {
	

// --------------------------------------------------------------- <<< Cadastrar Bug Jira >>> -----------------------------------------------------------------//	
	
	public void TerrorDoDev () throws InterruptedException {
		
		Screenshot();
		UrlJira(Parametros.UrlJira);
		IncluirTask();
		Projeto(Parametros.ProjetoPowerView);
		TipoItem(Parametros.TipoItem);
		Resumo("");
		Descricao("");
		Ambiente(Parametros.Ambiente);
		Upload();
		Criar();
		GravarBugArquivoTXT("");
				
	}
	
//--------------------------- <<< Verifica se o Bug já está disponível com status: ( Qualidade ) para que possa ser retestado. >>> ----------------------------//
	
	public void VerificaStatusBug () throws InterruptedException {
		
		UrlJira(Parametros.UrlJira);
		PesquisarTask("");
		AcessarBug();
		CapturarStatusBug();
				
	}
	
// ------------------------------------------ <<< Aprovar o Bug no Jira caso o mesmo tenha sido aprovado após reteste >>> -------------------------------------//	

	public void Aprovado () throws InterruptedException {
		
		UrlJira(Parametros.UrlJira);
		PesquisarTask("");
		AcessarBug();
		FinalizarBug();
		ComentarioAprovado();
		FinalizarBugArquivoTXT("");
		Close();
				
	}
			
// ----------------------------------------------------------------- <<< Reprovar Bug Jira >>> -----------------------------------------------------------------//

	public void Reprovado () throws InterruptedException {
		
		UrlJira(Parametros.UrlJira);
		PesquisarTask("");
		AcessarBug();
		ReprovarBug();
		ComentarioReprovado();
		Close();
		
	}
		
// --------------------------------------------------------------------------------------------------------------------------------------------------------//	
	
	public void UrlJira ( String UrlJira ) {
		
		driver.get(UrlJira);
		
	}
	
	public void Maximizar () {
		
		driver.manage().window().maximize();
		
	}
	
	public void Usuario ( String usuario ) {
				
		driver.findElement(By.id("username")).sendKeys(usuario);
		
	}
				
	public void Senha ( String senha ) {
		
		driver.findElement(By.id("login-submit")).click();
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		driver.findElement(By.id("password")).sendKeys(senha);
		
	}
			
	public void Entrar () {
		
		driver.findElement(By.id("login-submit")).click();
		
	}

	public void IncluirTask () {
		
		WebDriverWait wait2 = new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("createGlobalItem")));
		driver.findElement(By.id("createGlobalItem")).click();;
		
	}
	
	public void Projeto ( String projeto ) {
		
		WebDriverWait wait3 = new WebDriverWait(driver,20);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'create-issue-submit']")));
		driver.findElement(By.xpath("(//div/span[@class = 'icon aui-ss-icon noloading drop-menu'])[1]")).click();
		driver.findElement(By.xpath("//input[@id = 'project-field']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@id = 'project-field']")).sendKeys(projeto);
		driver.findElement(By.xpath("//input[@id = 'project-field']")).sendKeys(Keys.ENTER);
		
	}
	
	public void TipoItem ( String tipoItem ) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div/span[@class = 'icon aui-ss-icon noloading drop-menu'])[2]")));
		driver.findElement(By.xpath("(//div/span[@class = 'icon aui-ss-icon noloading drop-menu'])[2]")).click();
		driver.findElement(By.xpath("//div/input[@id = 'issuetype-field']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//div/input[@id = 'issuetype-field']")).sendKeys(tipoItem);
		driver.findElement(By.xpath("//div/input[@id = 'issuetype-field']")).sendKeys(Keys.ENTER);
		
	}

	public void Resumo (String resumo ) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'summary']")));
		driver.findElement(By.xpath("//input[@id = 'summary']")).sendKeys(resumo);
		
	}

	public void Upload () throws InterruptedException {
		
		WebElement UploadArquivo = driver.findElement(By.xpath("//div/span/input[@type = 'file']"));
		UploadArquivo.sendKeys(Parametros.DiretorioUploaEvidencia);
		Thread.sleep(4000);
		
	}
					
	public void Descricao (String descricao ) {
		
		driver.findElement(By.xpath("//textarea[@id=\"description\"]")).sendKeys(descricao);
		
	}
	
	public void Ambiente (String ambiente ) {
		
		driver.findElement(By.xpath("//textarea[@id = 'environment']")).sendKeys(ambiente);
		
	}
	
	public void Sprint (String sprint ) throws InterruptedException {
		
		WebElement Xpath2 = driver.findElement(By.xpath("//div/input[@id = 'customfield_10018-field']"));
		Actions Sprint = new Actions(driver).click(Xpath2);
		Sprint.build().perform();
		driver.findElement(By.xpath("//div/input[@id = 'customfield_10018-field']")).click();
		driver.findElement(By.xpath("//div/input[@id = 'customfield_10018-field']")).sendKeys(sprint);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/input[@id = 'customfield_10018-field']")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
	}
			
	public void Criar () throws InterruptedException {
		
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'create-issue-submit']")));
		driver.findElement(By.xpath("//input[@id = 'create-issue-submit']")).click();
		Thread.sleep(5000);
		
	}
	
	public void AtualizarNavegador () throws InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		
	}
			
	public void GravarBugArquivoTXT ( String gravarBugArquivoTXT ) {

		try {
			
			File Diretorio = new File(gravarBugArquivoTXT);
			FileWriter existeBug = new FileWriter(Diretorio, false);
										
			existeBug.write("true");
			existeBug.close();
						
		} catch (Exception e) {
	
			e.printStackTrace();
			
		}

	}
	
	public void Screenshot () throws InterruptedException {
		
		try {
		
			Thread.sleep(2000);
			WebDriver augmentedDriver = new Augmenter().augment(driver);
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(screenshot, new File( Parametros.DiretorioScreenshot + File.separator + "EVIDENCIA.jpg"));
	    
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
	public String CapturarStatusBug ()  {
				
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-test-id='issue.views.issue-base.foundation.status.status-field-wrapper']//button[@type = 'button']/span/span)[1]")));
		
		try {
			
			String Xpath = driver.findElement(By.xpath("(//div[@data-test-id='issue.views.issue-base.foundation.status.status-field-wrapper']//button[@type = 'button']/span/span)[1]")).getText();
			Parametros.statusBug = Xpath;
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return Parametros.statusBug;
		
	}

	public void PesquisarTask ( String PesquisarTask ) throws InterruptedException {
		
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/form/input[@id = 'search-field-input']")));
		driver.findElement(By.xpath("//li/form/input[@id = 'search-field-input']")).sendKeys(PesquisarTask);
		Thread.sleep(2000);
				
	}
	
	public void AcessarBug () throws InterruptedException {
		
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class = 'ghx-summary']")));
		driver.findElement(By.xpath("//section[@class = 'ghx-summary']")).click();
				
	}
	
	public void ReprovarBug () throws InterruptedException {
				
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'elro8wh2 css-1onaru6']")));
		driver.findElement(By.xpath("//button[@class = 'elro8wh2 css-1onaru6']")).click();
		WebDriverWait wait5 = new WebDriverWait(driver, 10);
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span/span[text() = 'Devolvido']")));
		driver.findElement(By.xpath("//div/span/span[text() = 'Devolvido']")).click();
		
	}
		
	public void ComentarioReprovado () throws InterruptedException {
		
		driver.findElement(By.xpath("//div/input[@placeholder = 'Adicionar comentário...']")).click();
		driver.findElement(By.xpath("//div[@contenteditable='true']/p")).sendKeys("<<< Retestado >>>" + "\n" + "Caso de teste Reprovado." + "\n" + "Em caso de dúvidas favor contatar a equipe de QA.");
		driver.findElement(By.xpath("//button[@data-testid = 'comment-save-button']")).click();
		Thread.sleep(2000);
		
	}

	public void FinalizarBug () {
		
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'elro8wh2 css-1onaru6']")));
		driver.findElement(By.xpath("//button[@class = 'elro8wh2 css-1onaru6']")).click();
		WebDriverWait wait5 = new WebDriverWait(driver, 10);
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span/span[text() = 'Finalizado']")));
		driver.findElement(By.xpath("//div/span/span[text() = 'Finalizado']")).click();
		
	}
		
	public void FinalizarBugArquivoTXT ( String finalizarBugArquivoTXT ) {

		try {
		
			File Diretorio = new File(finalizarBugArquivoTXT);
			FileWriter existeBug = new FileWriter(Diretorio, false);
										
			existeBug.write("false");
			existeBug.close();
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}

	}
	
	public void ComentarioAprovado () throws InterruptedException {
		
		driver.findElement(By.xpath("//div/input[@placeholder = 'Adicionar comentário...']")).click();
		driver.findElement(By.xpath("//div[@contenteditable='true']/p")).sendKeys("<<< Retestado >>>" + "\n" + "Caso de teste Aprovado.");
		driver.findElement(By.xpath("//button[@data-testid = 'comment-save-button']")).click();
		Thread.sleep(2000);
		
	}
	
	public void Close () throws InterruptedException {
		
		driver.findElement(By.xpath("//span[@aria-label='Fechar']")).click();
		Thread.sleep(1000);
		
	}
	
	public void ScreeshotNewRelic () throws InterruptedException, IOException {
		
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
