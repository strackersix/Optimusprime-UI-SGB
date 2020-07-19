package Telemetria;

import org.junit.Assert;
import org.junit.Test;

import Telemetria.FiltrosPesquisaTelemetria;
import _CORE.Jira;
import _CORE.Parametros;

public class TestFiltrosPesquisaTelemetria {

	static String Resumo = "Filtros de Pesquisas da Telemetria - Módulo: Telemetria";
	static String Descricao = "Anexo segue screenshot do ponto de interrupção do robô, para verificar porque que um dos filtros de pesquisa não responderam, "
							+ "ou até mesmo porque que o módulo: Telemetria nem chegou a abrir se for o caso.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestFiltrosPesquisaTelemetria\\existeBug.txt";
	
	FiltrosPesquisaTelemetria Step = new FiltrosPesquisaTelemetria();

	@Test
	public void ExecutaTelemetriaFiltro() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.BugArquivoTXT();
		
		if (Parametros.existeBug == false) {

			try {

				String Mes = "Nov";
				String Ano = "2019";

				String GrupoEconomico_1 = "AJINOMOTO";
				String GrupoEmpresa_1 = "AJINOMOTO";
				String GrupoUnidade_1 = "AJINOMOTO LARANJAL";

				String GrupoEconomico_2 = "JBS";
				String GrupoEmpresa_2 = "JBS";
				String GrupoUnidade_2 = "FRIBOI - BARRA DO GARCAS";

				String GrupoEconomico_3 = "ALPEX";
				String GrupoEmpresa_3 = "ALPEX";
				String GrupoUnidade_3 = "ALPEX";

				String GrupoEconomico_4 = "ASB BEBIDAS";
				String GrupoEmpresa_4 = "ASB BEBIDAS";
				String GrupoUnidade_4 = "ASB STA BARBARA";

				String GrupoEconomico_5 = "POWERVIEW BALANCO";
				String GrupoEmpresa_5 = "POWERVIEW BALANCO";
				String GrupoUnidade_5 = "POWERVIEW BALANCO UNID 1";

				Step.MinhaConta();
				Step.Telemetria();
				
				int count = 1;
				int tentativa = 1;

				do {

					Step.GrupoEconomico(GrupoEconomico_1);
					Step.Empresa(GrupoEmpresa_1);
					Step.Unidade(GrupoUnidade_1);
					Step.Periodo(Mes, Ano);
					Step.WaitDashboard();

					Step.GrupoEconomico(GrupoEconomico_2);
					Step.Empresa(GrupoEmpresa_2);
					Step.Unidade(GrupoUnidade_2);
					Step.Periodo(Mes, Ano);
					Step.WaitDashboard();

					Step.GrupoEconomico(GrupoEconomico_3);
					Step.Empresa(GrupoEmpresa_3);
					Step.Unidade(GrupoUnidade_3);
					Step.Periodo(Mes, Ano);
					Step.WaitDashboard();

					Step.GrupoEconomico(GrupoEconomico_4);
					Step.Empresa(GrupoEmpresa_4);
					Step.Unidade(GrupoUnidade_4);
					Step.Periodo(Mes, Ano);
					Step.WaitDashboard();

					Step.GrupoEconomico(GrupoEconomico_5);
					Step.Empresa(GrupoEmpresa_5);
					Step.Unidade(GrupoUnidade_5);
					Step.Periodo(Mes, Ano);
					Step.WaitDashboard();

					--count;

				} while (count != 0);
				

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
				
				System.out.println("Caso de teste: ( TestFiltrosPesquisaTelemetria ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestFiltrosPesquisaTelemetria ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);

			TestFiltrosPesquisaTelemetria2 AcaoStatusBug = new TestFiltrosPesquisaTelemetria2();
			AcaoStatusBug.Go();
			
		}

	}

}
