package Telemetria;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestFiltrosPesquisaTelemetria2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				FiltrosPesquisaTelemetria Retestar = new FiltrosPesquisaTelemetria();
				Retestar.Go();

				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestFiltrosPesquisaTelemetria.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestFiltrosPesquisaTelemetria.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);

				System.out.println("Caso de Teste: ( TestFiltrosPesquisaTelemetria )" + "\n" + "Retestado e aprovado!" + "\n");

			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestFiltrosPesquisaTelemetria.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestFiltrosPesquisaTelemetria )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
				Assert.fail("Caso de Teste: ( TestFiltrosPesquisaTelemetria )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");

			}

		} else {
			
			System.out.println("Bug ainda não disponibilizado para a Qualidade Retestar.");
			Assert.fail("Bug ainda não disponibilizado para a Qualidade Retestar.");

		}

	}

}
