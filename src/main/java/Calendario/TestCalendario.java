package Calendario;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import _CORE.*;


public class TestCalendario  {

		static String Resumo = "Erro no módulo: 'Calendário'.";
		static String Descricao = "O sistema está apresentando erro para inserir um novo registro de eventos do Calendário, vide evidência 'anexo'.";
 public static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestCalendario\\existeBug.txt";
		
	Framework Step = new Framework();
	
	@Test
	
	public void Calendario() throws InterruptedException, IOException {
				
		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT();
						
		if ( Parametros.existeBug == false) {
				
			try {
				
				Step.AcessarCalendario();
				Step.NovoEvento();
				Step.Inicio("01/01/2025");
				Step.Termino("15/01/2025");
				Step.TituloEvento("Test Automation Engineer");
				Step.TipoEvento();
				Step.DescricaoEvento("Selenium WebDriver, Java, JUnit e Maven.");
				Step.Responsavel("Gabriel Oliveira Conrado de Souza");
				Step.Participantes("Phelipe Bruno Cunha dos Santo");
				Step.ParticipantesExternos();
				Step.ReservarSala();
				Step.Participantes();
				Step.Servicos();
				Step.UnidadesSala();
				Step.Nome("Doctor Emmeet Brown");
				Step.Rg("3112252");
				Step.email("gabriel.souza@doc88.com.br");
				Step.PageDown();
				Step.Adicionar();
				Step.PageDown();
				Step.Semana();
				Step.SalasReuniao();
				Step.Convidados();
				Step.MeusEventos();
				Step.BuscarEvento("Test Automation Engineer");
				
				Assert.assertEquals("Test Automation Engineer", Step.Titulo());
				
				Step.EditarEvento();		
				Step.ExcluirEvento();
				Step.Sim();		
			
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
				
				System.out.println("<<< Caso de Teste com Erro >>>" + "\n" + "Foi registrado Bug no Jira:" + "\n" + Resumo + "\n" + Descricao);
				
				Assert.fail("<<< Caso de Teste com Erro >>>" + "\n" + "Foi registrado Bug no jira:" + "\n" + Resumo + "\n" + Descricao);
			
			}
				
		} else {
	
			System.out.println("Existe Bug registrado no Jira:" + "\n" + Resumo + "\n" + Descricao);
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			
			TestCalendario2 AcaoStatusBug = new TestCalendario2();
			AcaoStatusBug.Go( Parametros.UrlJira );
						
		}
		
	}
	
}
