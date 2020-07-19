package Card;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestReadCardLink2 {

	public void Go() throws InterruptedException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				Framework Retestar = new Framework();
				Retestar.GoReadCardLink();

				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestReadCardLink.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestReadCardLink.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);

				System.out.println("Caso de Teste: ( TestReadCardLink )" + "\n" + "Retestado e aprovado!");

			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestReadCardLink.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);

				System.out.println("Caso de Teste: ( TestReadCardLink )" + "\n" + "Retestado e reprovado!");
				Assert.fail("Caso de Teste: ( TestReadCardLink )" + "\n" + "Retestado e reprovado!");

			}

		} else {
			
			System.out.println("Caso de Teste: ( TestReadCardLink )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestReadCardLink )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			
		}

	}

}
