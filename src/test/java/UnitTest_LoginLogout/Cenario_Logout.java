package UnitTest_LoginLogout;

import org.junit.Test;

import Login.Framework;

public class Cenario_Logout {

	Framework login = new Framework();
	Logout.Framework logout = new Logout.Framework();

	@Test
	public void Unit() {

		try {

			login.GoLogin();
			int count = 100;

			do {

				logout.GoLogout();
				login.GoLogin();

				--count;
				System.out.println("Faltam: " + count + " execuções para a conclusão do Unit Test.");

			} while (count != 0);

			System.out.println("Parabéns!!!" + "\n" + "Caso de Teste Aprovado para receber implementação do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");

		}

	}

}
