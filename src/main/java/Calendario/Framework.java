package Calendario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

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

import _CORE.Parametros;


public class Framework extends _CORE.BasePage {
	
	
	public void Go () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		AcessarCalendario();
		NovoEvento();
		Inicio("01/01/2025");
		Termino("15/01/2025");
		TituloEvento("Test Automation Engineer");
		TipoEvento();
		DescricaoEvento("Selenium Web Driver, Java, JUnit e Maven.");
		Responsavel("Gabriel Oliveira Conrado de Souza");
		Participantes("Phelipe Bruno Cunha dos Santo");
		ParticipantesExternos();
		ReservarSala();
		Participantes();
		Servicos();
		UnidadesSala();
		Nome("Doctor Emmeet Brown");
		Rg("3112252");
		email("gabriel.souza@doc88.com.br");
		PageDown();
		Adicionar();
//		PageDown();
//		Semana();
//		SalasReuniao();
//		Convidados();
//		MeusEventos();
//		BuscarEvento("Test Automation Engineer");
//		
//		Assert.assertEquals("Test Automation Engineer", Titulo());
//		
//		EditarEvento();		
//		ExcluirEvento();
//		Sim();	
			
	}
	
	
	public void Url ( String Url ) {

		driver.manage().window().maximize();
		driver.get(Url);

	}	
	
	public void AcessarCalendario () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Calendário')])[2]")));
		driver.findElement(By.xpath("(//a[contains(text(),'Calendário')])[2]")).click();
		
	}
	
	public void NovoEvento () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-success")));
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
	}
	
	public void Inicio ( String inicio ) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("start_date")));
		driver.findElement(By.name("start_date")).clear();
		driver.findElement(By.name("start_date")).sendKeys(inicio);
			
	}
	
	public void Termino ( String termino ) {
		
		driver.findElement(By.name("end_date")).clear();
		driver.findElement(By.name("end_date")).sendKeys(termino);
		
	}
	
	public void TituloEvento ( String tituloEvento ) {
		
		driver.findElement(By.id("be-calendar-event-title")).clear();
		driver.findElement(By.id("be-calendar-event-title")).sendKeys(tituloEvento);
		
	}
	
	public void TipoEvento () {
		
		selecionarCombo(By.id("be-calendar-event-category"), "Reunião Interna");
		
	}
	
	public void DescricaoEvento ( String descricaoEvento ) {
		
		driver.findElement(By.id("be-calendar-event-description")).clear();
		driver.findElement(By.id("be-calendar-event-description")).sendKeys(descricaoEvento);
		
	}
	
	public void Responsavel ( String responsavel ) throws InterruptedException {
		
		driver.findElement(By.id("token-input-be-calendar-event-owner-id")).clear();
		driver.findElement(By.id("token-input-be-calendar-event-owner-id")).sendKeys(responsavel);
		Thread.sleep(2000);
		driver.findElement(By.id("token-input-be-calendar-event-owner-id")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	
	public void Participantes ( String participantes ) throws InterruptedException {
		
		driver.findElement(By.id("token-input-be-calendar-users")).clear();
		driver.findElement(By.id("token-input-be-calendar-users")).sendKeys(participantes);
		Thread.sleep(2000);
		driver.findElement(By.id("token-input-be-calendar-users")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
	}
	
	public void ReservarSala () throws InterruptedException {
		
		driver.findElement(By.cssSelector("#link-to-collapse-room > h2.color-lilac-dark")).click();
		Thread.sleep(500);
		
	}
	
	public void Participantes () throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@id='collapseRoom']/div/div/div/button/span)[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a/span/small[text() = 'Eu + 1'])[1]")).click();
		
	}
	
	public void Servicos () throws InterruptedException {
		
		driver.findElement(By.xpath("(//div/button/span[@class = 'filter-option pull-left'])[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li/a/span[text() = 'Café'])[1]")).click();
		
	}
	
	public void UnidadesSala () throws InterruptedException {
		
		driver.findElement(By.xpath("(//div/button/span[@class = 'filter-option pull-left'])[9]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/a/span[text() = 'Eden'])[1]")).click();
		Thread.sleep(1000);
		
	}
		
	public void ParticipantesExternos () {
		
		driver.findElement(By.cssSelector("#be-calendar-event-participants-content > div.col-md-12 > div.col-md-12.col-xs-12 > a.collapsed > h2.color-lilac-dark")).click();
		
	}
	
	public void ReservaSala () {
		
		driver.findElement(By.xpath("//a[@id='link-to-collapse-room']/h2")).click();
		
	}
	
	public void Nome ( String nome ) {
		
		driver.findElement(By.id("be-calendar-event-participant-name")).clear();
		driver.findElement(By.id("be-calendar-event-participant-name")).sendKeys(nome);
			
	}
	
	public void Rg ( String rg ) {
		
		driver.findElement(By.id("be-calendar-event-participant-doc")).clear();
		driver.findElement(By.id("be-calendar-event-participant-doc")).sendKeys(rg);
		
	}
	
	public void email ( String email ) {
		
		driver.findElement(By.id("be-calendar-event-participant-email")).clear();
		driver.findElement(By.id("be-calendar-event-participant-email")).sendKeys(email);
		
	}
	
	public void PageDown () throws InterruptedException {
		
		WebElement Xpath = driver.findElement(By.xpath("(//div/div/div[@class = 'modal-footer'])[4]"));
		Actions click = new Actions(driver).click(Xpath);
		click.build().perform();
		Thread.sleep(2000);
		
	}
		
	public void Adicionar () throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@id='card-event-store']/span")).click();
		Thread.sleep(7000);
		
	}
	
	public void Semana () {
		
		driver.findElement(By.xpath("(//button[@type='button'])[41]")).click();
		
	}
	
	public void SalasReuniao () throws InterruptedException {
		
		driver.findElement(By.xpath("(//a[@id='be-modal-tab-title-text']/span)[2]")).click();
		Thread.sleep(500);
		
	}
	
	public void Convidados () throws InterruptedException {
		
		driver.findElement(By.xpath("(//a[@id='be-modal-tab-title-text']/span)[3]")).click();
		Thread.sleep(500);
		
	}
	
	public void MeusEventos () throws InterruptedException {
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Próximos eventos'])[1]/preceding::span[2]")).click();
		Thread.sleep(500);

	}
	
	public void BuscarEvento ( String buscarEvento ) throws InterruptedException {
		
		driver.findElement(By.xpath("//input [@placeholder = 'Deseja fazr uma busca?'][@aria-controls='be-event-list']")).clear();
		driver.findElement(By.xpath("//input [@placeholder = 'Deseja fazr uma busca?'][@aria-controls='be-event-list']")).sendKeys(buscarEvento);
		Thread.sleep(4000);
				
	}
	
	public String Titulo () {
		
		return driver.findElement(By.xpath("//table[@id='be-event-list']/tbody/tr/td[3]")).getText();
		
	}

	public void EditarEvento () throws InterruptedException {
		
		driver.findElement(By.id("be-calendar-event-edit")).click();
		Thread.sleep(4000);
		
	}
	
	public void ExcluirEvento () throws InterruptedException {
		
		driver.findElement(By.id("be-button-delete-event")).click();
		Thread.sleep(5000);
	}
	
	public void Sim () throws InterruptedException {
		
		driver.findElement(By.cssSelector("a.btn.btn-danger")).click();
		Thread.sleep(4000);
	}
	
	public void Screenshot () throws IOException {
	
//		File ApagaEvidenciaAntiga = new File("C:\\Users\\gabriel.souza\\Desktop\\Documentos\\Robo\\Evidencias\\TestCalendario\\EVIDENCIA.jpg");
//		ApagaEvidenciaAntiga.delete();
		String Diretorio = "C:\\Users\\gabriel.souza\\Desktop\\Documentos\\Robo\\Evidencias\\TestCalendario";
		WebDriver augmentedDriver = new Augmenter().augment(driver);
	    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File( Diretorio + File.separator + "EVIDENCIA.jpg"));
		
	}
	
	public void GravarVariavelExisteBug ( String variavel  ) throws IOException {
		
		File Diretorio = new File("C:\\Users\\gabriel.souza\\Desktop\\Documentos\\Robo\\Parametros\\existeBug.txt");
		FileWriter Gravar = new FileWriter(Diretorio, false);
							
		Gravar.write(variavel);
		Gravar.close();
		
	}
	
	public void GravarBugArquivoTXT () throws IOException {

		File Diretorio = new File("C:\\Users\\gabriel.souza\\Desktop\\Documentos\\Robo\\Parametros\\existeBug.txt");
		FileWriter existeBug = new FileWriter(Diretorio, false);
									
		existeBug.write("true");
		existeBug.close();

	}
	
	public void FinalizarBugArquivoTXT () throws IOException {

		File Diretorio = new File("C:\\Users\\gabriel.souza\\Desktop\\Documentos\\Robo\\Parametros\\existeBug.txt");
		FileWriter existeBug = new FileWriter(Diretorio, false);
									
		existeBug.write("false");
		existeBug.close();

	}
	
	public void LerBugArquivoTXT () throws IOException {
		
		FileInputStream arquivo = new FileInputStream("C:\\Users\\gabriel.souza\\Desktop\\Documentos\\Robo\\Parametros\\existeBug.txt");
		InputStreamReader input = new InputStreamReader(arquivo);
		BufferedReader lerTxt = new BufferedReader(input);
				
		String CapturaValorTxt;
		
		CapturaValorTxt = lerTxt.readLine();	
		
//		System.out.println("A variável: ( CapturaValorTxt ) armazenou o valor do tipo String capturado do carquivo txt: " + "<<< " + CapturaValorTxt + " >>>" );	
				
		boolean Bug;
		
		Bug = Boolean.parseBoolean(CapturaValorTxt);
		Parametros.existeBug = Bug;
		
//		System.out.println("A variável: ( Bug ) recebe o 'valor String' capturado do txt e "
//				+ "converte para o tipo de dado: 'Booleano': " + "<<< " + Parametros.existeBug + " >>> " 
//						+ "e transfere o valor para a variável publica e statica: ( existeBug ), estendida da Classe: ( Parametros ).");
	
	}
	
	public boolean GravarStatusArquivoTXT () throws IOException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//span/span)[65][text()]")));
		String Xpath = driver.findElement(By.xpath("(//span/span)[65][text()]")).getText();
		File Diretorio = new File("C:\\Users\\gabriel.souza\\Desktop\\Documentos\\Robo\\Parametros\\statusBug.txt");
		FileWriter Gravar = new FileWriter(Diretorio, false);
				
		Gravar.write(Xpath);
		Gravar.close();

		return GravarStatusArquivoTXT();

	}
	
	public String ValidarStatusArquivo () throws IOException {
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-test-id='issue.views.issue-base.foundation.status.status-field-wrapper']//button[@type = 'button']/span/span)[1]")));
		String Xpath = driver.findElement(By.xpath("(//div[@data-test-id='issue.views.issue-base.foundation.status.status-field-wrapper']//button[@type = 'button']/span/span)[1]")).getText();
		Parametros.statusBug = Xpath;
		return Parametros.statusBug;
		
	}
			
	public void LerArquivoTXT () throws IOException {
		
		LerArquivoTXT(TestCalendario.BugArquivoTXT);
	
	}
	
		
}
