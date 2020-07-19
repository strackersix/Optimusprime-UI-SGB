package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCompartilhamentoCardTextosArquivos {

	static String Resumo = "COMPARTILHAMENTO - Card do tipo: 'Textos e Arquivos'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de Compartilhamento do Card Textos e Arquivos foi interrompido."	+ "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestCompartilhamentoCardTextosArquivos\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaCompartilhamentoCardTextosArquivos() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.Compartilhar();
				Step.Categoria("Notícias");
				Step.Grupo("Doc88");
				Step.CompartilharCard();

				Assert.assertEquals("fa fa-retweet color-green-light be-pin-sharer-icon", Step.ValidaCardCompartilhado());

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
				
				System.out.println("Caso de teste: ( TestCompartilhamentoCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestCompartilhamentoCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");				
				
			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestCompartilhamentoCardTextosArquivos2 AcaoStatusBug = new TestCompartilhamentoCardTextosArquivos2();
			AcaoStatusBug.Go();
			
		}

	}

}
