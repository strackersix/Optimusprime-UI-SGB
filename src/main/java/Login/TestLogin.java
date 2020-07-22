package Login;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import Login.Framework;
import _CORE.DriverFactory;
import _CORE.Jira;
import _CORE.Parametros;

public class TestLogin {

		static String Resumo = "Erro ao efetuar Login.";
		static String Descricao = "O sistema está apresentando problemas no processo de Login. Anexo segue evidência do problema.";
 public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestLogin\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecuteTestLogin() throws InterruptedException, IOException {

		Step.TrocarMonitor();
		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT();

		if ( Parametros.existeBug == false ) {

			try {

				Step.Usuario(Parametros.UsuarioPowerView);
				Step.Senha(Parametros.SenhaPowerView);
				Step.BtnAcessar();	
				
				Assert.assertEquals("Gabriel Oliveira Conrado de Souza", Step.ConfirmaNome());
				
				Thread.sleep(1000);
				
				Step.PermitirNotificacoes();
								
			} catch ( Throwable e) {

				Jira TerrorDoDev = new Jira();
				TerrorDoDev.Screenshot();
				TerrorDoDev.UrlJira(Parametros.UrlJira);
				TerrorDoDev.IncluirTask();
				TerrorDoDev.Projeto(Parametros.ProjetoPowerView);
				TerrorDoDev.TipoItem(Parametros.TipoItem);
				TerrorDoDev.Resumo(Resumo);
				TerrorDoDev.Ambiente(Parametros.Ambiente);
				TerrorDoDev.Descricao(Descricao);
				TerrorDoDev.Upload();
				TerrorDoDev.Criar();
				TerrorDoDev.GravarBugArquivoTXT(BugArquivoTXT);

				System.out.println("Caso de teste: ( TestLogin ) com problema!");
				DriverFactory.finalizarDriverFactory(); Assert.fail("Caso de teste: ( TestLogin ) com problema!");
										
			}

		} else {
			
			Jira Verifica_Status_Bug = new Jira();
			Verifica_Status_Bug.UrlJira(Parametros.UrlJira);
			Verifica_Status_Bug.PesquisarTask(Resumo);
			Verifica_Status_Bug.AcessarBug();
			Verifica_Status_Bug.CapturarStatusBug();
			Verifica_Status_Bug.UrlJira(Parametros.UrlJira);
			
			TestLogin2 AcaoStatusBug = new TestLogin2();
			AcaoStatusBug.Go(Parametros.UrlJira);
						
		}
				
	}

}
