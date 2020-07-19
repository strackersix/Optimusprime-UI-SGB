package Telemetria;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestGraficoPerfilCarga {

	static String Resumo = "Gráfico: 'Perfil de Carga' - Módulo: Telemetria";
	static String Descricao = "Ou o Protheus / API não responderam aos filtros de pesquisa, ou existe divergência entre o sistema e os dados que o robô espera."
			+ "\n" + "\n" + "Dados aguardados pelo robô: " + "\n" + "Empresa: Powerview Balanco Unid 1" + "\n" + "Período: " + "'01/11 0...' a '07/11 21:15'." + "\n" + "\n"
			+ "Anexo segue screenshot do ponto de interrupção para avaliar se o problema está no retorno dos filtros, retorno do período esperado ou com a plotagem do gráfico." + "\n"
			+ "Caso exista divergência de dados e for constatado que a base de dados de QA foi atualizada, por favor comunicar a equipe de QA para que possamos atualizar este cenário de teste na automação.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestGraficoPerfilCarga\\existeBug.txt";

	GraficoPerfilCarga Step = new GraficoPerfilCarga();

	@Test
	public void ExecutaCardPerfilCarga() throws InterruptedException {

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

				Assert.assertEquals("01/11 0…", Step.PerfilCargaDia1());
				Assert.assertEquals("07/11 21:15", Step.PerfilCargaDia7());

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

				System.out.println("Caso de teste: ( TestGraficoPerfilCarga ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestGraficoPerfilCarga ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestGraficoPerfilCarga2 AcaoStatusBug = new TestGraficoPerfilCarga2();
			AcaoStatusBug.Go();
			
		}

	}

}
