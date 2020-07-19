package UnitTest_Cards;

import org.junit.Test;

import Login.Framework;
import org.junit.Assert;

public class Cenario_TestCreateCardLink {

	Framework login = new Framework();
	Card.Framework card = new Card.Framework();

	@Test
	public void Unit() {

		try {

			login.GoLogin();
			
			int count = 10;
			int qtde = count;

			do {

				card.GoCreateCardLink();

				--count;
				System.out.println("Faltam: " + count + " execu��es para a conclus�o do Unit Test.");

			} while (count != 0);

				System.out.println("Executado: " + qtde + " vezes...");
				System.out.println("Parab�ns!!!" + "\n" + "Caso de Teste Aprovado para implementa��o do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");
			Assert.fail();
			
		}

	}

}
