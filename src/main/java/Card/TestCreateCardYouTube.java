package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCreateCardYouTube {

	static String Resumo = "CREATE - Card do tipo: 'YouTube'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de criação do Card YouTube foi interrompido." + "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestCreateCardYouTube\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaCreateCardYouTube() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.Publicar();
				Step.YouTube();
				Step.LinkYoutube("https://www.youtube.com/watch?v=4wiSvq1FvI8");
				Step.CarregarYouTube();
				Step.Categoria("Notícias");
				Step.Grupo("Doc88");
				Step.ComentarioPost("Doc 88");
				Step.PublicarCard();

				Assert.assertEquals("Como Criamos o Futuro - Metodologia", Step.ValidaCard());

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
				
				System.out.println("Caso de teste: ( TestCreateCardYouTube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestCreateCardYouTube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
					
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestCreateCardYouTube2 AcaoStatusBug = new TestCreateCardYouTube2();
			AcaoStatusBug.Go();
			
		}

	}

}
