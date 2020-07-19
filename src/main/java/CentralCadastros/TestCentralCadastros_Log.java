package CentralCadastros;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Parametros;

public class TestCentralCadastros_Log {
	
	
	Framework Step = new Framework();
	
	@Test
	public void ExecutaTestCentralCadastros_Log () throws InterruptedException {
					
//  Log de Altera��es - Primeira e segunda altera��o Unidade 1
			
		Step.Url(Parametros.UrlPowerView);
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.ConsultarLogAlteracoes();
		
		Step.GrupoEconomicoLog("POWERVIEW BALANCO");
		Step.GrupoEmpresaLog("POWERVIEW BALANCO");
		Step.SolicitanteLog("Gabriel Oliveira Conrado de Souza");
		
		Step.FiltrarLog();
		
		Step.ExibirPorPagina25();
		
		Step.PageDownListaLog();
			
		Step.LogPrimeiraAlteracaoUnidade1();
		
		Assert.assertEquals("Simples", Step.ComplexidadeAntes());
		Assert.assertEquals("Intermedi�rio", Step.ComplexidadeDepois());
		
		Assert.assertEquals("RIO DE JANEIRO", Step.CentroDecisorioAntes());
		Assert.assertEquals("S�O PAULO", Step.CentroDecisorioDepois());
		
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomaticoAntes());
		Assert.assertEquals("Calcular", Step.BalancoAutomaticoDepois());
		
		Assert.assertEquals("----", Step.EmailSazonalizacaoAntes());
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailSazonalizacaoDepois());
		
		Assert.assertEquals("----", Step.EmailInformaticoCCEEAntes());
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailInformaticoCCEEDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailContribuicaoAssociativaAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailContribuicaoAssociativaDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailNotaFiscalAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailNotaFiscalDepois());
			
		Step.PageDownLog();
		
		Step.FecharLog();
		
		Step.LogSegundaAlteracaoUnidade1();
				
		Assert.assertEquals("N�o", Step.EncerramentoAutomaticoAntes());
		Assert.assertEquals("Sim", Step.EncerramentoAutomaticoDepois());

	
		Step.FecharLog();
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//		
//  Log de Altera��es - Primeira e segunda altera��o Unidade 2
		
		
		Step.LogPrimeiraAlteracaoUnidade2();
		
		Assert.assertEquals("Simples", Step.ComplexidadeAntes());
		Assert.assertEquals("Intermedi�rio", Step.ComplexidadeDepois());
		
		Assert.assertEquals("RIO DE JANEIRO", Step.CentroDecisorioAntes());
		Assert.assertEquals("S�O PAULO", Step.CentroDecisorioDepois());
		
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomaticoAntes());
		Assert.assertEquals("Calcular", Step.BalancoAutomaticoDepois());
		
		Assert.assertEquals("----", Step.EmailSazonalizacaoAntes());
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailSazonalizacaoDepois());
		
		Assert.assertEquals("----", Step.EmailInformaticoCCEEAntes());
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailInformaticoCCEEDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailContribuicaoAssociativaAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailContribuicaoAssociativaDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailNotaFiscalAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailNotaFiscalDepois());
		
		
		Step.FecharLog();
		
		Step.LogSegundaAlteracaoUnidade2();
	
		Assert.assertEquals("N�o", Step.EncerramentoAutomaticoAntes());
		Assert.assertEquals("Sim", Step.EncerramentoAutomaticoDepois());
		
		Step.PageDownLog();
		Step.FecharLog();
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//		
//  Log de Altera��es - Primeira e segunda altera��o Unidade 3
		
		
		Step.LogPrimeiraAlteracaoUnidade3();
		
		Assert.assertEquals("Simples", Step.ComplexidadeAntes());
		Assert.assertEquals("Intermedi�rio", Step.ComplexidadeDepois());
		
		Assert.assertEquals("RIO DE JANEIRO", Step.CentroDecisorioAntes());
		Assert.assertEquals("S�O PAULO", Step.CentroDecisorioDepois());
		
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomaticoAntes());
		Assert.assertEquals("Calcular", Step.BalancoAutomaticoDepois());
		
		Assert.assertEquals("----", Step.EmailSazonalizacaoAntes());
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailSazonalizacaoDepois());
		
		Assert.assertEquals("----", Step.EmailInformaticoCCEEAntes());
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailInformaticoCCEEDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailContribuicaoAssociativaAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailContribuicaoAssociativaDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailNotaFiscalAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailNotaFiscalDepois());
		
		Step.PageDownLog();
		Step.FecharLog();
			
		Step.LogSegundaAlteracaoUnidade3();
		
		Assert.assertEquals("N�o", Step.EncerramentoAutomaticoAntes());
		Assert.assertEquals("Sim", Step.EncerramentoAutomaticoDepois());
						
		Step.FecharLog();		

