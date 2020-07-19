package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestPesquisarCardAntigo {

	static String Resumo = "Pesquisar Card Antigo.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de pesquisa de um card antigo foi interrombido."
			+ "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestPesquisarCardAntigo\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaPesquisarCardAntigo() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.MeuPergil();
				Step.Conteudo();
				Step.Cards();
				Step.Pesquisar("Finalmente o Bearned nasceu!");

				Assert.assertEquals("8 Finalmente o Bearned nasceu! Notícias Vinicius Luiz 02/09/2016 21:09",
						Step.ValidaPesquisa());

				Step.AbrirCard();
				Step.AlternarAbaIndice1();

				try {

					Assert.assertEquals("Finalmente o Bearned nasceu!", Step.ValidaCardAntigo());
					Step.FecharAbaAtual();
					Step.AlternarAbaIndice0();

				} catch (Throwable e) {

					Step.FecharAbaAtual();
					Step.AlternarAbaIndice0();

				}
							
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
				
				System.out.println("Caso de teste: ( TestPesquisarCardAntigo ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestPesquisarCardAntigo ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			
			TestPesquisarCardAntigo2 AcaoStatusBug = new TestPesquisarCardAntigo2();
			AcaoStatusBug.Go();

		}

	}
}
