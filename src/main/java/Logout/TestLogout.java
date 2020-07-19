package Logout;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import Logout.Framework;
import _CORE.Jira;
import _CORE.Parametros;

public class TestLogout {

	static String Resumo = "Erro ao efetuar Logout.";
	static String Descricao = "O sistema apresentou problema no processo de Logout, anexo segue screenshot do ponto de interrupção do robo."
			+ "\n" + "Em caso de dúvidas favor contatar a equipe de QA.";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestLogout\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void LogoutTest() throws InterruptedException, IOException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT();

		if (Parametros.existeBug == false) {

			try {

				Step.Url(Parametros.UrlPowerView);
				Step.UsuarioLogado();
				Step.Sair();

				Assert.assertEquals("Acessar Blue PowerView", Step.ValidacaoLogout());

			} catch (Throwable e) {

				Jira TerrorDoDev = new Jira();
				TerrorDoDev.Screenshot();
				TerrorDoDev.UrlJira(Parametros.UrlJira);
				TerrorDoDev.IncluirTask();
				TerrorDoDev.Projeto(Parametros.ProjetoPowerView);
				TerrorDoDev.TipoItem(Parametros.TipoItem);
				TerrorDoDev.Resumo(Resumo);
				TerrorDoDev.Ambiente(Parametros.Ambiente);
				TerrorDoDev.Descricao(Descricao);
				TerrorDoDev.Upload();
				TerrorDoDev.Criar();
				TerrorDoDev.GravarBugArquivoTXT(BugArquivoTXT);

				System.out.println("Caso de teste: ( TestLogout ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestLogout ) com problema!" + "\n" + "Registrado Bug no Jira." + "\n");

			}

		} else {

			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();

			TestLogout2 AcaoStatusBug = new TestLogout2();
			AcaoStatusBug.Go();
			
		}

	}

}
