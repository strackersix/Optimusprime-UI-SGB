package Card;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCreateCardLink2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				Framework Retestar = new Framework();
				Retestar.GoCreateCardLink();

				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestCreateCardLink.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestCreateCardLink.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);

				System.out.println("Caso de Teste: ( TestCreateCardLink )" + "\n" + "Retestado e aprovado!");

			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestCreateCardLink.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);

				System.out.println("Caso de Teste: ( TestCreateCardLink )" + "\n" + "Retestado e reprovado!");
				Assert.fail("Caso de Teste: ( TestCreateCardLink )" + "\n" + "Retestado e reprovado!");

			}

		} else {

			System.out.println("Caso de Teste: ( TestCreateCardLink )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar.");
			Assert.fail("Caso de Teste: ( TestCreateCardLink )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar.");
			
		}

	}

}
