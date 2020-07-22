package Login;

import java.io.IOException;

import org.junit.Assert;

import Login.Framework;
import _CORE.DriverFactory;
import _CORE.Jira;
import _CORE.Parametros;

public class TestLogin2 {

	
	public void Go ( String Url ) throws InterruptedException, IOException {
		
	
		if ( Parametros.statusBug.equalsIgnoreCase("Qualidade") ) {
					
			try {
				
				Framework Retestar = new Framework();
				Retestar.GoLogin();
				
				Jira Aprovado = new Jira();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestLogin.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestLogin.BugArquivoTXT);
				Aprovado.Close();				
								
				System.out.println("Caso de Teste ( TestLogin )" + "\n" + "Retestado e aprovado" + "\n");
								
			} catch (Throwable e) {
				
				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestLogin.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);
				
				System.out.println("Caso de Teste: ( TestLogin )" + "\n" + "Retestado e reprovado" + "\n");
				DriverFactory.finalizarDriverFactory(); Assert.fail("Caso de Teste ( TestLogin )" + "\n" + "Retestado e reprovado" + "\n"); 
									
			}
					
		} else {

			System.out.println("Caso de Teste: ( TestLogin )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar."  );
			DriverFactory.finalizarDriverFactory(); Assert.fail(TestLogin.Resumo + "\n" + TestLogin.Descricao); 
						
		}
				
	}
			
}
