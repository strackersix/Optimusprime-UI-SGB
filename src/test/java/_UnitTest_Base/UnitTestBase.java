package _UnitTest_Base;

import org.junit.Assert;
import org.junit.Test;

import Login.Framework;

public class UnitTestBase {
	
	Framework login = new Framework();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();
			int count = 1;
			int qtde = count;
			
			do {

				// Após instânciar a classe, informar aqui o método encapsulado: 'Go'.   
				
				--count;
				System.out.println("Faltam: " + count + " execuções para a conclusão do Unit Test.");

			} while (count != 0);

				System.out.println("Executado: " + qtde + " vezes...");
				System.out.println("Parabéns!!!" + "\n" + "Caso de Teste Aprovado para implementação do SGB =)");

		} catch (Throwable e) {

			System.out.println("Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");
			Assert.fail();
		}

	}

}
