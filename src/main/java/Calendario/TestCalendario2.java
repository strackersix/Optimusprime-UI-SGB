package Calendario;

import java.io.IOException;

import org.junit.Assert;

import _CORE.*;

public class TestCalendario2 extends BasePage {

	
	public void Go (String url) throws InterruptedException, IOException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				Framework Retestar = new Framework();
				Retestar.Go();

				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestCalendario.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.FinalizarBugArquivoTXT(TestCalendario.BugArquivoTXT);

				System.out.println("Caso de teste aprovado!!!" + "\n" + "<<< Bug Resolvido. >>>");

			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestCalendario.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				
				System.out.println("<<< Bug disponibilizado para a Qualidade, foi retestado e o problema persiste. Bug Reprovado. >>>");

				Framework Erro = new Framework();
				Erro.Sim();

			}

		} else {

			System.out.println("<<< Bug ainda não disponibilizado para a Qualidade Retestar. >>>");

			Assert.fail("<<< Bug ainda não disponibilizado para a Qualidade Retestar. >>>");

		}

	}

}