//-------------------------------------------------------------------------//------------------------------------------------------------------------------//	
//  Log de Altera��es - Terceira e quarta altera��o Unidade 1
			
		
		Step.LogTerceiraAlteracaoUnidade1();
		
		Assert.assertEquals("Intermedi�rio", Step.ComplexidadeAntes());
		Assert.assertEquals("Simples", Step.ComplexidadeDepois());
		
		Assert.assertEquals("S�O PAULO", Step.CentroDecisorioAntes());
		Assert.assertEquals("RIO DE JANEIRO", Step.CentroDecisorioDepois());
		
		Assert.assertEquals("Calcular", Step.BalancoAutomaticoAntes());
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomaticoDepois());
		
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailSazonalizacaoAntes());
		Assert.assertEquals("----", Step.EmailSazonalizacaoDepois());
		
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailInformaticoCCEEAntes());
		Assert.assertEquals("----", Step.EmailInformaticoCCEEDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailContribuicaoAssociativaAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailContribuicaoAssociativaDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailNotaFiscalAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailNotaFiscalDepois());

	
		Step.FecharLog();
		
		Step.LogQuartaAlteracaoUnidade1();
		
		Assert.assertEquals("Sim", Step.EncerramentoAutomaticoAntes());
		Assert.assertEquals("N�o", Step.EncerramentoAutomaticoDepois());
		
		
		Step.PageDownLog();
		Step.FecharLog();
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//		
//  Log de Altera��es - Terceira e quarta altera��o Unidade 2
		
		
		Step.LogTerceiraAlteracaoUnidade2();
		
		Assert.assertEquals("Intermedi�rio", Step.ComplexidadeAntes());
		Assert.assertEquals("Simples", Step.ComplexidadeDepois());
		
		Assert.assertEquals("S�O PAULO", Step.CentroDecisorioAntes());
		Assert.assertEquals("RIO DE JANEIRO", Step.CentroDecisorioDepois());
		
		Assert.assertEquals("Calcular", Step.BalancoAutomaticoAntes());
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomaticoDepois());
		
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailSazonalizacaoAntes());
		Assert.assertEquals("----", Step.EmailSazonalizacaoDepois());
		
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailInformaticoCCEEAntes());
		Assert.assertEquals("----", Step.EmailInformaticoCCEEDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailContribuicaoAssociativaAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailContribuicaoAssociativaDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailNotaFiscalAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailNotaFiscalDepois());
		
		Step.FecharLog();
		
		Step.LogQuartaAlteracaoUnidade2();
		
		Assert.assertEquals("Sim", Step.EncerramentoAutomaticoAntes());
		Assert.assertEquals("N�o", Step.EncerramentoAutomaticoDepois());
		
		Step.PageDownLog();
		Step.FecharLog();
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//		
//  Log de Altera��es - Terceira e quarta altera��o Unidade 3
		
		
		Step.LogTerceiraAlteracaoUnidade3();
		
		Assert.assertEquals("Intermedi�rio", Step.ComplexidadeAntes());
		Assert.assertEquals("Simples", Step.ComplexidadeDepois());
		
		Assert.assertEquals("S�O PAULO", Step.CentroDecisorioAntes());
		Assert.assertEquals("RIO DE JANEIRO", Step.CentroDecisorioDepois());
		
		Assert.assertEquals("Calcular", Step.BalancoAutomaticoAntes());
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomaticoDepois());
		
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailSazonalizacaoAntes());
		Assert.assertEquals("----", Step.EmailSazonalizacaoDepois());
		
		Assert.assertEquals("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br", Step.EmailInformaticoCCEEAntes());
		Assert.assertEquals("----", Step.EmailInformaticoCCEEDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailContribuicaoAssociativaAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailContribuicaoAssociativaDepois());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br;gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br", Step.EmailNotaFiscalAntes());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.EmailNotaFiscalDepois());

		Step.FecharLog();
		
		Step.LogQuartaAlteracaoUnidade3();

		Assert.assertEquals("Sim", Step.EncerramentoAutomaticoAntes());
		Assert.assertEquals("N�o", Step.EncerramentoAutomaticoDepois());
					
		Step.PageDownLog();
		Step.FecharLog();
		Step.Url(Parametros.UrlPowerView);
		
	
	}

}
