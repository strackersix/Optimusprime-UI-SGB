package UnitTest_Telemetria;

import org.junit.Test;
import org.openqa.selenium.By;

import Login.Framework;
import Telemetria.CardDemandaPonta;
import _CORE.DriverFactory;

import org.junit.Assert;

public class Cenario_CardDemandaPonta extends DriverFactory {
	
	Framework login = new Framework();
	CardDemandaPonta cardDemandaPonta = new CardDemandaPonta();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();
			int count = 1;				
						
			do {
				
				cardDemandaPonta.Go();
				--count;
				System.out.println("Faltam: " + count + " execuções para a conclusão do Unit Test.");

			} while (count != 0);

			System.out.println("Parabéns!!!" + "\n" + "Caso de Teste Aprovado para receber implementação do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");
			String ValorAtual = driver.findElement(By.xpath("(//section[@class = 'f-card demand-widget p--base br--base m-- color--background--white color--text--font-base'])[1]")).getText();
			Assert.assertEquals("", ValorAtual);
			

		}

	}
	
}
