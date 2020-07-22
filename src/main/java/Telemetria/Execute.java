package Telemetria;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import AutenticacaoJira.TestAutenticacaoJira;
import Login.TestLogin;
import Logout.TestLogout;
import _CORE.DriverFactory;

	@RunWith(Suite.class)
	@SuiteClasses({	
		
//-----------------------------------------------------------<<< Login Usuario Interno >>>--------------------------------------------------------------//			
	TestAutenticacaoJira.class,
	TestLogin.class,	

//---------------------------------------------------------------<<< Telemetria >>>--------------------------------------------------------------------//
	
	TestFiltrosPesquisaTelemetria.class,
	TestCardDemandaPonta.class,
	TestCardDemandaForaPonta.class,
	TestCardConsumoPonta.class,
	TestCardConsumoForaPonta.class,
	TestCardConsumoTotal.class,
	TestGraficoPerfilCarga.class,
	TestGraficoPerfilCargaMaximaDia.class,
	TestGraficoPerfilCargaMes.class,
	TestGraficoConsumo.class,

//---------------------------------------------------------------<<< Telemetria >>>--------------------------------------------------------------------//	

	TestLogout.class,		
	
	
})

public class Execute  { 

	@AfterClass
	public static void Finalizar() throws InterruptedException {
		
		DriverFactory.finalizarDriverFactory();
			
	}

			
}
	