package Card;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCreateCardTextosArquivos2 {
	
	public void Go () throws InterruptedException {
		
		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {
			
			try {
				
				Framework Retestar = new Framework();
				Retestar.GoCreateCardTextosArquivos();
			
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestCreateCardTextosArquivos.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestCreateCardTextosArquivos.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCreateCardTextosArquivos )" + "\n" + "Retestado e aprovado!" + "\n");
			
			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestCreateCardTextosArquivos.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestCreateCardTextosArquivos )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail();
								
			}			
					
		} else {
		
			System.out.println("Caso de Teste: ( TestCreateCardTextosArquivos )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestCreateCardTextosArquivos )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
		
		}		
				
	}

}
