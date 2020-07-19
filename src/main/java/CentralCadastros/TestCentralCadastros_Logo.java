package CentralCadastros;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Parametros;

public class TestCentralCadastros_Logo {
	
	
	Framework Step = new Framework();
	
	@Test
	
	public void ExecutaTestCentralCadastros_Logo () throws InterruptedException {
		
	// Unidade 1
		
		Step.Url(Parametros.UrlPowerView);
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos1();
		Step.ImagemLogo();
		Step.UploadLogo();
			
		Assert.assertEquals("logo.bmp", Step.ValidaLogo());
		
		Step.SelecionarTodasUnidades();
		
		Assert.assertEquals("POWERVIEW BALANCO UNID 2", Step.ValidaUnidade1());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3", Step.ValidaUnidade2());
		
		Step.SalvarLogo();
		
	// Valida Unidade 2	
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos2();
		Step.ImagemLogo();
		Step.UploadLogo();
		
		Assert.assertEquals("logo-preview", Step.ValidaLogo2());
		
	// Valida Unidade 3
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos3();
		Step.ImagemLogo();
		Step.UploadLogo();
		
		Assert.assertEquals("logo-preview", Step.ValidaLogo2());
		
		
	}

	
}
