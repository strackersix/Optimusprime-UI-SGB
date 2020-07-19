package Telemetria;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCardDemandaPonta {

	static String Resumo = "Card Demanda Ponta - M�dulo: Telemetria";
	static String Descricao = "Ou o Protheus / API n�o responderam aos filtros de pesquisa, ou existe diverg�ncia entre o sistema e os dados que o rob� espera." + "\n" + "\n" + 
							  "Demanda Ponta" + "\n" + "M�xima Registrada - 28/11/2019 19:45" + "\n" + "760,32 kW" + "\n" +
							  "�ltima Leitura" + "\n" + "533,76 kW" + "\n" + "Usado: 46,08%" + "\n" + "760,32 / 1.650,00 KW" + "\n" + "\n" +
							  "No screenshot anexo segue retorno do sistema para efeito de compara��o da diverg�ncia." + "\n" 
							+ "Caso exista diverg�ncia de dados e for constatado que a base de dados de QA foi atualizada," 
							+ "\n" + "por favor comunicar a equipe de QA para que possamos atualizar o cen�rio de teste na automa��o.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestDemandaPonta\\existeBug.txt";

	CardDemandaPonta Step = new CardDemandaPonta();

	@Test
	public void ExecutaDemandaPonta() throws InterruptedException {

		String Mes = "Nov";
		String Ano = "2019";

		String GrupoEconomico_5 = "POWERVIEW BALANCO";
		String GrupoEmpresa_5 = "POWERVIEW BALANCO";
		String GrupoUnidade_5 = "POWERVIEW BALANCO UNID 1";

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT();

		if (Parametros.existeBug == false) {

			try {

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
				Assert.assertEquals("Demanda Ponta" + "\n" +
						"M�xima Registrada -" + "\n" +
						"0,00 kW" + "\n" +
						"�ltima Leitura" + "\n" + 
						"533,76 kW" + "\n" +
						"Usado: %" + "\n" +
						"/ KW", Step.CardDemandaPonta());

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
						
			TestCardDemandaPonta2 AcaoStatusBug = new TestCardDemandaPonta2();
			AcaoStatusBug.Go();
		
		}

	}

}
