package UnitTest_Telemetria;

import org.junit.Test;
import org.openqa.selenium.By;

import Login.Framework;
import Telemetria.CardDemandaForaPonta;
import _CORE.DriverFactory;

import org.junit.Assert;

public class Cenario_CardDemandaForaPonta extends DriverFactory {
	
	Framework login = new Framework();
	CardDemandaForaPonta cardDemandaForaPonta = new CardDemandaForaPonta();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();
			int count = 1;
			
			do {

				cardDemandaForaPonta.Go();   
				
				--count;
				System.out.println("Faltam: " + count + " execuções para a conclusão do Unit Test.");

			} while (count != 0);

			System.out.println("Parabéns!!!" + "\n" + "Caso de Teste Aprovado para receber implementação do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");
			String ValorAtual = driver.findElement(By.xpath("(//section[@class = 'f-card demand-widget p--base br--base m-- color--background--white color--text--font-base'])[2]")).getText();
			Assert.assertEquals("", ValorAtual);
			
		}

	}

}
