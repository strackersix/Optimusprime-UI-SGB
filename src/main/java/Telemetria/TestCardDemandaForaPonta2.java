package Telemetria;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCardDemandaForaPonta2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				CardDemandaForaPonta Retestar = new CardDemandaForaPonta();
				Retestar.Go();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestCardDemandaForaPonta.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestCardDemandaForaPonta.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCardDemandaForaPonta )" + "\n" + "Retestado e aprovado!" + "\n");
								
			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask("");
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCardDemandaForaPonta )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestCardDemandaForaPonta )" + "\n" + "Retestado e reprovado!" + "\n");
				
			}

		} else {
			
			System.out.println("Caso de Teste: ( TestCardDemandaForaPonta )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestCardDemandaForaPonta )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");

		}

	}

}
