package Card;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCreateCardYouTube2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {
				
				Framework Retestar = new Framework();
				Retestar.GoCreateCardYouTube();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestCreateCardYouTube.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestCreateCardYouTube.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);
		
				System.out.println("Caso de Teste: ( TestCreateCardYouTube )" + "\n" + "Retestado e aprovado!" + "\n");
				
			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestCreateCardYouTube.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCreateCardYouTube )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestCreateCardYouTube )" + "\n" + "Retestado e reprovado!" + "\n");
				
			}

		} else {
			
			System.out.println("Caso de Teste: ( TestCreateCardYouTube )" + "\n" + "Possui bug e ainda n�o foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestCreateCardYouTube )" + "\n" + "Possui bug e ainda n�o foi disponibilizado para a Qualidade retestar." + "\n");
			
		}

	}

}
