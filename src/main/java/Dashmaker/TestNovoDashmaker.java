package Dashmaker;

import java.io.IOException;

import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

import org.junit.Assert;

public class TestNovoDashmaker {

	static String Resumo = "Erro ao criar um novo Dashmaker";
	static String Descricao = "Anexo segue evidência do ocorrido." + "\n" + "\n"
			+ "Em caso de duvidas, por favor comunicar a equipe de QA.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestNovoDashmaker\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaTestNovoDashmaker() throws InterruptedException, IOException {

		Step.Url(Parametros.UrlPowerView);
		Step.BugArquivoTXT();

		if (Parametros.existeBug == false) {

			try {
				
				Step.Url(Parametros.UrlPowerView);
				Step.MeuUsuario();
				Step.Dashmaker();
				Step.BtnDashMaker();
				Step.Titulo("Quality Assurance.");

			} catch (Throwable e) {

				Jira TerrorDoDev = new Jira();
				TerrorDoDev.ScreeshotNewRelic();
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
				
				System.out.println("Caso de Teste: ( TestNovoDashmaker ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n" + "=..(" + "\n");
				Assert.fail("Caso de Teste: ( TestNovoDashmaker ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n" + "=..(" + "\n");
				
			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			
			TestNovoDashmaker2 AcaoStatusBug = new TestNovoDashmaker2();
			AcaoStatusBug.Go();
			
		}

	}

}
