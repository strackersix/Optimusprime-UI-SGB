package Dashmaker;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestNovoDashmaker2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				Framework Retestar = new Framework();
				Retestar.Go();

				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestNovoDashmaker.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestNovoDashmaker.BugArquivoTXT);
				Aprovado.Close();

				System.out.println("Caso de Teste: ( TestNovoDashmaker )" + "\n" + "Retestado e aprovado!" + "\n");

			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestNovoDashmaker.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();

				System.out.println("Caso de Teste: ( TestNovoDashmaker )" + "\n" + "Retestado e aprovado!" + "\n" + "=..(" + "\n");
				Assert.fail("Caso de Teste: ( TestNovoDashmaker )" + "\n" + "Retestado e aprovado!" + "\n" + "=..(" + "\n");

			}

		} else {

			System.out.println("Caso de Teste: ( TestNovoDashmaker )" + "\n" + "Ainda não disponibilizado para a Qualidade retestar." + "\n" + "=..(" + "\n");
			Assert.fail("Caso de Teste: ( TestNovoDashmaker )" + "\n" + "Ainda não disponibilizado para a Qualidade retestar." + "\n" + "=..(" + "\n");
			
		}

	}

}
