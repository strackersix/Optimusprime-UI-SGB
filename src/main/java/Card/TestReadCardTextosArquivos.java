package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestReadCardTextosArquivos {

	static String Resumo = "READ - Card do tipo: 'Textos e Arquivos'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de pesquisa / leitura do Card Textos e Arquivos foi interrompido." + "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestReadCardTextosArquivos\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaReadCardTextosArquivos() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);
		
		if (Parametros.existeBug == false) {

			try {

				Step.Pesquisar();
				Step.Categorias("Notícias");
				Step.Grupos("Doc88");
				Step.Descricao("Selenium Webdriver");
				Step.BtnPesquisar();

				Assert.assertEquals("Selenium Webdriver", Step.ValidaCardTexto());

			} catch (Throwable e) {

				Jira TerrorDoDev = new Jira();
				TerrorDoDev.Screenshot();
				TerrorDoDev.UrlJira(Parametros.UrlJira);
				TerrorDoDev.IncluirTask();
				TerrorDoDev.Projeto(Parametros.ProjetoPowerView);
				TerrorDoDev.TipoItem(Parametros.TipoItem);
				TerrorDoDev.Resumo(Resumo);
				TerrorDoDev.Descricao(Descricao);
				TerrorDoDev.Upload();
				TerrorDoDev.Criar();
				TerrorDoDev.GravarBugArquivoTXT(BugArquivoTXT);
				
				System.out.println("Caso de teste: ( TestReadCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestReadCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestReadCardTextosArquivos2 AcaoStatusBug = new TestReadCardTextosArquivos2();
			AcaoStatusBug.Go();
			

		}

	}

}
