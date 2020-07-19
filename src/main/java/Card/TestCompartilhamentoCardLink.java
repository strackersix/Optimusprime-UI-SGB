package Card;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCompartilhamentoCardLink {

	 static String Resumo = "COMPARTILHAMENTO - Card do tipo: 'Link'.";
	 static String Descricao = "Segue anexo Screenshot do momento em que o processo de Compartilhamento do Card Link foi interrompido." + "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	 static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestCompartilhamentoCard\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaTestUpdateCard() throws InterruptedException, IOException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.AlterarCard();
				Step.Categoria("Doc88 Informa");
				Step.Grupo("Doc88");
				Step.Compartilhar();

				Assert.assertEquals("DOC88 INFORMA", Step.ValidaAlteracaoCategoria());
							
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
				
				System.out.println("Caso de Teste: ( TestCompartilhamentoCardLink ) com problema!" + "\n" + "Registrado Bug no Jira.");
				Assert.fail("Caso de Teste: ( TestCompartilhamentoCardLink ) com problema!" + "\n" + "Registrado Bug no Jira.");
								
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestCompartilhamentoCardLink2 AcaoStatusBug = new TestCompartilhamentoCardLink2();
			AcaoStatusBug.Go();

		}

	}

}
