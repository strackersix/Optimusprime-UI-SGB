package Telemetria;

import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

import org.junit.Assert;

public class TestGraficoPerfilCargaMes {

	static String Resumo = "Gr�fico: 'Perfil de Carga' dia 1 ao ultimo dia 30/11 - M�dulo: Telemetria";
	static String Descricao = "Ou o Protheus / API n�o responderam aos filtros de pesquisa, ou existe diverg�ncia entre o sistema e os dados que o rob� espera."
			+ "\n" + "\n" + "Dados aguardados pelo rob�: " + "\n" + "Empresa: Powerview Balanco Unid 1" + "\n"
			+ "Per�odo: " + " ( 01/11 a 30/11 16:45 )" + "\n" + "\n"
			+ "Anexo segue screenshot do ponto de interrup��o para avaliar se o problema est� no retorno dos filtros ou diverg�ncia no retorno dos registros do gr�fico de Perfil de Carga filtrado neste per�odo."
			+ "\n"
			+ "Caso exista diverg�ncia de dados e for constatado que a base de dados de QA foi atualizada, por favor comunicar a equipe de QA para que possamos atualizar este cen�rio de teste na automa��o.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestGraficoPerfilCargaMes\\existeBug.txt";

	GraficoPerfilCargaMes Step = new GraficoPerfilCargaMes();

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
				Step.PeriodoMes("1", "30");
				Step.WaitDashboard();

				Assert.assertEquals("30/11 16:45", Step.ValidaFatorPotenciaMes());

			} catch (Throwable e) {
				
				Jira TerroDoDev = new Jira();
				TerroDoDev.Screenshot();
				TerroDoDev.UrlJira(Parametros.UrlJira);
				TerroDoDev.IncluirTask();
				TerroDoDev.Projeto(Parametros.ProjetoPowerView);
				TerroDoDev.TipoItem(Parametros.TipoItem);
				TerroDoDev.Resumo(Resumo);
				TerroDoDev.Descricao(Descricao);
				TerroDoDev.Ambiente(Parametros.Ambiente);
				TerroDoDev.Upload();
				TerroDoDev.Criar();
				TerroDoDev.GravarBugArquivoTXT(BugArquivoTXT);
				
				System.out.println("Caso de teste: ( TestGraficoPerfilCargaMes ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestGraficoPerfilCargaMes ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");

			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestGraficoPerfilCargaMes2 AcaoStatusBug = new TestGraficoPerfilCargaMes2();
			AcaoStatusBug.Go();

		}

	}

}
