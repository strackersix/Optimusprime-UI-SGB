package Telemetria;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestGraficoPerfilCargaMaximaDia {

	static String Resumo = "Gráfico: 'Perfil de Carga' - Módulo: Telemetria";
	static String Descricao = "Ou o Protheus / API não responderam aos filtros de pesquisa, ou existe divergência entre o sistema e os dados que o robô espera."
			+ "\n" + "\n" + "Dados aguardados pelo robô: " + "\n" + "Empresa: Powerview Balanco Unid 1" + "\n"
			+ "Período: " + "'01/11 0...' e o checkbox Máxima do dia flegado. " + "\n" + "\n"
			+ "Anexo segue screenshot do ponto de interrupção para avaliar se o problema está no retorno dos filtros, divergência no retorno dos registros esperados."
			+ "\n"
			+ "Caso exista divergência de dados e for constatado que a base de dados de QA foi atualizada, por favor comunicar a equipe de QA para que possamos atualizar este cenário de teste na automação.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestGraficoPerfilCargaMaximaDia\\existeBug.txt";

	GraficoPerfilCargaMaximaDia Step = new GraficoPerfilCargaMaximaDia();

	@Test
	public void ExecutaGraficoPerfilCargaMes() throws InterruptedException {

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
				Step.MaximaDia();

				Assert.assertEquals("2019-11-01" + "\n" + "2019-11-06" + "\n" + "2019-11-11" + "\n" + "2019-11-16"
						+ "\n" + "2019-11-21" + "\n" + "2019-11-26", Step.ValidaGraficoPerfilCargaMes());

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
				
				System.out.println("Caso de teste: ( TestGraficoPerfilCargaMaximaDia ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestGraficoPerfilCargaMaximaDia ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");

			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestGraficoPerfilCargaMaximaDia2 AcaoStatusBug = new TestGraficoPerfilCargaMaximaDia2();
			AcaoStatusBug.Go();
			
		}

	}

}
