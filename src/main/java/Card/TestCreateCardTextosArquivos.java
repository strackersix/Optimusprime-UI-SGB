package Card;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Jira;
import _CORE.Parametros;

public class TestCreateCardTextosArquivos {

	static String Resumo = "CREATE - Card do tipo: 'Textos e Arquivos'.";
	static String Descricao = "Segue anexo Screenshot do momento em que o processo de criação do Card Link foi interrompido."
			+ "\n" + "Em caso de dúvidas favor comunicar a equipe de QA.";
	static String BugArquivoTXT = "C:\\Automacao\\Parametros\\TestCreateCardTextosArquivos\\existeBug.txt";

	Framework Step = new Framework();

	@Test
	public void ExecuteTestCreateCardTextosArquivos() throws InterruptedException {

		Step.Url(Parametros.UrlPowerView);
		Step.LerArquivoTXT(BugArquivoTXT);

		if (Parametros.existeBug == false) {

			try {

				Step.Publicar();
				Step.TextosArquivos();
				Step.Categoria("Notícias");
				Step.TituloTexto("Selenium Webdriver");
				Step.Texto("Selenium é uma estrutura portátil para testar aplicativos da web . O Selenium fornece uma ferramenta de reprodução para criar testes funcionais sem a necessidade de aprender uma linguagem de script de teste (Selenium IDE). Ele também fornece uma linguagem específica de domínio de teste (Selenese) para escrever testes em várias linguagens de programação populares, incluindo C # , Groovy , Java , Perl , PHP , Python , Ruby e Scala . Os testes podem ser executados nos navegadores mais modernos . O selênio é executado emWindows , Linux e macOS . É um software de código aberto lançado sob a Licença Apache 2.0 .");
				Step.Grupo("Doc88");
				Step.PublicarCard();

				Assert.assertEquals("Selenium Webdriver", Step.ValidaCreatCardTextos());

			} catch (Throwable e) {
				
				Jira TerrorDoDev = new Jira();
				TerrorDoDev.Screenshot();
				TerrorDoDev.UrlJira(Parametros.UrlJira);
				TerrorDoDev.IncluirTask();
				TerrorDoDev.Projeto(Parametros.ProjetoPowerView);
				TerrorDoDev.TipoItem(Parametros.TipoItem);
				TerrorDoDev.Resumo(Resumo);
				TerrorDoDev.Descricao(Resumo);
				TerrorDoDev.Upload();
				TerrorDoDev.Criar();
				TerrorDoDev.GravarBugArquivoTXT(BugArquivoTXT);
				
				System.out.println("Caso de teste: ( TestCreateCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");
				Assert.fail("Caso de teste: ( TestCreateCardTextosArquivos ) com problema" + "\n" + "Registrado Bug no Jira." + "\n");

			}

		} else {
			
			Jira VerificaStatusBug = new Jira();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
			VerificaStatusBug.PesquisarTask(Resumo);
			VerificaStatusBug.AcessarBug();
			VerificaStatusBug.CapturarStatusBug();
			VerificaStatusBug.UrlJira(Parametros.UrlJira);
					
			TestCreateCardTextosArquivos2 AcaoStatusBug = new TestCreateCardTextosArquivos2();
			AcaoStatusBug.Go();
		
		}

	}

}
