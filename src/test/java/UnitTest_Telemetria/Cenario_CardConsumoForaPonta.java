package UnitTest_Telemetria;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import Login.Framework;
import Telemetria.CardConsumoForaPonta;
import _CORE.DriverFactory;

public class Cenario_CardConsumoForaPonta extends DriverFactory {

	Framework login = new Framework();
	CardConsumoForaPonta cardConsumoForaPonta = new CardConsumoForaPonta(); 
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();
			int count = 1;
			
			do {

				cardConsumoForaPonta.Go();   
				--count;
				System.out.println("Faltam: " + count + " execu��es para a conclus�o do Unit Test.");

			} while (count != 0);

			System.out.println("Parab�ns!!!" + "\n" + "Caso de Teste Aprovado para receber implementa��o do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");
			String ValorAtual = driver.findElement(By.xpath("(//section[@class = 'f-card intake-card p--base br--base m-- color--background--white color--text--font-base'])[2]")).getText();
			Assert.assertEquals("", ValorAtual);
			
		}

	}
	
}
