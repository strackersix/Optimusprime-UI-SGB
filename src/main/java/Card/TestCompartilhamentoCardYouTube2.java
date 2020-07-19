package Card;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCompartilhamentoCardYouTube2 {
	
	public void Go () throws InterruptedException {
		
		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {
			
			try {
			
				Framework Retestar = new Framework();
				Retestar.GoCompartilhamentoCardYouTube();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestCompartilhamentoCardYouTube.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestCompartilhamentoCardYouTube.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCompartilhamentoCardYouTube )" + "\n" + "Retestado e aprovado!" + "\n");
				
			} catch (Throwable e) {
				
				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestCompartilhamentoCardYouTube.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCompartilhamentoCardYouTube )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestCompartilhamentoCardYouTube )" + "\n" + "Retestado e reprovado!" + "\n");

			}
						
		} else {
			
			System.out.println("Caso de Teste: ( TestCompartilhamentoCardYouTube )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestCompartilhamentoCardYouTube )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");

		}
		
		
	}

}
