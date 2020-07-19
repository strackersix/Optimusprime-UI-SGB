package _CORE;

public interface Constantes {

	// ------------------------------------------------------- <<< Ambiente Powerview >>> -----------------------------------------------------------//
	
	 String AmbientePowerview = "QA";
	
	 String UrlPowerView = "https://powerview-"+AmbientePowerview+".doc88.com.br";
	 String UrlDecisions = "https://powerview-"+AmbientePowerview+".doc88.com.br/protheus-view/decisions?q=w&column=0&year_month=&created_at=&type=&status=";
	 String UrlGestaoEnergia = "https://powerview-"+AmbientePowerview+".doc88.com.br/gestaoenergiav2/cativo/visao-geral/graficos";
	 String CentralCadastrosAPI = "https://centralcadastros-api-"+AmbientePowerview+".doc88.com.br/";
	 String HorizonDashboard = "https://centralcadastros-api-"+AmbientePowerview+".doc88.com.br/horizon/dashboard";
	 String CentralCadastrosAPIHome = "https://centralcadastros-api-"+AmbientePowerview+".doc88.com.br/home";
	 String UsuarioPowerView = "gabriel.souza@doc88.com.br";
	 String SenhaPowerView = "G@briel@123456";
	 String UploadPDFCentralCadastros = "C:\\Automacao\\Upload_CentralCadastros\\4Mb.pdf";
	 String UploadLogoCentralCadastros = "C:\\Automacao\\Logo_CentralCadastros\\Doc88.jpg";
	
	// --------------------------------------------------------- <<< Jira >>> -------------------------------------------------------------------//
	
	 String UrlJira = "https://comerc.atlassian.net/secure/RapidBoard.jspa?rapidView=142&projectKey=AQ";
	 String UsuarioJira = "gabriel.souza@doc88.com.br";
	 String SenhaJira = "Doc@123456";
	 String ProjetoPowerView = "AUTOMAÇÃO QA-BOTS (AQ)";
	 String TipoItem = "Bug";
	 String Ambiente = "Powerview - QA";
	 String Sprint = "Doc88 - Sprint 31";
	 String DiretorioScreenshot = "C:\\Automacao\\Evidencias";
	 String DiretorioUploaEvidencia = "C:\\Automacao\\Evidencias\\EVIDENCIA.jpg";
		
	// ------------------------------------------- <<< SGB - Sistema de gerenciamento de Bugs >>> ----------------------------------------------------//
	
	 String statusBug = "";
	 boolean existeBug = false;
	
	// ------------------------------------------------- <<< Arquivos Upload >>> --------------------------------------------------------------------//

	 String Path = "C:\\Automacao\\Upload_CentralCadastros\\1Mb.pdf";
	
	
}
