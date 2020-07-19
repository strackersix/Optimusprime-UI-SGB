package CentralCadastros;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Parametros;

public class TestCentralCadastros_Infomerc  {

	
	Framework Step = new Framework();
	
	@Test
	
	public void ExecutaTestCentralCadastros_Infomerc () throws InterruptedException {
	
		
	// Inclusão dos Valores Infomerc
	
		Step.Url(Parametros.UrlPowerView);
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.FlegarUnidade1();
		Step.AlterarDados1();
		
		Step.ValoresInfomerc();
		
	// Inclusão
		
		Step.DataInfomerc();
		Step.Local("Remuneração");
		Step.Valor("100,00");
		Step.Descricao("Test Automation - Valores Remuneração");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();
		
		Assert.assertEquals("Jun-2020 Remuneração R$ 100,00 Test Automation - Valores Remuneração Editar", Step.ValidaValoresInfomerc());


	// Alteração 
	
		Step.EditarValoresInfomerc();
		Step.EditarLocal("Distribuidora");
		Step.EditarValor("-200,00");
		Step.EditarDescricao("Test Automation - Valores Alterados Distribuidora");
		Step.Salvar();
		Step.AlteracaoEntendi();

		Assert.assertEquals("Jun-2020 Distribuidora R$ -200,00 Test Automation - Valores Alterados Distribuidora Editar", Step.ValidaValoresInfomerc());


	// Inclusão 
		
		Step.DataInfomerc();
		Step.Local("Comparativo Cativo");
		Step.AlterarImposto("ICMS+PIS/COFINS");
		Step.Valor("300,00");
		Step.Descricao("Test Automation - Valores Comparativo Cativo");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();
		
	// Inclusão 
		
		Step.DataInfomerc();
		Step.Local("Remuneração");
		Step.Valor("400,00");
		Step.Descricao("Test Automation - Valores Remuneracao");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();
	
	// Inclusão 	
		
		Step.DataInfomerc();
		Step.Local("Custo Livre");
		Step.Valor("500,00");
		Step.Descricao("Test Automation - Valores Custo Livre");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();		
		
		
	// Exclusão
		
		Step.ExlcuirCustoLivre();
		Step.ExlcuirRemuneracao();
		Step.ExlcuirComparativoCativo();
		Step.ExcluirDistribuidora();
			

	}
}