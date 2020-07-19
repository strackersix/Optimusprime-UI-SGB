package AutenticacaoJira;

import org.junit.Test;

import AutenticacaoJira.Framework;
import _CORE.Parametros;

public class TestAutenticacaoJira {

	
	Framework Step = new Framework();
	
	@Test
	
	public void ExecutaLoginJira () {
		
		Step.Maximizar();
		Step.UrlJira(Parametros.UrlJira);
		Step.Usuario(Parametros.UsuarioJira);
		Step.Senha(Parametros.SenhaJira);
		Step.Entrar();
		
	}
	
}
