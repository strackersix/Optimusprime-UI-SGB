package CentralCadastros;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _CORE.BasePage;
import _CORE.Constantes;
import _CORE.Parametros;

public class Framework extends BasePage implements Constantes {

	public void Url ( String Url ) {

		driver.get(Url);

	}
	
	public void MinhaConta () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")));
		driver.findElement(By.xpath("(//ul/li/a[@class = 'dropdown-toggle'])[2]")).click();
	
	}
	
	public void CentralCadastro () {
		
		driver.findElement(By.xpath("(//ul/li/a[@href = '/centralcadastros'])[2]")).click();
				
	}
	
	public void Cadastro () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/span[text() = 'Cadastro']")));
		driver.findElement(By.xpath("//div/div/span[text() = 'Cadastro']")).click();
				
	}
	
	public void Upload () {
		
		driver.findElement(By.xpath("//div/div/span[text() = 'Upload']")).click();
				
	}
	
	public void Celula ( String Celula ) {
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/div/div[@class = 'multiselect__select'])[1]")));
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[1]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[1]")).sendKeys(Celula);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']")));
		driver.findElement(By.xpath("(//div[@class = 'base-multi-select-async pa-1'])[1]/div/div/ul/li/span")).click();
				
	}
	
	public void Front ( String Front ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[2]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[2]")).sendKeys(Front);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[2]")));
		driver.findElement(By.xpath("(//div[@class = 'base-multi-select-async pa-1'])[2]/div/div[3]/ul/li/span")).click();
				
	}
	
	public void Middle ( String Middle ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[3]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[3]")).sendKeys(Middle);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[2]")));
		driver.findElement(By.xpath("(//div[@class = 'base-multi-select-async pa-1'])[3]/div/div[4]/ul/li/span/span")).click();
				
	}
	
	public void GrupoEconomico ( String grupoEconomico ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[4]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[4]")).sendKeys(grupoEconomico);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[2]")));
		driver.findElement(By.xpath("(//div[@class = 'base-multi-select-async pa-1'])[4]/div/div[3]/ul/li/span/span")).click();
				
	}
	
	public void GrupoEmpresa ( String grupoEmpresa ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[5]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[5]")).sendKeys(grupoEmpresa);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[2]")));
		driver.findElement(By.xpath("(//div[@class = 'base-multi-select-async pa-1'])[5]/div/div[3]/ul/li/span/span")).click();
				
	}
	
	public void Estado ( String estado ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[7]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[7]")).sendKeys(estado);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[2]")));
		driver.findElement(By.xpath("(//div[@class = 'base-multi-select-async pa-1'])[7]/div/div[3]/ul/li/span/span")).click();
				
	}

	public void ExibirPagina10 () throws InterruptedException {
		
		driver.findElement(By.xpath("//div/div/span[@class = 'base-table--rows-per-page--item text--align-center mx-1 pa-1 active background-purple--darken1 white']")).click();
		Thread.sleep(1000);
		
	}
	
	public void ExibirPagina25 () throws InterruptedException {
		
		driver.findElement(By.xpath("//div/div/span[@class = 'base-table--rows-per-page--item text--align-center mx-1 pa-1 background-grey--lighten4 grey--lighten1 cursor--pointer']")).click();
		Thread.sleep(1000);
		
	}
	
	public void ExibirPagina50 () throws InterruptedException {
		
		driver.findElement(By.xpath("base-table--rows-per-page--item text--align-center mx-1 pa-1 background-grey--lighten4 grey--lighten1 cursor--pointer")).click();
		Thread.sleep(1000);
		
	}
	
	public void filtrar () {
		
		driver.findElement(By.xpath("//div/button/i[@class = 'fa fa-search']")).click();
				
	}
		
	public String ValidaGrupoEconomico1 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//tr/td/span)[2]")));
		return driver.findElement(By.xpath("(//tr/td/span)[2]")).getText();
		
	}
	
	public String ValidaGrupoEconomico2 () {
		
		return driver.findElement(By.xpath("(//tr/td/span)[13]")).getText();
		
	}
	
	public String ValidaGrupoEconomico3 () {
		
		return driver.findElement(By.xpath("(//tr/td/span)[24]")).getText();
		
	}
	
	public void FlegarTodos () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th/span/i[@class = 'cursor--pointer fa fa-square-o']")));
		driver.findElement(By.xpath("//th/span/i[@class = 'cursor--pointer fa fa-square-o']")).click();
				
	}
	
	public void FlegarUnidade1 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th/span/i[@class = 'cursor--pointer fa fa-square-o']")));
		driver.findElement(By.xpath("(//td/span/i[@class = 'fa fa-square-o cursor--pointer'])[1]")).click();
		
	}
	
	public void FlegarUnidade2 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th/span/i[@class = 'cursor--pointer fa fa-square-o']")));
		driver.findElement(By.xpath("(//td/span/i[@class = 'fa fa-square-o cursor--pointer'])[2]")).click();
		
	}
	
	public void FlegarUnidade3 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th/span/i[@class = 'cursor--pointer fa fa-square-o']")));
		driver.findElement(By.xpath("(//td/span/i[@class = 'fa fa-square-o cursor--pointer'])[3]")).click();
		
	}
	
	public void AlterarDados1 () {
		
		driver.findElement(By.xpath("(//tr/td)[11]")).click();
		
	}
	
	public void AlterarDados2 () {
		
		driver.findElement(By.xpath("(//tr/td)[22]")).click();
		
	}
	
	public void AlterarDados3 () {
		
		driver.findElement(By.xpath("(//tr/td)[33]")).click();
		
	}
	
	public String ValidaCentroDecisorioAlterado1() {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto white background-grey']")));
		return driver.findElement(By.xpath("(//div/div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[10]")).getText();
		
	}
	
	public String ValidaCentroDecisorioAlterado2() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'multiselect__single'])[1]")).getText();
		
	}
	
	public String ValidaComplexidadeAlterado1 () {
		
		return driver.findElement(By.xpath("(//div/div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[11]")).getText();		
		
	}
	
	public String ValidaComplexidadeAlterado2 () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'multiselect__single'])[2]")).getText();		
		
	}
	
	public void AlterarItensFiltrados () {
		
		driver.findElement(By.xpath("//div/button/span[text() = 'Alterar todos os itens filtrados']")).click();
				
	}
	
	public void CentroDecisorio ( String centroDecisorio ) throws InterruptedException {
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button[@class = 'base-button white px-auto background-purple']")));
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__tags'])[1]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[1]")).sendKeys(centroDecisorio);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[1]")));
		driver.findElement(By.xpath("//li/span/span")).click();
		Thread.sleep(500);
		
	}
	
	public void Complexidade ( String complexidade ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__tags'])[2]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[2]")).sendKeys(complexidade);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[2]")));
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[2]")).sendKeys(Keys.ENTER);
				
	}
	
	public void BalancoAutomatico ( String balancoAutomatico ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__tags'])[6]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[6]")).sendKeys(balancoAutomatico);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[4]")));
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[6]")).sendKeys(Keys.ENTER);
		
	}
	
	public void EncerramentoAutomatico ( String encerramentoAutomatico ) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__tags'])[7]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[7]")).sendKeys(encerramentoAutomatico);
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[7]")).sendKeys(Keys.ENTER);
		
	}
	
	public String  BalancoAutomtico () {
		
		return driver.findElement(By.xpath("(//div/div//div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[14]")).getText();
		
	}
	
	public String  EncerramentoAutomatico () {
		
		return driver.findElement(By.xpath("(//div/div//div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[15]")).getText();
		
	}
	
	
	public String ValidaBalancoAutomatico () {
		
		return driver.findElement(By.xpath("(//div/div/span)[65]")).getText();
		
	}

	public String ValidaEncerramentoAutomatico () {
		
		return driver.findElement(By.xpath("(//div/div/span)[67]")).getText();
		
	}
	
	public String ValidaALteracaoBalancoAutomatico () {
		
		return driver.findElement(By.xpath("(//div/div/span)[63]")).getText();
		
	}

	public String ValidaAlteracaoEncerramentoAutomatico () {
		
		return driver.findElement(By.xpath("(//div/div/span)[65]")).getText();
		
	}
	
	public void Email () {
		
		driver.findElement(By.xpath("(//ul/li[@class = 'page-tabs--item'])[1]")).click();
				
	}
	
	public void EmailUnitario () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto white background-grey']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ul/a/li[@class = 'page-tabs--item'])[2]")).click();
		
	}
	
	public String ValidaEmailUnidadeNotaFiscal () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto white background-grey']")));
		return driver.findElement(By.xpath("(//div/div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[1]")).getText();
		
	}
	
	public String ValidaEmailUnidadeInformativoCCEE () {
		
		return driver.findElement(By.xpath("(//div/div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[2]")).getText();
		
	}
	
	public String ValidaEmailUnidadeContribuicaoAssocoatova() {
		
		return driver.findElement(By.xpath("(//div/div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[3]")).getText();
		
	}
	
	public String ValidaEmailUnidadeSazonalizacao() {
		
		return driver.findElement(By.xpath("(//div/div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[4]")).getText();
		
	}
	
	
	public void IncluirEmailNotaFiscal ( String incluirEmailNotaFiscal ) {
		
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[1]")).click();
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[1]")).sendKeys(incluirEmailNotaFiscal);
		driver.findElement(By.xpath("(//div/div/button[@class = 'button-action'])[1]")).click();
		
	}
	
	
	public void IncluirEmailInformativosCCEE ( String incluirEmailInformativosCCEE ) {
		
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).click();
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).sendKeys(incluirEmailInformativosCCEE);
		driver.findElement(By.xpath("(//div/div/button[@class = 'button-action'])[2]")).click();
		
	}
	
	public void IncluirEmailConstribuicaoAssociativa ( String incluirEmailConstribuicaoAssociativa ) {
		
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[3]")).click();
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[3]")).sendKeys(incluirEmailConstribuicaoAssociativa);
		driver.findElement(By.xpath("(//div/div/button[@class = 'button-action'])[3]")).click();
		
	}
	
	public void IncluirEmailSazonalizacao ( String incluirEmailSazonalizacao ) {
		
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[4]")).click();
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[4]")).sendKeys(incluirEmailSazonalizacao);
		driver.findElement(By.xpath("(//div/div/button[@class = 'button-action'])[4]")).click();
		
	}
	
	public void PageDown () throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy ( 0, 2000 )");
		Thread.sleep(1000);
		
	}
	
	public void PageDownListaLog () {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy ( 0, 100 )");
				
	}
	
	
	public void Continuar () {
		
		driver.findElement(By.xpath("//div/button/span[text() = 'Continue']")).click();
			
	}
	
	public String ValidaAlteracaoDados() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div/span[@class = 'text--medium-regular text--bold']")));
		return driver.findElement(By.xpath("//div/div/span[@class = 'text--medium-regular text--bold']")).getText();
		
	}
	
	public String ValidaCentroDecisorio() {
		
		return driver.findElement(By.xpath("(//div[@class = 'flex--column pa-auto flex flex--justify-center border-grey--lighten2 bwb--single'])[1]/span[2]")).getText();
		
	}
	
	public String ValidaComplexidade() {
		
		return driver.findElement(By.xpath("(//div[@class = 'flex--column pa-auto flex flex--justify-center border-grey--lighten2 bwb--single'])[2]/span[2]")).getText();
		
	}
	
	public String ValidaEmailNotaFiscal() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--green'])[1]")).getText();
		
	}
	
	public String ValidaEmailInformativoCCEE() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--green'])[2]")).getText();
		
	}
	
	public String ValidaEmailContribuicaoAssociativa() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--green'])[3]")).getText();
		
	}
	
	public String ValidaEmailSazonalizacao() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--green'])[4]")).getText();
		
	}
	
	public void ActionsPageDown () throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement Click = driver.findElement(By.xpath("(//div/span[@class = 'color--green'])[4]"));
		Actions ClickGo = new Actions(driver).click(Click);
		ClickGo.build().perform();
		Thread.sleep(1000);
	}
	
	public void SalvarAlteracoes () {
		
		WebElement Click = driver.findElement(By.xpath("//div/button/span[text() = 'Salvar alterações']"));
		Actions ClickGo = new Actions(driver).click(Click);
		ClickGo.build().perform();
        			
	}
	
	public void Entendi () {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button[@class = 'base-button background-purple white px-auto mt-1']")));
		driver.findElement(By.xpath("//div/div/button[@class = 'base-button background-purple white px-auto mt-1']")).click();
		
	}
		
	public void EnviarArquivo () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/div/button[@class = 'base-button base-button background-purple white px-auto'])[1]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div/div/button[@class = 'base-button base-button background-purple white px-auto'])[1]")).click();
				
	}
		
	public void UploadArquivo () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[@class = 'base-button background-purple white base-button--regular px-auto']")));
		WebElement uploadElement = driver.findElement(By.xpath("(//input[@type = 'file'])[2]"));
		uploadElement.sendKeys(Path);
		
	}
	
	public void ImagemLogo () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@class = 'page-tabs--item']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul/li[@class = 'page-tabs--item']")).click();
			
	}
	
	public String ValidaLogo () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'flex flex--justify-center']/span")));
		return driver.findElement(By.xpath("//div[@class = 'flex flex--justify-center']/span")).getText();
		
	}
	
	public String ValidaLogo2 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/img[@class = 'logo-preview']")));
		return driver.findElement(By.xpath("//div/div/img[@class = 'logo-preview']")).getAttribute("class");
		
	}
	
	public void SelecionarTodasUnidades () {
		
		driver.findElement(By.xpath("//div/div/button[@class = 'base-button background-purple white base-button--fluid px-auto']")).click();
		
	}
	
	public String ValidaUnidade1 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div/div[@class = 'base-chip flex flex--nowrap bra-1 border-grey--lighten2 bwa--single pa-1 mr-1 mb-1 grey background-grey--lighten4']/span)[1]")));
		return driver.findElement(By.xpath("(//div/div[@class = 'base-chip flex flex--nowrap bra-1 border-grey--lighten2 bwa--single pa-1 mr-1 mb-1 grey background-grey--lighten4']/span)[1]")).getText();
		
	}
	public String ValidaUnidade2 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div/div[@class = 'base-chip flex flex--nowrap bra-1 border-grey--lighten2 bwa--single pa-1 mr-1 mb-1 grey background-grey--lighten4']/span)[1]")));
		return driver.findElement(By.xpath("(//div/div[@class = 'base-chip flex flex--nowrap bra-1 border-grey--lighten2 bwa--single pa-1 mr-1 mb-1 grey background-grey--lighten4']/span)[2]")).getText();
		
	}
	
	public void SalvarLogo () {
		
		driver.findElement(By.xpath("//div/button[@class = 'base-button base-button background-purple white px-auto']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span[@class = 'text--bold text--align-center']/../button")));
		driver.findElement(By.xpath("//div/span[@class = 'text--bold text--align-center']/../button")).click();
		
	}
		
	public void UploadLogo () {
		
		driver.findElement(By.xpath("(//div/div/input[@type = 'file'])[2]")).sendKeys(Parametros.UploadLogoCentralCadastros);
		driver.findElement(By.xpath("//div/div/button[@class = 'base-button background-purple white base-button--regular px-auto']")).click();
		
	}
			
	public String ValidaNomeDocumento () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[3]/span/i[@class = 'fa fa-trash']")));
		return driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
		
	}
	
	public String ValidaDataVigencia () {
		
		return driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
		
	}
	
	public String ValidaStatus () {
		
		return driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
		
	}
	
	public String ValidaTipo () {
		
		return driver.findElement(By.xpath("(//tbody/tr/td)[4]")).getText();
		
	}
	
	
	
	public void VisualizarEmails () throws InterruptedException {
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button[@class = 'base-button white px-auto background-purple']")));
		driver.findElement(By.xpath("(//nav/ul/li)[3]")).click();

	}

	public String ValidaUnid1EmailNotaFiscal () throws InterruptedException {

		String variavel = null;
		
		variavel = driver.findElement(By.xpath("//div[@class = 'flex flex--column flex--align-center pa-auto background-white']")).getText();
		System.out.println(variavel);
		
		while (variavel != null) {
					
			Thread.sleep(1000);
			
				try {
			
					driver.findElement(By.xpath("//div[@class = 'flex flex--column flex--align-center pa-auto background-white']")).getText();
				
				} catch (Exception e) {
					
					variavel = null;
					
				}
						
			}
		
		return driver.findElement(By.xpath("(//div/div/div)[309]")).getText();
		
	}
	
	public String ValidaUnid1EmailContribuicaoAssociativa () {
		
		return driver.findElement(By.xpath("(//div/div/div)[311]")).getText();
		
	}
	
	public String ValidaUnid2EmailNotaFiscal() {
		
		return driver.findElement(By.xpath("(//div/div/div)[315]")).getText();
		
	}
	
	public String ValidaUnid2EmailContribuicaoAssociativa () {
		
		return driver.findElement(By.xpath("(//div/div/div)[317]")).getText();
		
	}
	
	public String ValidaUnid3EmailNotaFiscal() {
		
		return driver.findElement(By.xpath("(//div/div/div)[321]")).getText();
		
	}
	
	public String ValidaUnid3EmailContribuicaoAssociativa () {
		
		return driver.findElement(By.xpath("(//div/div/div)[323]")).getText();
		
	}
	
	public String ValidaUnid1EmailInformativosCCEE () {
		
		return driver.findElement(By.xpath("(//div/div/div)[310]")).getText();
		
	}
	
	public String ValidaUnid1EmailSazonalizacao () {
		
		return driver.findElement(By.xpath("(//div/div/div)[312]")).getText();
		
	}
	
	public String ValidaUnid2EmailInformativosCCEE () {
		
		return driver.findElement(By.xpath("(//div/div/div)[316]")).getText();
		
	}
	
	public String ValidaUnid2EmailSazonalizacao () {
		
		return driver.findElement(By.xpath("(//div/div/div)[318]")).getText();
		
	}
	
	public String ValidaUnid3EmailInformativosCCEE () {
		
		return driver.findElement(By.xpath("(//div/div/div)[322]")).getText();
		
	}
	
	public String ValidaUnid3EmailSazonalizacao  () {
		
		return driver.findElement(By.xpath("(//div/div/div)[324]")).getText();
		
	}
	
    public void ExcluirEmailNotaFiscal ( String excluirEmailNotaFiscal ) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/div/div[@class = 'switch'])[1]")));
    	driver.findElement(By.xpath("(//div/div/div[@class = 'switch'])[1]")).click();
    	driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[1]")).sendKeys(excluirEmailNotaFiscal);
    	driver.findElement(By.xpath("(//div/button/i[@class = 'fa fa-plus-square icon fa-minus-square'])[1]")).click();
    	
    }
    
    public void ExcluirEmailInformativosCCEE ( String excluirEmailInformativosCCEE ) {
    	
    	driver.findElement(By.xpath("(//div/div/div[@class = 'switch'])[2]")).click();
    	driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).sendKeys(excluirEmailInformativosCCEE);
    	driver.findElement(By.xpath("(//div/button/i[@class = 'fa fa-plus-square icon fa-minus-square'])[2]")).click();
    	
    }
	
    public void ExcluirEmailContribuicaoAssociativa ( String excluirEmailContribuicaoAssociativa ) {
    	
    	driver.findElement(By.xpath("(//div/div/div[@class = 'switch'])[3]")).click();
    	driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[3]")).sendKeys(excluirEmailContribuicaoAssociativa);
    	driver.findElement(By.xpath("(//div/button/i[@class = 'fa fa-plus-square icon fa-minus-square'])[3]")).click();
    	
    }
    
    public void ExcluirEmailSazonalizacao ( String excluirEmailSazonalizacao ) {
    	
    	driver.findElement(By.xpath("(//div/div/div[@class = 'switch'])[4]")).click();
    	driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[4]")).sendKeys(excluirEmailSazonalizacao);
    	driver.findElement(By.xpath("(//div/button/i[@class = 'fa fa-plus-square icon fa-minus-square'])[4]")).click();
    	
    }
	
	public String ValidaExclusaoEmailNotaFiscal() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--red'])[1]")).getText();
		
	}
	
	public String ValidaExclusaoEmailInformativoCCEE() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--red'])[2]")).getText();
		
	}
	
	public String ValidaExclusaoEmailContribuicaoAssociativa() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--red'])[3]")).getText();
		
	}
	
	public String ValidaExclusaoEmailSazonalizacao() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'color--red'])[4]")).getText();
		
	}
	
	public void FilaCentralCadastros () throws InterruptedException {
		
		driver.get(Parametros.CentralCadastrosAPI);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/a[text() = 'Login']")));
		driver.findElement(By.xpath("//div/div/a[text() = 'Login']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button[@type = 'submit']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("admin@system.info");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("Sys##@dmin00");
		driver.findElement(By.xpath("//div/div/button[@type = 'submit']")).click();
		driver.get(Parametros.HorizonDashboard);
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a/span[text() = 'Recent Jobs']")));
		driver.findElement(By.xpath("//li/a/span[text() = 'Recent Jobs']")).click();
		driver.findElement(By.xpath("//div/div/button")).click();
		WebDriverWait wait4 = new WebDriverWait(driver, 300);
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//td[@class = 'text-right table-fit'])[1]/*[@class = 'fill-success']")));
		driver.findElement(By.xpath("//div/div/button")).click();
		Thread.sleep(1000);
		driver.get(Parametros.CentralCadastrosAPIHome);
		WebDriverWait wait5 = new WebDriverWait(driver, 300);
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[@id = 'navbarDropdown']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul/li/a[@id = 'navbarDropdown']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/a[@class = 'dropdown-item']")).click();
		Thread.sleep(1000);
					
	}
	
	public void AlternarAbaGoPowerview() throws InterruptedException{

        ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(abas.get(1));
    
	}
	
	public void ConsultarLogAlteracoes () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/span[text() = 'Consultar Log de Alterações']")));
		driver.findElement(By.xpath("//div/div/span[text() = 'Consultar Log de Alterações']")).click();
		
	}
	
	public void GrupoEconomicoLog ( String grupoEconomicoLog ) {
			
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr/td/span[text() = 'Visualizar detalhes'])[1]")));
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[1]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[1]")).sendKeys(grupoEconomicoLog);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[1]")));
		driver.findElement(By.xpath("(//li/span[@class = 'multiselect__option multiselect__option--highlight']/span)[1]")).click();
				
	}
	
	public void GrupoEmpresaLog ( String grupoEmpresaLog ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[2]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[2]")).sendKeys(grupoEmpresaLog);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[1]")));
		driver.findElement(By.xpath("(//li/span[@class = 'multiselect__option multiselect__option--highlight']/span)[1]")).click();
				
	}
	
	public void SolicitanteLog ( String solicitanteLog ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[4]")).click();
		driver.findElement(By.xpath("(//div/div/input[@id = 'multiselect'])[4]")).sendKeys(solicitanteLog);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[1]")));
		driver.findElement(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[1]/span")).click();
				
	}
	
	public void FiltrarLog () {
		
		driver.findElement(By.xpath("//div/div/button[@class = 'base-button background-purple white pa-auto']")).click();
		
	}
	
	public void ExibirPorPagina25 () throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div/div/span[@class ='base-table--rows-per-page--item text--align-center mx-1 pa-1 background-grey--lighten4 grey--lighten1 cursor--pointer' ])[1]")).click();
		
	}
	
	public String ComplexidadeAntes () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//header[@class = 'text--align-center bwb--single border-grey--lighten4 pa-auto']")));
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[1]")).getText();
		
	}

	public String ComplexidadeDepois () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[2]")).getText();
		
	}
	
	public String CentroDecisorioAntes () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[3]")).getText();
		
	}
	
	public String CentroDecisorioDepois () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[4]")).getText();
		
	}
    
	public String BalancoAutomaticoAntes () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[5]")).getText();
		
	}
	
	public String BalancoAutomaticoDepois () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[6]")).getText();
		
	}
	
	public String EmailSazonalizacaoAntes () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[7]")).getText();
		
	}
	
	public String EmailSazonalizacaoDepois () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[8]")).getText();
		
	}
	
	public String EmailInformaticoCCEEAntes () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[9]")).getText();
		
	}
	
	public String EmailInformaticoCCEEDepois () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[10]")).getText();
		
	}
	
	public String EmailContribuicaoAssociativaAntes () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[11]")).getText();
		
	}
	
	public String EmailContribuicaoAssociativaDepois () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[12]")).getText();
		
	}
	
	public String EmailNotaFiscalAntes () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[13]")).getText();
		
	}
	
	public String EmailNotaFiscalDepois () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[14]")).getText();
		
	}
		
	public void PageDownLog() {
		
		WebElement element = driver.findElement(By.xpath("//footer"));
		Actions click = new Actions(driver).click(element);
		click.build().perform();
				
	}
	
	public void FecharLog () throws InterruptedException {
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//footer/button[@class = 'base-button background-purple white px-auto mt-1']")).click();
		Thread.sleep(500);
		
	}
	
	public void LogPrimeiraAlteracaoUnidade1 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[12]")));
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[12]")).click();
		
	}
	
	public void LogSegundaAlteracaoUnidade1 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[11]")).click();
		
	}
	
	public void LogPrimeiraAlteracaoUnidade2 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[10]")).click();
		
	}
	
	public void LogSegundaAlteracaoUnidade2 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[9]")).click();
		
	}	
	
	public void LogPrimeiraAlteracaoUnidade3 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[8]")).click();
		
	}
	
	public void LogSegundaAlteracaoUnidade3 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[7]")).click();
		
	}	
	
	public void LogTerceiraAlteracaoUnidade1 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[6]")).click();
		
	}	
	
	public void LogQuartaAlteracaoUnidade1 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[5]")).click();
		
	}	
	
	public void LogTerceiraAlteracaoUnidade2 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[4]")).click();
		
	}	
	
	public void LogQuartaAlteracaoUnidade2 ()  {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[3]")).click();
		
	}	
	
	public void LogTerceiraAlteracaoUnidade3 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[2]")).click();
		
	}
	
	public void LogQuartaAlteracaoUnidade3 () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[1]")).click();
		
	}	
	
	public String EncerramentoAutomaticoAntes () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[1]")).getText();
		
	}
	
	public String EncerramentoAutomaticoDepois() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'd-block word-break'])[2]")).getText();
		
	}
	
	public void ValoresInfomerc () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto white background-grey']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul/a/li[@class = 'page-tabs--item'])[3]")).click();
		
	}
	
	public void DataInfomerc () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text() = 'Valores Infomerc']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/div/input[@placeholder = 'Select month']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//tr/td/div)[12]")).click();
				
	}
	
	public void Local ( String local ) {
		
		driver.findElement(By.xpath("(//div/div[@class = 'multiselect__select'])[1]")).click();
		driver.findElement(By.xpath("(//input[@id = 'multiselect'])[1]")).sendKeys(local);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[1]")));
		driver.findElement(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[1]/span")).click();
		
		
	}
	
	public void Imposto ( String imposto ) {
		
		driver.findElement(By.xpath("(//div/div[@class = 'multiselect__select'])[2]")).click();
		driver.findElement(By.xpath("(//input[@id = 'multiselect'])[2]")).sendKeys(imposto);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[1]")));
		driver.findElement(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[1]/span")).click();
		
		
	}
	
	public void AlterarImposto ( String alterarImposto ) {
		
		driver.findElement(By.xpath("(//div/div[@class = 'multiselect__select'])[2]")).click();
		driver.findElement(By.xpath("(//input[@id = 'multiselect'])[2]")).sendKeys(alterarImposto);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[2]")));
		driver.findElement(By.xpath("((//ul/li/span[@class = 'multiselect__option multiselect__option--highlight']))[2]/span")).click();
		
		
	}
	
	public void Valor ( String valor ) {
		
		driver.findElement(By.xpath("//div/div/input[@class = 'v-money base-form--input bwa--single border-grey--lighten4 bra-1 pa-2']")).sendKeys(valor);
		
	}
	
	public void Descricao ( String descricao ) {
		
		driver.findElement(By.xpath("//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2']")).sendKeys(descricao);
		
	}
	
	public void AdicionarNovaLinha () {
		
		driver.findElement(By.xpath("//button[@class = 'base-button base-button--fluid background-purple white']")).click();
		
	}
	
	public void SucessoEntendi () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text() = 'Entendi']")));
		driver.findElement(By.xpath("//button/span[text() = 'Entendi']")).click();
		
	}
	
	public String ValidaValoresInfomerc () {
		
		return driver.findElement(By.xpath("//table[@class = 'table-grid']/tbody/tr")).getText();
		
	}
	
	public void EditarValoresInfomerc () {
		
		driver.findElement(By.xpath("(//button[@class = 'base-button base-button--regular px-auto base-button--link'])[1]")).click();
		
	}
	
	public void EditarLocal ( String editarLocal ) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")));
		driver.findElement(By.xpath("(//div/div/i[@class = 'fa fa-close'])[1]")).click();
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[3]")).click();
		driver.findElement(By.xpath("(//input[@id = 'multiselect'])[3]")).sendKeys(editarLocal);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[3]")));
		driver.findElement(By.xpath("(//ul/li/span[@class = 'multiselect__option multiselect__option--highlight'])[3]/span")).click();
				
	}
	
	public void EditarValor ( String editarValor ) {
		
		driver.findElement(By.xpath("(//div/div/input[@class = 'v-money base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).clear();
		driver.findElement(By.xpath("(//div/div/input[@class = 'v-money base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).sendKeys(editarValor);
		
	}
	
	public void EditarDescricao ( String editarDescricao ) {
		
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).clear();
		driver.findElement(By.xpath("(//div/div/input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).sendKeys(editarDescricao);
		
	}
	
    public void Salvar () {
    	
    	driver.findElement(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")).click();
    	
    }
	
    public void AlteracaoEntendi () {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text() = 'Entendi']")));    	
    	driver.findElement(By.xpath("//button/span[text() = 'Entendi']")).click();
    	
    }
	
	public void ExlcuirCustoLivre () {
		
		driver.findElement(By.xpath("(//td[text() = 'Custo Livre']/../td/button)[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")));
		driver.findElement(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")));
		driver.findElement(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")).click();
		
	}
	
	public void ExlcuirRemuneracao () {
		
		driver.findElement(By.xpath("(//td[text() = 'Remuneração']/../td/button)[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")));
		driver.findElement(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")));
		driver.findElement(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")).click();
		
	}
	
	public void ExlcuirComparativoCativo () {
		
		driver.findElement(By.xpath("(//td[text() = 'Comparativo Cativo']/../td/button)[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")));
		driver.findElement(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")));
		driver.findElement(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")).click();
		
	}
	
	public void ExcluirDistribuidora () {
		
		driver.findElement(By.xpath("(//td[text() = 'Distribuidora']/../td/button)[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")));
		driver.findElement(By.xpath("//button[@class = 'base-button base-button--regular px-auto base-button--regular px-auto background-purple white']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")));
		driver.findElement(By.xpath("//button[@class = 'base-button background-purple white px-auto mt-1']")).click();
		
	}
	
	public void AcessarUpload () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/span[text() = 'Upload']")));
		driver.findElement(By.xpath("//div/div/span[text() = 'Upload']")).click();
		
	}
	
	public void GerenciarDocumentos1 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr/td/span[text() = 'Gerenciar documentos'])[1]")));
		driver.findElement(By.xpath("(//tr/td/span[text() = 'Gerenciar documentos'])[1]")).click();
		
	}
	
	public void GerenciarDocumentos2 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr/td/span[text() = 'Gerenciar documentos'])[1]")));
		driver.findElement(By.xpath("(//tr/td/span[text() = 'Gerenciar documentos'])[2]")).click();
		
	}
	
	public void GerenciarDocumentos3 () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr/td/span[text() = 'Gerenciar documentos'])[1]")));
		driver.findElement(By.xpath("(//tr/td/span[text() = 'Gerenciar documentos'])[3]")).click();
		
	}
	
	public void TipoDocumento ( String tipoDocumento ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[1]")).click();
		driver.findElement(By.xpath("(//div/input[@id = 'multiselect'])[1]")).sendKeys(tipoDocumento);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/span[@class = 'multiselect__option multiselect__option--highlight']/span")));
		driver.findElement(By.xpath("//li/span[@class = 'multiselect__option multiselect__option--highlight']/span")).click();
		
	}
	
	public void Estagio1 ( String Estagio ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[2]")).click();
		driver.findElement(By.xpath("(//div/input[@id = 'multiselect'])[2]")).sendKeys(Estagio);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/span[@class = 'multiselect__option multiselect__option--highlight']/span")));
		driver.findElement(By.xpath("//li/span[@class = 'multiselect__option multiselect__option--highlight']/span")).click();
		
	}	
	
	public void Estagio2 ( String Estagio ) {
		
		driver.findElement(By.xpath("(//div/div/div[@class = 'multiselect__select'])[2]")).click();
		driver.findElement(By.xpath("(//div/input[@id = 'multiselect'])[2]")).sendKeys(Estagio);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/span[@class = 'multiselect__option multiselect__option--highlight']/span)[2]")));
		driver.findElement(By.xpath("(//li/span[@class = 'multiselect__option multiselect__option--highlight']/span)[2]")).click();
		
	}	
	
	public void DataVigenciaInicio ( String dataVigenciaInicio ) {
		
		driver.findElement(By.xpath("(//input[@class = 'mx-input'])[1]")).sendKeys(dataVigenciaInicio);
		
	}
	
	public void DataVigenciaFim ( String dataVigenciaFim ) {
		
		driver.findElement(By.xpath("(//input[@class = 'mx-input'])[2]")).sendKeys(dataVigenciaFim);
		
	}

	public void Contraparte ( String contraparte ) {
		
		driver.findElement(By.xpath("(//input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[1]")).sendKeys(contraparte);
		
	}
	
	public void NumeroDoContrato ( String numeroDoContrato ) {
		
		driver.findElement(By.xpath("(//input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).sendKeys(numeroDoContrato);
		
	}
	
	public void NumeroDoContrato3 ( String numeroDoContrato ) {
		
		driver.findElement(By.xpath("(//input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[3]")).sendKeys(numeroDoContrato);
		
	}
	
	public void Distribuidora ( String distribuidora ) {
		
		driver.findElement(By.xpath("//input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2']")).sendKeys(distribuidora);
		
	}
	
	public void NumeroAditivo ( String numeroAditivo ) {
		
		driver.findElement(By.xpath("//input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2']")).sendKeys(numeroAditivo);
		
	}
	
	public void NumeroAditivo2 ( String numeroAditivo ) {
		
		driver.findElement(By.xpath("(//input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[2]")).sendKeys(numeroAditivo);
		
	}
	
	public void NumeroDoContrato2 ( String numeroDoContrato ) {
		
		driver.findElement(By.xpath("(//input[@class = 'base-form--input bwa--single border-grey--lighten4 bra-1 pa-2'])[3]")).sendKeys(numeroDoContrato);
		
	}
	
	public void CompartilharCom () {
		
		driver.findElement(By.xpath("//div/div/button[@class = 'base-button background-purple white base-button--fluid px-auto']")).click();
		
	}	
	
	public void Confirmar () {
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div/span[text() = 'POWERVIEW BALANCO UNID 2']")));
		driver.findElement(By.xpath("//div/button[@class = 'base-button background-purple white base-button--regular px-auto']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 80);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span[@class = 'text--bold text--align-center']/../button")));
		driver.findElement(By.xpath("//div/span[@class = 'text--bold text--align-center']/../button")).click();
		
	}
	
	public void Atualizar () throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div/div/button[@class ='base-button base-button background-purple white px-auto'])[2]")));
		driver.findElement(By.xpath("(//div/div/button[@class ='base-button base-button background-purple white px-auto'])[2]")).click();
		Thread.sleep(1000);
	}
	
	public String ValidaUploadContratoEnergia () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[3]/span/i[@class = 'fa fa-trash']")));
		return driver.findElement(By.xpath("(//table/tbody/tr)[1]")).getText();
		
	}
	
	public void ExcluirUpload () {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[3]")));
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type= 'radio'])[2]")).click();
		driver.findElement(By.xpath("//button[@class = 'base-button background-purple white base-button--regular px-auto']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/span[text() = 'POWERVIEW BALANCO UNID 1']")));
		driver.findElement(By.xpath("//button[@class = 'base-button background-purple white base-button--regular px-auto']")).click();
		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span[@class = 'text--bold text--align-center']/../button")));
		driver.findElement(By.xpath("//div/span[@class = 'text--bold text--align-center']/../button")).click();
		
	}
	
	public String ValidaExclusao () {
		
		return driver.findElement(By.xpath("//div/div[@class =  'flex flex--33 flex--align-center flex--justify-start']")).getText();
		
	}
		
	public void EditarUpload () {
		
		driver.findElement(By.xpath("(//td[@class = 'text--nowrap py-2 px-2 text--bold purple--darken2 cursor--pointer'])[2]")).click();
		
	}
	
	public String ValidaArquivo () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button[@class = 'base-button background-purple white base-button--regular px-auto']")));
		return driver.findElement(By.xpath("(//div/div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[1]")).getText();
		
	}
	
	public String ValidaTipoDocumento () {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'multiselect__single'])[1]")).getText();
		
	}
	
	public String ValidaEstagio() {
		
		return driver.findElement(By.xpath("(//div/div/span[@class = 'multiselect__single'])[2]")).getText();
		
	}
	
	public String ValidaContraparte() {
		
		return driver.findElement(By.xpath("(//div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[3]")).getText();
		
	}
	
	public String ValidaDistribuidora() {
		
		return driver.findElement(By.xpath("(//div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[3]")).getText();
		
	}
	
	public String ValidaNumeroContrato() {
		
		return driver.findElement(By.xpath("(//div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[4]")).getText();
		
	}
	
	public String ValidaNumeroAditivo() {
		
		return driver.findElement(By.xpath("(//div/div[@class = 'grey--lighten2 base-form--field--body flex flex--align-center'])[4]")).getText();
		
	}

	public String ValidaPrimeiraUnidade() {
		
		return driver.findElement(By.xpath("(//div/div[@class = 'base-chip flex flex--nowrap bra-1 border-grey--lighten2 bwa--single pa-1 mr-1 mb-1 grey background-grey--lighten4']/span)[1]")).getText();
		
	}
	
	public String ValidaSegundaUnidade() {
		
		return driver.findElement(By.xpath("(//div/div[@class = 'base-chip flex flex--nowrap bra-1 border-grey--lighten2 bwa--single pa-1 mr-1 mb-1 grey background-grey--lighten4']/span)[2]")).getText();
		
	}	
	
	public void Cancelar () {
		
		driver.findElement(By.xpath("//button[@class = 'base-button base-button--cancel mr-2']")).click();
		
	}


}
