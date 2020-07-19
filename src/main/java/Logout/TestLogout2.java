package Logout;

import org.junit.Assert;

import Logout.Framework;
import _CORE.Jira;
import _CORE.Parametros;


public class TestLogout2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {
								
				Framework Retestar = new Framework();
				Retestar.GoLogout();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestLogout.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestLogout.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlPowerView);
							
				System.out.println("Caso de Teste: ( TestLogout )" + "\n" + "Retestado e aprovado!" + "\n");
				
			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestLogout.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestLogout )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestLogout )" + "\n" + "Retestado e reprovado!" + "\n");
			
			}

		} else {
			
			System.out.println("Caso de Teste: ( TestLogout )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestLogout )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
						
		}

	}

}
