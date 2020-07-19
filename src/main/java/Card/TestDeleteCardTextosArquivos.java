package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestDeleteCardTextosArquivos {

	static String Resumo = "DELETE - Card do tipo: 'Textos e Arquivos'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de exclusão do Card Textos e Arquivos foi interrompido."
			+ "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestDeleteCardTextosArquivos\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaDeleteCardTextosArquivos() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.DeleteCard();
				Step.DeleteCard();

				Assert.assertNotEquals("Selenium Webdriver", Step.ValidaExclusao());
				
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
				
				System.out.println("Caso de teste: ( TestDeleteCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestDeleteCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestDeleteCardTextosArquivos2 AcaoStatusBug = new TestDeleteCardTextosArquivos2();
			AcaoStatusBug.Go();			

		}

	}

}
