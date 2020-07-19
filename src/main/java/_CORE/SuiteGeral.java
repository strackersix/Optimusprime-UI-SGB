package _CORE;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import CentralCadastros.TestCentralCadastrosAlteracaoMassiva;
import CentralCadastros.TestCentralCadastros_Infomerc;
import CentralCadastros.TestCentralCadastros_Log;
import CentralCadastros.TestCentralCadastros_Logo;
import CentralCadastros.TestCentralCadastros_Upload;
import Login.TestLogin;

	@RunWith(Suite.class)
	@SuiteClasses({	
		
////-----------------------------------------------------------<<< Login Usuario Interno >>>--------------------------------------------------------------//			
//	TestAutenticacaoJira.class,
	TestLogin.class,	
		
////------------------------------------------------------------------<<< Cards >>>---------------------------------------------------------------------//	
//	TestCreateCardLink.class,
//	TestReadCardLink.class,		
//	TestCompartilhamentoCardLink.class,
//	TestDeleteCardLink.class,		
//	
//	TestCreateCardTextosArquivos.class,
//	TestReadCardTextosArquivos.class,
//	TestCompartilhamentoCardTextosArquivos.class,
//	TestDeleteCardTextosArquivos.class,
//			
//	TestCreateCardYouTube.class,
//	TestReadCardYoutube.class,
//	TestCompartilhamentoCardYouTube.class,
//	TestDeleteCardYouTube.class,
//	
//	TestPesquisarCardAntigo.class,
//
////---------------------------------------------------------------<<< Indicadores >>>--------------------------------------------------------------------//
//	
//	TestImportarPublicacoes.class,
//	
//	
////---------------------------------------------------------------<<< Indicadores >>>--------------------------------------------------------------------//	
//	TestNovoDashmaker.class,
//	
//	
////---------------------------------------------------------------<<< Telemetria >>>--------------------------------------------------------------------//
//	
//	TestFiltrosPesquisaTelemetria.class,
//	TestCardDemandaPonta.class,
//	TestCardDemandaForaPonta.class,
//	TestCardConsumoPonta.class,
//	TestCardConsumoForaPonta.class,
//	TestCardConsumoTotal.class,
//	TestGraficoPerfilCarga.class,
//	TestGraficoPerfilCargaMaximaDia.class,
//	TestGraficoPerfilCargaMes.class,
//	TestGraficoConsumo.class,
//	
//			
////---------------------------------------------------------------<<< Certificados >>>------------------------------------------------------------------//	
//	
//	TestGerarCertificadoPDFConsolidado.class,
//	
////-------------------------------------------------------------<<< Gestao de Energia >>>-------------------------------------------------------------//	
//	TestUsuarioExternoSemGrupoEconomicoGestaoEnergia.class,
//	
//					
////----------------------------------------------------------<<< Central de Cadastros >>>-------------------------------------------------------------//
//	TestCentralCadastrosAlteracaoMassiva.class,
//	TestCentralCadastros_Log.class,
//	TestCentralCadastros_Infomerc.class,
//	TestCentralCadastros_Upload.class,
//	TestCentralCadastros_Logo.class,		
	
	

////-------------------------------------------------------------------<<< Logout >>>--------------------------------------------------------------------//
//	TestLogout.class,

	 
})

public class SuiteGeral  { 

	@AfterClass
	public static void Finalizar() throws InterruptedException {
		
//		Thread.sleep(10000);
//		DriverFactory.FinalizaDriverFactory();
			
	}

			
}
	