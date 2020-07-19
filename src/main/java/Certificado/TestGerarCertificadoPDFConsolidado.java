package Certificado;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestGerarCertificadoPDFConsolidado {

	static String Resumo = "Gerar Certificado Consolidado em PDF.";
	static String Descricao = "Anexo segue screenshot do ponto de interrupção da tentativa do robo de gerar o Certificado."
			+ "\n" + "Em caso de dúvidas, favor contatar a equipe de QA.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestGerarCertificadoPDFConsolidado\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaGerarCertificado() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.BugArquivoTXT();

		if (Parametros.existeBug == false) {

			try {

				Step.MinhaConta();
				Step.Certificados();
				Step.PageDown();
				Step.GerarCertificadoOuRelatorio();
				Step.GrupoEconomico("POWERVIEW BALANCO");
				Step.AnoCertificado("2019");
				Step.IncluirRelatorio();
				Step.PortuguesIngles();
				Step.GerarCertificadoPDF();
				Step.WaitGerandoKitCertificado();

				Assert.assertEquals("Kit gerado com sucesso", Step.ValidaCertificadoPDF());

				Step.Ok();

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
				
				System.out.println("Caso de teste: ( TestGerarCertificadoPDFConsolidado ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestGerarCertificadoPDFConsolidado ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();

			TestGerarCertificadoPDFConsolidado2 AcaoStatusBug = new TestGerarCertificadoPDFConsolidado2();
			AcaoStatusBug.Go();
			
		}

	}

}
