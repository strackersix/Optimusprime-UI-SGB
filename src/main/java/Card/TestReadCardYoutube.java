package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestReadCardYoutube {

	static String Resumo = "READ - Card do tipo: 'YouTube.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de pesquisa / leitura do Card YouTube foi interrompido."
			+ "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestReadCardYoutube\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaReadCardYoutube() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.Pesquisar();
				Step.Categoria("Notícias");
				Step.Grupo("Doc88");
				Step.Descricao("Como Criamos o Futuro  - Metodologia");
				Step.BtnPesquisar();

				Assert.assertEquals("Como Criamos o Futuro - Metodologia", Step.ValidaCreatCardLink());

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
				
				System.out.println("Caso de teste: ( TestReadCardYoutube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestReadCardYoutube ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestReadCardYoutube2 AcaoStatusBug = new TestReadCardYoutube2();
			AcaoStatusBug.Go();
					
			

		}

	}

}
