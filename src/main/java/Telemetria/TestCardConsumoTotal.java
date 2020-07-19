package Telemetria;

import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

import org.junit.Assert;

public class TestCardConsumoTotal {

	static String Resumo = "Card Consumo Total - Módulo: Telemetria";
	static String Descricao = "Ou o Protheus / API não responderam aos filtros de pesquisa, ou existe divergência entre o sistema e os dados que o robô espera."
							+ "\n" + "\n" + "Consumo Total" + "\n" + "Ponta + Fora Ponta" + "\n" + "404,379 MWh" + "\n" + "\n"
							+ "\n" + "\n" + "No screenshot anexo segue retorno do sistema para efeito de comparação da divergência." + "\n"
							+ "Caso exista divergência de dados e for constatado que a base de dados de QA foi atualizada," 
							+ "\n" + "por favor comunicar a equipe de QA para que possamos atualizar o cenário de teste na automação.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestConsumoTotal\\existeBug.txt";

	CardConsumoTotal Step = new CardConsumoTotal();

	@Test
	public void ExecutaConsumoTotal() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.BugArquivoTXT();
		
		if (Parametros.existeBug == false) {

			try {

				String Mes = "Nov";
				String Ano = "2019";
				String GrupoEconomico_5 = "POWERVIEW BALANCO";
				String GrupoEmpresa_5 = "POWERVIEW BALANCO";
				String GrupoUnidade_5 = "POWERVIEW BALANCO UNID 1";

				Step.MinhaConta();
				Step.Telemetria();
//				Step.OpenInspecionarF12();

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

				Assert.assertEquals("Consumo Total" + "\n" +
									"Ponta + Fora Ponta" + "\n" + 
									"404,379 MWh", Step.CardConsumoTotal());
				
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
				
				System.out.println("Caso de teste: ( TestCardConsumoTotal ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestCardConsumoTotal ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");

			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);

			TestCardConsumoTotal2 AcaoStatusBug = new TestCardConsumoTotal2();
			AcaoStatusBug.Go();
			
		}

	}

}
