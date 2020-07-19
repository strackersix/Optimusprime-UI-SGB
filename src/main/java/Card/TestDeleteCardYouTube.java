package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestDeleteCardYouTube {

	static String Resumo = "DELETE - Card do tipo: 'YouTube'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de exclusão do Card YouTube foi interrompido."
			+ "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestDeleteCardYouTube\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaDeleteCardYouTube() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.DeleteCard();
				Step.DeleteCard();
				
				Assert.assertNotEquals("Como Criamos o Futuro  - Metodologia", Step.ValidaExclusao());

			} catch (Throwable e) {

				Jira TerrorDoDev = new Jira();
				TerrorDoDev.Screenshot();
				TerrorDoDev.UrlJira(Parametros.UrlJira);
				TerrorDoDev.IncluirTask();
				TerrorDoDev.Projeto(Parametros.ProjetoPowerView);
				TerrorDoDev.TipoItem(Parametros.TipoItem);
				TerrorDoDev.Resumo(Resumo);
				TerrorDoDev.Descricao(Descricao);
				TerrorDoDev.Ambiente(Parametros.Ambiente);
				TerrorDoDev.Upload();
				TerrorDoDev.Criar();
				TerrorDoDev.GravarBugArquivoTXT(BugArquivoTXT);
				
				System.out.println("Caso de teste: ( TestDeleteCardYouTube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestDeleteCardYouTube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);

			TestDeleteCardYouTube2 AcaoStatusBug = new TestDeleteCardYouTube2();
			AcaoStatusBug.Go();

		}

	}
}
