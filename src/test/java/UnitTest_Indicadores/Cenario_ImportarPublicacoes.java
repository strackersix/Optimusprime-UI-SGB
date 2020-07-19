package UnitTest_Indicadores;

import org.junit.Test;

import Indicadores.Framework;

public class Cenario_ImportarPublicacoes {

	Login.Framework login = new Login.Framework();
	Framework importarPublicacoes = new Framework();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();
						
			int count = 5;
			int qtde = count;
			
			do {

				importarPublicacoes.Go();
				
				--count;
				System.out.println("Faltam: " + count + " execu��es para a conclus�o do Unit Test." + "\n");

			} while (count != 0);

				System.out.println("Executado: " + qtde + " vezes...");
				System.out.println("Parab�ns!!!" + "\n" + "Caso de Teste Aprovado para implementa��o do SGB =)" + "\n");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");

		}

	}















}
