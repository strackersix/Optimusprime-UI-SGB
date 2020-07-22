package Card;

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
		
//------------------------------------------------------------------<<< Cards >>>---------------------------------------------------------------------//	
	TestCreateCardLink.class,
	TestReadCardLink.class,		
	TestCompartilhamentoCardLink.class,
	TestDeleteCardLink.class,		
	
	TestCreateCardTextosArquivos.class,
	TestReadCardTextosArquivos.class,
	TestCompartilhamentoCardTextosArquivos.class,
	TestDeleteCardTextosArquivos.class,	
	
	TestCreateCardYouTube.class,
	TestReadCardYoutube.class,
	TestCompartilhamentoCardYouTube.class,		
	TestDeleteCardYouTube.class,
	
	TestPesquisarCardAntigo.class,

//-------------------------------------------------------------------<<< Logout >>>--------------------------------------------------------------------//

	TestLogout.class,

	 
})

public class Execute  { 

	@AfterClass
	public static void Finalizar() throws InterruptedException {
		
		DriverFactory.finalizarDriverFactory();
			
	}

			
}
	