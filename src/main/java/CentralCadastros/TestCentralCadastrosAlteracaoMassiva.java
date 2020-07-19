package CentralCadastros;	

import org.junit.Assert;
import org.junit.Test;

import _CORE.Parametros;

public class TestCentralCadastrosAlteracaoMassiva {
	
	
	Framework Step = new Framework();
	
	@Test
	
	public void CentralCadastro () throws InterruptedException {
		
//  Primeira altera��o Massiva de todas as Unidades. 	
	
		Step.Url(Parametros.UrlPowerView);
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
				
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
					
		Step.FlegarTodos();
		Step.AlterarItensFiltrados();
		
		Step.CentroDecisorio("S�O PAULO");
		Step.Complexidade("Intermedi�rio");
		Step.BalancoAutomatico("Sim");
		Step.EncerramentoAutomatico("Sim");
				
		Step.Email();
		
		Step.IncluirEmailNotaFiscal( "gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br" );
		Step.IncluirEmailInformativosCCEE("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br");
		Step.IncluirEmailConstribuicaoAssociativa("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br");
		Step.PageDown();
		Step.IncluirEmailSazonalizacao("gabriel.souza@doc88.com.br;phelipe.santos@doc88.com.br;alex.fonseca@doc88.com.br");
				
		Step.Continuar();
		
		Assert.assertEquals("Confirmar Altera��o de Dados", Step.ValidaAlteracaoDados());
		
		Assert.assertEquals("S�O PAULO", Step.ValidaCentroDecisorio());
		Assert.assertEquals("Intermedi�rio", Step.ValidaComplexidade());
		Assert.assertEquals("Sim", Step.ValidaBalancoAutomatico());
		Assert.assertEquals("Sim", Step.ValidaEncerramentoAutomatico());
		
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br; alex.fonseca@doc88.com.br", Step.ValidaEmailNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br; alex.fonseca@doc88.com.br", Step.ValidaEmailInformativoCCEE());
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br; alex.fonseca@doc88.com.br", Step.ValidaEmailContribuicaoAssociativa());
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br; alex.fonseca@doc88.com.br", Step.ValidaEmailSazonalizacao());
		
		
		Step.ActionsPageDown();
		Step.SalvarAlteracoes();
		Step.Entendi();
		
		Step.FilaCentralCadastros();
		Step.Url(Parametros.UrlPowerView);
		
//	----------------------------------------------------------------------------------------------------------------------------------------------------------------		
//  Confirma��o da primeira altera��o de todas as Unidades. 	
		
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();

		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarTodos();
		Step.AlterarItensFiltrados();
		Step.VisualizarEmails();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br, gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br", Step.ValidaUnid1EmailNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br, alex.fonseca@doc88.com.br" , Step.ValidaUnid1EmailInformativosCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br, gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br", Step.ValidaUnid1EmailContribuicaoAssociativa());
		Assert.assertEquals("gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br, alex.fonseca@doc88.com.br" , Step.ValidaUnid1EmailSazonalizacao());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br, gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br", Step.ValidaUnid2EmailNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br, alex.fonseca@doc88.com.br" , Step.ValidaUnid2EmailInformativosCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br, gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br", Step.ValidaUnid2EmailContribuicaoAssociativa());
		Assert.assertEquals("gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br, alex.fonseca@doc88.com.br" , Step.ValidaUnid2EmailSazonalizacao());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br, gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br", Step.ValidaUnid3EmailNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br, alex.fonseca@doc88.com.br" , Step.ValidaUnid3EmailInformativosCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br, gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br", Step.ValidaUnid3EmailContribuicaoAssociativa());
		Assert.assertEquals("gabriel.souza@doc88.com.br, phelipe.santos@doc88.com.br, alex.fonseca@doc88.com.br" , Step.ValidaUnid3EmailSazonalizacao());		
		
		
//	----------------------------------------------------------------------//------------------------------------------------------------------------------//	
//  Confirma��o da primeira altera��o da Unidade 1. 
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarUnidade1();
		Step.AlterarDados1();
				
		Assert.assertEquals("S�O PAULO", Step.ValidaCentroDecisorioAlterado1());
		Assert.assertEquals("Intermedi�rio", Step.ValidaComplexidadeAlterado1());
		Assert.assertEquals("S�O PAULO", Step.ValidaCentroDecisorioAlterado2());
		Assert.assertEquals("INTERMEDI�RIO", Step.ValidaComplexidadeAlterado2());
		
		Assert.assertEquals("Calcular", Step.BalancoAutomtico());
		Assert.assertEquals("Sim", Step.EncerramentoAutomatico());
		
