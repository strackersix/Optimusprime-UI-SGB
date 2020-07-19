package Telemetria;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCardConsumoForaPonta2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.contentEquals("Qualidade")) {

			try {
				
				CardConsumoForaPonta Retestar = new CardConsumoForaPonta();
				Retestar.Go();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestCardConsumoForaPonta.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestCardConsumoForaPonta.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCardConsumoForaPonta )" + "\n" + "Retestado e aprovado!" + "\n");

			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestCardConsumoForaPonta.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);

				System.out.println("Caso de Teste: ( TestCardConsumoForaPonta )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestCardConsumoForaPonta )" + "\n" + "Retestado e reprovado!" + "\n");
								
			}

		} else {
			
			System.out.println("Caso de Teste: ( TestCardConsumoForaPonta )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestCardConsumoForaPonta )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");

		}

	}

}
