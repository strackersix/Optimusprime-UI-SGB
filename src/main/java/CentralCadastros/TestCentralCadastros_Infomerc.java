package CentralCadastros;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Parametros;

public class TestCentralCadastros_Infomerc  {

	
	Framework Step = new Framework();
	
	@Test
	
	public void ExecutaTestCentralCadastros_Infomerc () throws InterruptedException {
	
		
	// Inclus�o dos Valores Infomerc
	
		Step.Url(Parametros.UrlPowerView);
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.Cadastro();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("S�O PAULO");
		Step.filtrar();
		
		Step.FlegarUnidade1();
		Step.AlterarDados1();
		
		Step.ValoresInfomerc();
		
	// Inclus�o
		
		Step.DataInfomerc();
		Step.Local("Remunera��o");
		Step.Valor("100,00");
		Step.Descricao("Test Automation - Valores Remunera��o");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();
		
		Assert.assertEquals("Jun-2020 Remunera��o R$ 100,00 Test Automation - Valores Remunera��o Editar", Step.ValidaValoresInfomerc());


	// Altera��o 
	
		Step.EditarValoresInfomerc();
		Step.EditarLocal("Distribuidora");
		Step.EditarValor("-200,00");
		Step.EditarDescricao("Test Automation - Valores Alterados Distribuidora");
		Step.Salvar();
		Step.AlteracaoEntendi();

		Assert.assertEquals("Jun-2020 Distribuidora R$ -200,00 Test Automation - Valores Alterados Distribuidora Editar", Step.ValidaValoresInfomerc());


	// Inclus�o 
		
		Step.DataInfomerc();
		Step.Local("Comparativo Cativo");
		Step.AlterarImposto("ICMS+PIS/COFINS");
		Step.Valor("300,00");
		Step.Descricao("Test Automation - Valores Comparativo Cativo");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();
		
	// Inclus�o 
		
		Step.DataInfomerc();
		Step.Local("Remunera��o");
		Step.Valor("400,00");
		Step.Descricao("Test Automation - Valores Remuneracao");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();
	
	// Inclus�o 	
		
		Step.DataInfomerc();
		Step.Local("Custo Livre");
		Step.Valor("500,00");
		Step.Descricao("Test Automation - Valores Custo Livre");
		Step.AdicionarNovaLinha();
		Step.SucessoEntendi();		
		
		
	// Exclus�o
		
		Step.ExlcuirCustoLivre();
		Step.ExlcuirRemuneracao();
		Step.ExlcuirComparativoCativo();
		Step.ExcluirDistribuidora();
			

	}
}