		Step.EmailUnitario();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br | gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br", Step.ValidaEmailUnidadeNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br | alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeInformativoCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br | gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br", Step.ValidaEmailUnidadeContribuicaoAssocoatova());
		Assert.assertEquals("gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br | alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeSazonalizacao());
		
		
//  ----------------------------------------------------------------------//------------------------------------------------------------------------------//	
//  Confirma��o da primeira altera��o da Unidade 2. 
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarUnidade2();
		Step.AlterarDados2();
				
		Assert.assertEquals("S�O PAULO", Step.ValidaCentroDecisorioAlterado1());
		Assert.assertEquals("Intermedi�rio", Step.ValidaComplexidadeAlterado1());
		Assert.assertEquals("S�O PAULO", Step.ValidaCentroDecisorioAlterado2());
		Assert.assertEquals("INTERMEDI�RIO", Step.ValidaComplexidadeAlterado2());
		
		Assert.assertEquals("Calcular", Step.BalancoAutomtico());
		Assert.assertEquals("Sim", Step.EncerramentoAutomatico());
		
		Step.EmailUnitario();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br | gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br", Step.ValidaEmailUnidadeNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br | alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeInformativoCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br | gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br", Step.ValidaEmailUnidadeContribuicaoAssocoatova());
		Assert.assertEquals("gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br | alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeSazonalizacao());
		

//  ----------------------------------------------------------------------//------------------------------------------------------------------------------//	
//  Confirma��o da primeira altera��o da Unidade 3. 		
		
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarUnidade3();
		Step.AlterarDados3();
				
		Assert.assertEquals("S�O PAULO", Step.ValidaCentroDecisorioAlterado1());
		Assert.assertEquals("Intermedi�rio", Step.ValidaComplexidadeAlterado1());
		Assert.assertEquals("S�O PAULO", Step.ValidaCentroDecisorioAlterado2());
		Assert.assertEquals("INTERMEDI�RIO", Step.ValidaComplexidadeAlterado2());
		
		Assert.assertEquals("Calcular", Step.BalancoAutomtico());
		Assert.assertEquals("Sim", Step.EncerramentoAutomatico());
		
		Step.EmailUnitario();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br | gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br", Step.ValidaEmailUnidadeNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br | alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeInformativoCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br | gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br", Step.ValidaEmailUnidadeContribuicaoAssocoatova());
		Assert.assertEquals("gabriel.souza@doc88.com.br | phelipe.santos@doc88.com.br | alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeSazonalizacao());
		
		
//  ----------------------------------------------------------------------//------------------------------------------------------------------------------//	
//  Segunda altera��o Massiva de todas as Unidades.		
		
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarTodos();
		Step.AlterarItensFiltrados();
		
		
		Step.CentroDecisorio("RIO DE JANEIRO");
		Step.Complexidade("Simples");
		Step.BalancoAutomatico("N�o");
		Step.EncerramentoAutomatico("N�o");
		
		Step.Email();
		
		Step.ExcluirEmailNotaFiscal("gabriel.souza@doc88.com.br,phelipe.santos@doc88.com.br");
		Step.ExcluirEmailInformativosCCEE("gabriel.souza@doc88.com.br,phelipe.santos@doc88.com.br,alex.fonseca@doc88.com.br");
		Step.ExcluirEmailContribuicaoAssociativa("gabriel.souza@doc88.com.br,phelipe.santos@doc88.com.br");
		Step.PageDown();
		Step.ExcluirEmailSazonalizacao("gabriel.souza@doc88.com.br,phelipe.santos@doc88.com.br,alex.fonseca@doc88.com.br");
		
		Step.Continuar();
		
		Assert.assertEquals("Confirmar Altera��o de Dados", Step.ValidaAlteracaoDados());
		
		Assert.assertEquals("RIO DE JANEIRO", Step.ValidaCentroDecisorio());
		Assert.assertEquals("Simples", Step.ValidaComplexidade());
		Assert.assertEquals("N�o", Step.ValidaALteracaoBalancoAutomatico());
		Assert.assertEquals("N�o", Step.ValidaAlteracaoEncerramentoAutomatico());
				
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br", Step.ValidaExclusaoEmailNotaFiscal());
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br; alex.fonseca@doc88.com.br", Step.ValidaExclusaoEmailInformativoCCEE());
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br", Step.ValidaExclusaoEmailContribuicaoAssociativa());
		Assert.assertEquals("gabriel.souza@doc88.com.br; phelipe.santos@doc88.com.br; alex.fonseca@doc88.com.br", Step.ValidaExclusaoEmailSazonalizacao());
				
		Step.SalvarAlteracoes();
		Step.Entendi();
		
		Step.FilaCentralCadastros();
		Step.Url(Parametros.UrlPowerView);

		
//  ----------------------------------------------------------------------//------------------------------------------------------------------------------//
//  Confirma��o da segunda altera��o de todas as Unidades. 
		
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();

		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarTodos();
		Step.AlterarItensFiltrados();
		Step.VisualizarEmails();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaUnid1EmailNotaFiscal());
		Assert.assertEquals("" , Step.ValidaUnid1EmailInformativosCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaUnid1EmailContribuicaoAssociativa());
		Assert.assertEquals("" , Step.ValidaUnid1EmailSazonalizacao());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaUnid2EmailNotaFiscal());
		Assert.assertEquals("" , Step.ValidaUnid2EmailInformativosCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaUnid2EmailContribuicaoAssociativa());
		Assert.assertEquals("" , Step.ValidaUnid2EmailSazonalizacao());
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaUnid3EmailNotaFiscal());
		Assert.assertEquals("" , Step.ValidaUnid3EmailInformativosCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaUnid3EmailContribuicaoAssociativa());
		Assert.assertEquals("" , Step.ValidaUnid3EmailSazonalizacao());
		
				
