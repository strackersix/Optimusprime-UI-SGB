package GestaoEnergia;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import GestaoEnergia.Framework;
import _CORE.Jira;
import _CORE.Parametros;

public class TestUsuarioExternoSemGrupoEconomicoGestaoEnergia {

		   static String Resumo = "Acesso indevido ao m�dulo: Gest�o de Energia.";
		   static String Descricao = "Usu�rio externo sem um Grupo Econ�mico vinculado n�o pode ter acesso a este m�dulo." + "\n" + "RESULTADO ESPERADO:" + "\n" + "O sistema deve abrir o m�dulo Gest�o de Energia e bloquear a consulta retornando a seguinte mensagem ap�s o filtro de pesquisa: �Nada encontrado�." + "\n" + "Qualquer retorno diferente disto, significa que o sistema est� com problemas por ter se comportado de forma inesperada";
	public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestUsuarioExternoSemGrupoEconomicoGestaoEnergia\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecutaUsuarioExternoSemGrupoEconomicoGestaoEnergia() throws IOException, InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT();

		if (Parametros.existeBug == false) {

			try {

				Step.Url(Parametros.UrlPowerView);
				Step.UsuarioLogado();
				Step.Sair();
				Step.Usuario("usuarioexterno5@gmail.com");
				Step.Senha("Doc@123456");
				Step.Acessar();
				Step.Url(Parametros.UrlGestaoEnergia);

				Step.GrupoEconomico("POWERVIEW BALANCO");
				Assert.assertEquals("No data", Step.ValidaGrupoEconomico());

				Step.Url(Parametros.UrlPowerView);
				Step.UsuarioLogado();
				Step.Sair();
				Step.Usuario(Parametros.UsuarioPowerView);
				Step.Senha(Parametros.SenhaPowerView);
				Step.Acessar();

			} catch (Throwable e) {

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
								
				Step.Url(Parametros.UrlPowerView);
				Step.UsuarioLogado();
				Step.Sair();
				Step.Usuario(Parametros.UsuarioPowerView);
				Step.Senha(Parametros.SenhaPowerView);
				Step.Acessar();
				
				System.out.println("Caso de teste: ( TestUsuarioExternoSemGrupoEconomicoGestaoEnergia ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestUsuarioExternoSemGrupoEconomicoGestaoEnergia ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				
			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestUsuarioExternoSemGrupoEconomicoGestaoEnergia2 AcaoStatusBug = new TestUsuarioExternoSemGrupoEconomicoGestaoEnergia2();
			AcaoStatusBug.Go();
		
		}

	}

}
