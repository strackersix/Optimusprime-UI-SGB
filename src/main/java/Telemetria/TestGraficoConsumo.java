package Telemetria;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestGraficoConsumo {

	static String Resumo = "Gr�fico: 'Consumo' - M�dulo: Telemetria";
	static String Descricao = "Ou o Protheus / API n�o responderam aos filtros de pesquisa, ou existe diverg�ncia entre o sistema e os dados que o rob� espera."
			+ "\n" + "\n" + "Dados aguardados pelo rob�: " + "\n" + "Empresa: Powerview Balanco Unid 1" + "\n"
			+ "Per�odo: " + "'01/11 0...' a '07/11'." + "\n" + "\n"
			+ "Anexo segue screenshot do ponto de interrup��o para avaliar se o problema est� no retorno dos filtros, retorno do per�odo esperado ou com a plotagem do gr�fico."
			+ "\n"
			+ "Caso exista diverg�ncia de dados e for constatado que a base de dados de QA foi atualizada, por favor comunicar a equipe de QA para que possamos atualizar este cen�rio de teste na automa��o.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestGraficoConsumo\\existeBug.txt";

	GraficoConsumo Step = new GraficoConsumo();

	@Test
	public void ExecutaGraficoConsumo() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.BugArquivoTXT();

		if (Parametros.existeBug == false) {

			try {

				Step.MinhaConta();
				Step.Telemetria();
				Step.GrupoEconomico("POWERVIEW BALANCO");
				Step.Empresa("POWERVIEW BALANCO");
				Step.Unidade("POWERVIEW BALANCO UNID 1");
				Step.Periodo("Nov", "2019");
				Step.WaitDashboard();
				Step.PageDown();

				Assert.assertEquals("01/11 01:�", Step.ConsumoDia1());
				Assert.assertEquals("07/11 22:00", Step.ConsumoDia7());

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
				
				System.out.println("Caso de Teste: ( TestGraficoConsumo ) com problema!" + "\n" + "Registrado bug no Jira." + "\n");
				Assert.fail("Caso de Teste: ( TestGraficoConsumo ) com problema!" + "\n" + "Registrado bug no Jira." + "\n");

			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			
			TestGraficoConsumo2 AcaoStatusBug = new TestGraficoConsumo2();
			AcaoStatusBug.Go();
						
		}

	}

}
