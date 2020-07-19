package UnitTest_Telemetria;

import org.junit.Test;

import Login.Framework;
import Telemetria.GraficoConsumo;

public class Cenario_GraficoConsumo {

	Framework login = new Framework();
	GraficoConsumo graficoConsumo = new GraficoConsumo();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();
			int count = 5;
			int qtde = count;
			
			do {

				graficoConsumo.Go();   
				
				--count;
				System.out.println("Faltam: " + count + " execuções para a conclusão do Unit Test.");

			} while (count != 0);

				System.out.println("Executado: " + qtde + " vezes...");
				System.out.println("Parabéns!!!" + "\n" + "Caso de Teste Aprovado para implementação do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");

		}

	}
	
}