//  ----------------------------------------------------------------------//------------------------------------------------------------------------------//
//  Confirma��o da segunda altera��o da Unidade 1.
		
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarUnidade1();
		Step.AlterarDados1();
				
		Assert.assertEquals("RIO DE JANEIRO", Step.ValidaCentroDecisorioAlterado1());
		Assert.assertEquals("Simples", Step.ValidaComplexidadeAlterado1());
		Assert.assertEquals("RIO DE JANEIRO", Step.ValidaCentroDecisorioAlterado2());
		Assert.assertEquals("SIMPLES", Step.ValidaComplexidadeAlterado2());
		
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomtico());
		Assert.assertEquals("N�o", Step.EncerramentoAutomatico());
		
		Step.EmailUnitario();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeNotaFiscal());
		Assert.assertEquals("", Step.ValidaEmailUnidadeInformativoCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeContribuicaoAssocoatova());
		Assert.assertEquals("", Step.ValidaEmailUnidadeSazonalizacao());
		
		
//  ----------------------------------------------------------------------//------------------------------------------------------------------------------//
//  Confirma��o da segunda altera��o da Unidade 2.		
	
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarUnidade2();
		Step.AlterarDados2();
				
		Assert.assertEquals("RIO DE JANEIRO", Step.ValidaCentroDecisorioAlterado1());
		Assert.assertEquals("Simples", Step.ValidaComplexidadeAlterado1());
		Assert.assertEquals("RIO DE JANEIRO", Step.ValidaCentroDecisorioAlterado2());
		Assert.assertEquals("SIMPLES", Step.ValidaComplexidadeAlterado2());
		
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomtico());
		Assert.assertEquals("N�o", Step.EncerramentoAutomatico());
		
		Step.EmailUnitario();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeNotaFiscal());
		Assert.assertEquals("", Step.ValidaEmailUnidadeInformativoCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeContribuicaoAssocoatova());
		Assert.assertEquals("", Step.ValidaEmailUnidadeSazonalizacao());	
		
		
//  ----------------------------------------------------------------------//------------------------------------------------------------------------------//
//  Confirma��o da segunda altera��o da Unidade 3.
		
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico1());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico2());
		Assert.assertEquals("POWERVIEW BALANCO", Step.ValidaGrupoEconomico3());
		
		Step.FlegarUnidade3();
		Step.AlterarDados3();
				
		Assert.assertEquals("RIO DE JANEIRO", Step.ValidaCentroDecisorioAlterado1());
		Assert.assertEquals("Simples", Step.ValidaComplexidadeAlterado1());
		Assert.assertEquals("RIO DE JANEIRO", Step.ValidaCentroDecisorioAlterado2());
		Assert.assertEquals("SIMPLES", Step.ValidaComplexidadeAlterado2());
		
		Assert.assertEquals("N�o Calcular", Step.BalancoAutomtico());
		Assert.assertEquals("N�o", Step.EncerramentoAutomatico());
		
		Step.EmailUnitario();
		
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeNotaFiscal());
		Assert.assertEquals("", Step.ValidaEmailUnidadeInformativoCCEE());
		Assert.assertEquals("alex.fonseca@doc88.com.br", Step.ValidaEmailUnidadeContribuicaoAssocoatova());
		Assert.assertEquals("", Step.ValidaEmailUnidadeSazonalizacao());		
		

	}
	
}
