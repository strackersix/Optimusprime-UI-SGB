package Telemetria;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCardDemandaForaPonta {

	CardDemandaForaPonta Step = new CardDemandaForaPonta();

	static String Resumo = "Card Demanda Fora Ponta - Módulo: Telemetria";
	static String Descricao = "Ou o Protheus / API não responderam aos filtros de pesquisa, ou existe divergência entre o sistema e os dados que o robô espera."
							+ "\n" + "\n" + "Demanda Fora Ponta" + "\n" + "Máxima Registrada - 27/11/2019 14:45" + "\n" + "773,76 kW"
							+ "\n" + "Última Leitura" + "\n" + "453,12 kW" + "\n" + "Usado: 46,89%" + "\n" + "773,76 / 1.650,00 KW"
							+ "\n" + "\n" + "No screenshot anexo segue retorno do sistema para efeito de comparação da divergência."
							+ "Caso exista divergência de dados e for constatado que a base de dados de QA foi atualizada," 
							+ "\n" + "por favor comunicar a equipe de QA para que possamos atualizar o cenário de teste na automação.";
					public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestDemandaForaPonta\\existeBug.txt";

	@Test
	public void ExecutaDemandaForaPonta() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.BuArquivoTXT();

		if (Parametros.existeBug == false) {

			try {

				String Mes = "Nov";
				String Ano = "2019";
				String GrupoEconomico_5 = "POWERVIEW BALANCO";
				String GrupoEmpresa_5 = "POWERVIEW BALANCO";
				String GrupoUnidade_5 = "POWERVIEW BALANCO UNID 1";

				Step.MinhaConta();
				Step.Telemetria();

				int count = 1;
				int tentativa = 1;

				do {

					Step.GrupoEconomico(GrupoEconomico_5);
					Step.Empresa(GrupoEmpresa_5);
					Step.Unidade(GrupoUnidade_5);
					Step.Periodo(Mes, Ano);
					Step.WaitDashboard();

					--count;

				} while (count != 0);

				Thread.sleep(3000);

				Assert.assertEquals("Demanda Fora Ponta" + "\n" +
						"Máxima Registrada -" + "\n" +
						"0,00 kW" + "\n" +
						"Última Leitura" + "\n" + 
						"453,12 kW" + "\n" +
						"Usado: %" + "\n" +
						"/ KW", Step.DemandaPontaForaPonta());
							
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
				
				System.out.println("Caso de teste: ( TestCardDemandaPonta ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestCardDemandaPonta ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");

			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestCardDemandaForaPonta2 AcaoStatusBug = new TestCardDemandaForaPonta2();
			AcaoStatusBug.Go();

		}

	}

}
