package Card;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestReadCardYoutube2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {
				
				Framework Retestar = new Framework();
				Retestar.GoReadCardYoutube();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestReadCardYoutube.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestReadCardYoutube.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);

				System.out.println("Caso de Teste: ( TestReadCardYoutube )" + "\n" + "Retestado e aprovado!" + "\n");
				
			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestReadCardYoutube.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestReadCardYoutube )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestReadCardYoutube )" + "\n" + "Retestado e reprovado!" + "\n");
								
			}

		} else {
			
			System.out.println("Caso de Teste: ( TestReadCardYoutube )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestReadCardYoutube )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			
		}

	}

}
