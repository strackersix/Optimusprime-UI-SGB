package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCompartilhamentoCardYouTube {

	static String Resumo = "COMPARTILHAMENTO - Card do tipo: 'YouTube'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de Compartilhamento do Card YouTube foi interrompido."
			+ "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestCompartilhamentoCardYouTube\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaCompartilhamentoCardYouTube() throws InterruptedException {

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
				
				Jira TerroDoDev = new Jira();
				TerroDoDev.Screenshot();
				TerroDoDev.UrlJira(Parametros.UrlJira);
				TerroDoDev.IncluirTask();
				TerroDoDev.Projeto(Parametros.ProjetoPowerView);
				TerroDoDev.TipoItem(Parametros.TipoItem);
				TerroDoDev.Resumo(Resumo);
				TerroDoDev.Descricao(Descricao);
				TerroDoDev.Ambiente(Parametros.Ambiente);
				TerroDoDev.Upload();
				TerroDoDev.Criar();
				TerroDoDev.GravarBugArquivoTXT(BugArquivoTXT);		

				System.out.println("Caso de teste: ( TestCompartilhamentoCardYouTube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestCompartilhamentoCardYouTube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");

			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestCompartilhamentoCardYouTube2 AcaoStatusBug = new TestCompartilhamentoCardYouTube2();
			AcaoStatusBug.Go();
			
		}

	}

}
