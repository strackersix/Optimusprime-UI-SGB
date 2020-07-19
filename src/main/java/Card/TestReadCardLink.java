package Card;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestReadCardLink {

	static String Resumo = "READ - Card do tipo: 'Link'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de pesquisa / leitura do Card Link foi interrompido." + "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestReadCardLink\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaTestReadCardLink() throws InterruptedException, IOException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.Pesquisar();
				Step.Categoria("Notícias");
				Step.Grupo("Doc88");
				Step.Descricao("Doc88 - Institucional");
				Step.BtnPesquisar();

				Assert.assertEquals("DOC88 - Institucional", Step.ValidaCreatCardLink());
				Assert.assertEquals("Excelente PME para se trabalhar.", Step.ValidaCreatCardComentario());

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
				
				System.out.println("Caso de Teste: ( TestReadCardLink ) com problema!" + "\n" + "Registrado Bug no Jira.");
				Assert.fail("Caso de Teste: ( TestReadCardLink )" + "\n" + "Registrado Bug no Jira.");				
				
			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestReadCardLink2 AcaoStatusBug = new TestReadCardLink2();
			AcaoStatusBug.Go();
			
		}

	}

}
