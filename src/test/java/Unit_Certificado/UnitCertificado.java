package Unit_Certificado;

import org.junit.Test;

import Certificado.Framework;

public class UnitCertificado {

	Login.Framework login = new Login.Framework();
	Framework gerarCertificadoConsolidado = new Framework();
	
	@Test
	public void Unit() {

		try {

			login.GoLogin();
			int count = 50;

			do {

				gerarCertificadoConsolidado.GoTestGerarCertificadoPDFConsolidado();
				--count;
				System.out.println("Faltam: " + count + " execuções para a conclusão do Unit Test.");

			} while (count != 0);

				System.out.println("Parabéns!!!" + "\n" + "Caso de Teste Aprovado para receber implementação do SGB =)");

		} catch (Throwable e) {

			System.out.println(	"Ops!!!" + "\n" + "Que pena, o seu teste falhou =..( " + "\n" + "Vamos verificar o ocorrido.");

		}

	}

}
