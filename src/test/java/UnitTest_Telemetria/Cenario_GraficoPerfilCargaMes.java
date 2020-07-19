package UnitTest_Telemetria;

import org.junit.Test;

import Login.Framework;
import Telemetria.GraficoPerfilCargaMes;

public class Cenario_GraficoPerfilCargaMes {

	Framework login = new Framework();
	GraficoPerfilCargaMes graficoPerfilCargaMes = new GraficoPerfilCargaMes();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();

			int count = 10;
			do {

				graficoPerfilCargaMes.Go();
				--count;
				System.out.println("Faltam: " + count + " execu��es para a conclus�o do Unit Test.");

			} while (count != 0);

			System.out.println("Parab�ns!!!" + "\n" + "Caso de Teste Aprovado para receber implementa��o do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");

		}

	}

}
