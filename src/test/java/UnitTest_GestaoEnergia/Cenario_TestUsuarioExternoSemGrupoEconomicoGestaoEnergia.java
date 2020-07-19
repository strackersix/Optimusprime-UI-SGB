package UnitTest_GestaoEnergia;

import org.junit.Test;

import GestaoEnergia.Framework;

public class Cenario_TestUsuarioExternoSemGrupoEconomicoGestaoEnergia {
	
	Login.Framework login = new Login.Framework();
	Framework usuarioExternoSemGrupoEconomicoGestaoEnergia = new Framework();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();

			int count = 3;
			do {

				usuarioExternoSemGrupoEconomicoGestaoEnergia.Go();
				--count;
				System.out.println("Faltam: " + count + " execu��es para a conclus�o do Unit Test.");

			} while (count != 0);

			System.out.println("Parab�ns!!!" + "\n" + "Caso de Teste Aprovado para receber implementa��o do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido!!!");

		}

	}

}
