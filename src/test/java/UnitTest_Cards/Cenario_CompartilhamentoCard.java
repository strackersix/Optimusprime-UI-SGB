package UnitTest_Cards;

import org.junit.Test;

import Login.Framework;

public class Cenario_CompartilhamentoCard {

	Framework login = new Framework();
	Card.Framework compartilhamentoCard = new Card.Framework();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();

			int count = 50;
			do {

				compartilhamentoCard.GoCompartilhamentoCard();;
				--count;
				System.out.println("Faltam: " + count + " execu��es para a conclus�o do Unit Test.");

			} while (count != 0);

			System.out.println("Parab�ns!!!" + "\n" + "Caso de Teste Aprovado para receber implementa��o do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");

		}

	}
	
}
