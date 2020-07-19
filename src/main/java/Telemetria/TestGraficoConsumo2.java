package Telemetria;

import org.junit.Assert;

import _CORE.Jira;
import _CORE.Parametros;

public class TestGraficoConsumo2 {
	
	public void Go () throws InterruptedException {
		
		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {
			
			try {
	
				GraficoConsumo Retestar = new GraficoConsumo();
				Retestar.Go();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestGraficoConsumo.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestGraficoConsumo.BugArquivoTXT);
				Aprovado.Close();
				
				System.out.println("Caso de Teste: ( TestGraficoConsumo )" + "\n" + "Retestado e Aprovado!" + "\n");
				
			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestGraficoConsumo.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				
				System.out.println("Caso de Teste: ( TestGraficoConsumo )" + "\n" + "Retestado e Reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestGraficoConsumo )" + "\n" + "Retestado e Reprovado!" + "\n");
				
			}
					
		} else {

			System.out.println("Caso de Teste: ( TestGraficoConsumo )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestGraficoConsumo )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
					
		}
		
	}

}
