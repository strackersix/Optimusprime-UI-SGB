package Card;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Parametros;

public class Framework extends BasePage {

	
	public void GoCompartilhamentoCard () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		AlterarCard();
		Categoria("Doc88 Informa");
		Grupo("Doc88");
//		AlterarComentario("Uma das melhores do Brasil!!!"); 
		Compartilhar();

		Assert.assertEquals("DOC88 INFORMA", ValidaAlteracaoCategoria());
//		Assert.assertEquals("Uma das melhores do Brasil!!!", ValidaAlteracaoComentario());
				
	}
		
	String Variavel;
	public String AlterarCard () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[@class = 'be-pin-content pin-content'])[4]/h1/a)[1]")));
		Variavel = driver.findElement(By.xpath("((//span[@class= 'be-pin-header-wrapper'])/small)[1]")).getText();
		driver.findElement(By.xpath("(//div/a[@class = 'be-pin-reference'])[1]")).click();
		return Variavel;
		
	}
		
	public String ValidaAlteracaoCategoria () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class = 'be-pin-header-wrapper']/small)[1]")));
		Thread.sleep(1000);
		return driver.findElement(By.xpath("(//span[@class = 'be-pin-header-wrapper']/small)[1]")).getText();
		
	}
	
	public String ValidaAlteracaoComentario () {
		
		return driver.findElement(By.xpath("//span[text() = 'Uma das melhores do Brasil!!!']")).getText();
		
	}
				
	public void Url ( String url ) {
		
		driver.get(url);
				
	}
	
	public void Compartilhar () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/a/li[@class = 'fa fa-retweet'])[2]")));
		driver.findElement(By.xpath("(//div/a/li[@class = 'fa fa-retweet'])[2]")).click();
		
	}
	
	public void Categoria ( String categoria ) {
		
		WebElement element = driver.findElement(By.xpath("//select[@id = 'be-modal-post-text-select']"));
		Select select = new Select(element);
		select.selectByVisibleText(categoria);
		
	}
	
	public void Grupo ( String grupo ) {
		
		WebElement element = driver.findElement(By.xpath("//select[@id = 'be-modal-post-text-group']"));
		Actions click = new Actions(driver).click(element);
		click.build().perform();
		driver.findElement(By.xpath("(//li/a/span[text() = 'Doc88'])[3]")).click();
		
	}
	
	public void CompartilharCard () {
		
		driver.findElement(By.xpath("//button[@id = 'card-share-button']")).click();
		
	}
	
	public String ValidaCardCompartilhado () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/div/i[@class = 'fa fa-retweet color-green-light be-pin-sharer-icon'])[1]")));
		return driver.findElement(By.xpath("(//div/div/i[@class = 'fa fa-retweet color-green-light be-pin-sharer-icon'])[1]")).getAttribute("class");
			
	}
	
	public void GoCreateCardLink () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		Publicar();
		Link();
		InserirLink("https://www.doc88.com.br/institucional");
		CarregarLink();
		Categoria("Notícias");
		ComentarioPost("Excelente PME para se trabalhar.");
		Grupo("Doc88");
		PublicarCard();

		Assert.assertEquals("DOC88 - Institucional", ValidaCreatCardLink());
		
	}
			
	public void Publicar () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id = 'be-post-button']")));
		driver.findElement(By.xpath("//button[@id = 'be-post-button']")).click();
		
	}
	
	public void Link () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[@id = 'be-modal-tab-title-link']")));
		driver.findElement(By.xpath("//ul/li/a[@id = 'be-modal-tab-title-link']")).click();
		
	}
	
	public void InserirLink ( String inserirLink ) {
		
		driver.findElement(By.xpath("//input[@id = 'link-card-link']")).clear();
		driver.findElement(By.xpath("//input[@id = 'link-card-link']")).sendKeys(inserirLink);
		
	}
	
	public void CarregarLink () {
		
		driver.findElement(By.xpath("//div/button[@id = 'be-modal-post-load-link']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'DOC88 - Institucional']")));
		
	}
	
	public void CarregarYouTube () {
		
		driver.findElement(By.xpath("//div/button[@id = 'be-modal-post-load-link']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'Como Criamos o Futuro  - Metodologia']")));
		
	}
		
	public void ComentarioPost ( String comentarioPost ) {
		
		driver.findElement(By.xpath("//input[@placeholder = 'Comente seu post']")).sendKeys(comentarioPost);
		
	}
		
	public void PublicarCard () {
		
		driver.findElement(By.xpath("//button[@id = 'card-post-button']")).click();
		
	}
	
	public String ValidaCreatCardLink () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a[text() = 'DOC88 - Institucional'])[1]")));
		return driver.findElement(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a[text() = 'DOC88 - Institucional'])[1]")).getText();
		
	}

	public void GoCreateCardTextosArquivos () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		Publicar();
		TextosArquivos();
		Categoria("Notícias");
		TituloTexto("Selenium Webdriver");
		Texto("Selenium é uma estrutura portátil para testar aplicativos da web . O Selenium fornece uma ferramenta de reprodução para criar testes funcionais sem a necessidade de aprender uma linguagem de script de teste (Selenium IDE). Ele também fornece uma linguagem específica de domínio de teste (Selenese) para escrever testes em várias linguagens de programação populares, incluindo C # , Groovy , Java , Perl , PHP , Python , Ruby e Scala . Os testes podem ser executados nos navegadores mais modernos . O selênio é executado emWindows , Linux e macOS . É um software de código aberto lançado sob a Licença Apache 2.0 .");
		Grupo("Doc88");
		PublicarCard();
		
		Assert.assertEquals("Selenium Webdriver", ValidaCreatCardTextos());
		
	}
		
	public void TextosArquivos () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id = 'be-modal-tab-title-text']")));
		driver.findElement(By.xpath("//a[@id = 'be-modal-tab-title-text']")).click();
		
	}
		
	public void TituloTexto ( String tituloTexto ) {
		
		driver.findElement(By.xpath("//input[@id = 'text-card-title']")).sendKeys(tituloTexto);
		
	}
	
	public void Texto ( String texto ) {
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@id = 'tinymce']/p")).sendKeys(texto);
		driver.switchTo().defaultContent();
				
	}
	
	public String ValidaCreatCardTextos () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a[text() = 'Selenium Webdriver'])[1]")));
		return driver.findElement(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a[text() = 'Selenium Webdriver'])[1]")).getText();
		
	}
	
	public void GoCreateCardYouTube () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		Publicar();
		YouTube();
		LinkYoutube("https://www.youtube.com/watch?v=4wiSvq1FvI8");
		CarregarYouTube();
		Categoria("Notícias");
		Grupo("Doc88");
		ComentarioPost("Doc 88");
		PublicarCard();
		
		Assert.assertEquals("Como Criamos o Futuro - Metodologia", ValidaCard());
		
	}
	
		
	public void YouTube () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'js-change-media-type'][@data-type = 'video']")));
		driver.findElement(By.xpath("//a[@class = 'js-change-media-type'][@data-type = 'video']")).click();
		
	}
	
	public void LinkYoutube ( String linkYoutube ) {
		
		driver.findElement(By.xpath("//input[@id = 'link-card-link']")).sendKeys(linkYoutube);
		
	}
							
	public String ValidaCard () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a)[1]")));
		Thread.sleep(2000);
		return driver.findElement(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a)[1]")).getText();
		
	}

	public void GoDeleteCardLink() throws InterruptedException {

		Url(Parametros.UrlPowerView);
		DeletarCard();
		DeletarCard();

		Assert.assertNotEquals("DOC88 - Institucional", ValidaExclusao());

	}

	public void DeletarCard() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class = 'btn btn-xs be-button-delete-card'])[1]")));
		driver.findElement(By.xpath("(//button[@class = 'btn btn-xs be-button-delete-card'])[1]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'btn btn-danger']")));
		driver.findElement(By.xpath("//a[@class = 'btn btn-danger']")).click();
		Thread.sleep(1000);

	}

	public String ValidaExclusao() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/h1/a[1])[1]")));
		Thread.sleep(2000);
		return driver.findElement(By.xpath("(//div/h1/a[1])[1]")).getText();

	}

	public void GoDeleteCardTextosArquivos () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		DeleteCard();
		DeleteCard();
		
		Assert.assertNotEquals("Selenium Webdriver", ValidaExclusao());
			
	}
				
	public void DeleteCard () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class = 'btn btn-xs be-button-delete-card'])[1]")));
		driver.findElement(By.xpath("(//button[@class = 'btn btn-xs be-button-delete-card'])[1]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/a[@class = 'btn btn-danger']")));
		driver.findElement(By.xpath("//div/div/a[@class = 'btn btn-danger']")).click();
		Thread.sleep(1000);
				
	}
	
	public void GoDeleteCardYouTube () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		DeleteCard();
		DeleteCard();
		
		Assert.assertNotEquals("Como Criamos o Futuro  - Metodologia", ValidaExclusao());
		
	}
	
	public void GoPesquisarCardAntigo () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		MeuPergil();
		Conteudo();
		Cards();
		Pesquisar("Finalmente o Bearned nasceu!");
		
		Assert.assertEquals("8 Finalmente o Bearned nasceu! Notícias Vinicius Luiz 02/09/2016 21:09", ValidaPesquisa());
		
		AbrirCard();
		AlternarAbaIndice1();
		
		try {
			
			Assert.assertEquals("Finalmente o Bearned nasceu!", ValidaCardAntigo());
			FecharAbaAtual();
			AlternarAbaIndice0();
			
		} catch (Throwable e) {

			FecharAbaAtual();
			AlternarAbaIndice0();
			
		}
		
	}
 		
	public void MeuPergil () {
		
		driver.findElement(By.xpath("//button[@id = 'dropdown-user']")).click();
				
	}
	
	public void Conteudo () {
		
		driver.findElement(By.xpath("(//a[@href=\"/admin/highlight\"])[1]")).click();
		
	}
	
	public void Cards () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id = 'be-modal-tab-title-link'])[3]")));
		driver.findElement(By.xpath("(//a[@id = 'be-modal-tab-title-link'])[3]")).click();
		
	}
	
	public void Pesquisar ( String pesquisar ) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder = 'Deseja fazer uma busca?']")));
		driver.findElement(By.xpath("//input[@placeholder = 'Deseja fazer uma busca?']")).sendKeys(pesquisar);
		
	}
	
	public String ValidaPesquisa () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tbody)[1]/tr")));
		Thread.sleep(2000);
		return driver.findElement(By.xpath("(//tbody)[1]/tr")).getText();		
		
	}
	
	public void AbrirCard () {
		
		driver.findElement(By.xpath("//tr/td/a[@class = 'btn btn-link']")).click();
		
	}
	
	public void AlternarAbaIndice1 () {
		
		List<String> aba = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(aba.get(1));
		
	}
	
	public void AlternarAbaIndice0 () {
		
		List<String> aba = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(aba.get(0));
		
	}
	
	public void FecharAbaAtual () {
		
		driver.close();
		
	}
	
	public String ValidaCardAntigo () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@id = 'be-pin-title-text-modal']")));
		return driver.findElement(By.xpath("//h1[@id = 'be-pin-title-text-modal']")).getText();
		
	}

	public void GoReadCardLink () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		Pesquisar();
		Categoria("Notícias");
		Grupo("Doc88");
		Descricao("Doc88 - Institucional");
		BtnPesquisar();

		Assert.assertEquals("DOC88 - Institucional", ValidaCreatCardLink());
		Assert.assertEquals("Excelente PME para se trabalhar.", ValidaCreatCardComentario());
		
	}
		
	public void Pesquisar () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id = 'dropdown-search']")));
		driver.findElement(By.xpath("//button[@id = 'dropdown-search']")).click();
		
	}
		
	public void Descricao ( String descricao ) {
		
		driver.findElement(By.xpath("//input[@id = 'filter-content']")).sendKeys(descricao);
		
	}
	
	public void BtnPesquisar () {
		
		driver.findElement(By.xpath("//button[@id = 'filter-submit']")).click();
		
	}
		
	public String ValidaCreatCardComentario () throws InterruptedException {
		
		return driver.findElement(By.xpath("//span[text() = 'Excelente PME para se trabalhar.']")).getText();
		
	}
	
	public void GoReadCardTextosArquivos () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);
		Pesquisar();
		Categorias("Notícias");
		Grupos("Doc88");
		Descricao("Selenium Webdriver");
		BtnPesquisar();

		Assert.assertEquals("Selenium Webdriver", ValidaCardTexto());
		
	}
		
	public void Categorias ( String categoria ) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'btn dropdown-toggle btn-default'][@title = 'Todas as categorias']")));
		WebElement element = driver.findElement(By.xpath("//select[@id = 'filter-category']"));
		Select select = new Select(element);
		select.selectByVisibleText(categoria);
		
	}

	public void Grupos ( String grupos ) {
		
		WebElement element = driver.findElement(By.xpath("//select[@id = 'filter-group']"));
		Select select = new Select(element);
		select.selectByVisibleText(grupos);
		
	}
			
	public String ValidaCardTexto () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a)[1]")));
		Thread.sleep(2000);
		return driver.findElement(By.xpath("(//div[@class = 'be-pin-content pin-content']/h1/a)[1]")).getText();
		
	}
	
	public void GoReadCardYoutube () throws InterruptedException {
		
		Url(Parametros.UrlPowerView);		
		Pesquisar();
		Categoria("Notícias");
		Grupo("Doc88");
		Descricao("Como Criamos o Futuro  - Metodologia");
		BtnPesquisar();

		Assert.assertEquals("Como Criamos o Futuro - Metodologia", ValidaCreatCardLink());
		
	}
	
	public void GoCompartilhamentoCardTextosArquivos () {
		
		Url(Parametros.UrlPowerView);
		Compartilhar();
		Categoria("Notícias");
		Grupo("Doc88");
		CompartilharCard();

		Assert.assertEquals("fa fa-retweet color-green-light be-pin-sharer-icon", ValidaCardCompartilhado());
		
	}
	
	public void GoCompartilhamentoCardYouTube () {
		
		Url(Parametros.UrlPowerView);
		Compartilhar();
		Categoria("Notícias");
		Grupo("Doc88");
		CompartilharCard();

		Assert.assertEquals("fa fa-retweet color-green-light be-pin-sharer-icon", ValidaCardCompartilhado());
		
	}
		
	public void BugArquivoTXT ( String VariavelDiretorioArquivoTXT) {

		LerArquivoTXT(VariavelDiretorioArquivoTXT);

	}
	
}
