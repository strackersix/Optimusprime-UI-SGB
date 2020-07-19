package Indicadores;

import org.junit.Test;

import _CORE.Parametros;

public class TestImportarPublicacoes {

	
	Framework Step = new Framework();
	
	@Test
	public void ExecutaImportarPublicacoes() {
		
		
		Step.Url(Parametros.UrlPowerView);
		Step.MinhaConta();
		Step.Indicadores();
		Step.Configuracoes();
		Step.BtnImportarPublicacoes();
		Step.UploadArquivo();
		Step.Enviar();
		Step.Aguarde();
		
		
	}
	
		
}
