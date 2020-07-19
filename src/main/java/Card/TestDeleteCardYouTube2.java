package Card;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestDeleteCardYouTube2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				Framework Retestar = new Framework();
				Retestar.GoDeleteCardYouTube();

				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestDeleteCardYouTube.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestDeleteCardYouTube.Resumo);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);

			} catch (Throwable e) {
				
				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestDeleteCardYouTube.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
						
				System.out.println("Caso de Teste: ( TestDeleteCardYouTube )" + "\n" + "Retestado e aprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestDeleteCardYouTube )" + "\n" + "Retestado e reprovado!" + "\n");

			}

		} else {
			
			System.out.println("Caso de Teste: ( TestDeleteCardYouTube )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestDeleteCardYouTube )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");

		}

	}

}
