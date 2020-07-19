package Card;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCreateCardLink {

	static String Resumo = "CREATE - Card do tipo: 'Link'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de criação do Card Link foi interrompido." + "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestCreateCardLink\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaTestIncluirCardLink() throws IOException, InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.Publicar();
				Step.Link();
				Step.InserirLink("https://www.doc88.com.br/institucional");
				Step.CarregarLink();
				Step.Categoria("Notícias");
				Step.ComentarioPost("Excelente PME para se trabalhar.");
				Step.Grupo("Doc88");
				Step.PublicarCard();

				Assert.assertEquals("DOC88 - Institucional", Step.ValidaCreatCardLink());

			} catch (Throwable e) {

				Jira TerrorDoDev = new Jira();
				TerrorDoDev.Screenshot();
				TerrorDoDev.UrlJira(Parametros.UrlJira);
				TerrorDoDev.IncluirTask();
				TerrorDoDev.Projeto(Parametros.ProjetoPowerView);
				TerrorDoDev.Resumo(Resumo);
				TerrorDoDev.Descricao(Descricao);
				TerrorDoDev.Upload();
				TerrorDoDev.Criar();
				TerrorDoDev.GravarBugArquivoTXT(BugArquivoTXT);

				System.out.println("Caso de Teste: ( TestCreateCardLink ) com problema!" + "\n" + "Registrado Bug no Jira.");
				Assert.fail("Caso de Teste: ( TestCreateCardLink ) com problema!" + "\n" + "Registrado Bug no Jira.");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
						
			TestCreateCardLink2 AcaoStatusBug = new TestCreateCardLink2();
			AcaoStatusBug.Go();
			
		}

	}

}
