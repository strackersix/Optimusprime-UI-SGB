package GestaoEnergia;

import java.io.IOException;

import org.junit.Assert;

import GestaoEnergia.Framework;
import _CORE.Jira;
import _CORE.Parametros;

public class TestUsuarioExternoSemGrupoEconomicoGestaoEnergia2 {

	public void Go() throws InterruptedException, IOException {

		if (Parametros.statusBug.equalsIgnoreCase("Qualidade")) {

			try {

				Framework Retestar = new Framework();
				Retestar.Go();

				Jira Aprovado = new Jira ();
				Aprovado.UrlJira(Parametros.UrlJira);
				Aprovado.PesquisarTask(TestUsuarioExternoSemGrupoEconomicoGestaoEnergia.Resumo);
				Aprovado.AcessarBug();
				Aprovado.FinalizarBug();
				Aprovado.ComentarioAprovado();
				Aprovado.FinalizarBugArquivoTXT(TestUsuarioExternoSemGrupoEconomicoGestaoEnergia.BugArquivoTXT);
				Aprovado.Close();
				Aprovado.UrlJira(Parametros.UrlJira);
							
				System.out.println("Caso de Teste: ( TestUsuarioExternoSemGrupoEconomicoGestaoEnergia )" + "\n" + "Retestado e aprovado!" + "\n");
				
			} catch (Throwable e) {

				Jira Reprovado = new Jira();
				Reprovado.UrlJira(Parametros.UrlJira);
				Reprovado.PesquisarTask(TestUsuarioExternoSemGrupoEconomicoGestaoEnergia.Resumo);
				Reprovado.AcessarBug();
				Reprovado.ReprovarBug();
				Reprovado.ComentarioReprovado();
				Reprovado.Close();
				Reprovado.UrlJira(Parametros.UrlJira);

				Framework Step = new Framework();
				Step.Url(Parametros.UrlPowerView);
				Step.UsuarioLogado();
				Step.Sair();
				Step.Usuario(Parametros.UsuarioPowerView);
				Step.Senha(Parametros.SenhaPowerView);
				Step.Acessar();
				
				System.out.println("Caso de Teste: ( TestUsuarioExternoSemGrupoEconomicoGestaoEnergia )" + "\n" + "Retestado e reprovado!" + "\n");
				Assert.fail("Caso de Teste: ( TestUsuarioExternoSemGrupoEconomicoGestaoEnergia )" + "\n" + "Retestado e reprovado!" + "\n");
						
			}

		} else {
			
			System.out.println("Caso de Teste: ( TestUsuarioExternoSemGrupoEconomicoGestaoEnergia )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			Assert.fail("Caso de Teste: ( TestUsuarioExternoSemGrupoEconomicoGestaoEnergia )" + "\n" + "Possui bug e ainda não foi disponibilizado para a Qualidade retestar." + "\n");
			
		}

	}

}
