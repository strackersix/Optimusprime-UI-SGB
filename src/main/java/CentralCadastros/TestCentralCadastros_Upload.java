package CentralCadastros;

import org.junit.Assert;
import org.junit.Test;

import _CORE.Parametros;

public class TestCentralCadastros_Upload {
	
	
	Framework Step = new Framework();
	
	@Test
	
	public void ExecutaCentralCadastros_Upload () throws InterruptedException {
		
// Upload - Tipo de Documento: CONTRATO DE ENERGIA		
		
		Step.Url(Parametros.UrlPowerView);
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos1();
		
		Step.EnviarArquivo();
		Step.UploadArquivo();
		Step.TipoDocumento("Contrato de Energia");
		Step.Estagio1("Proposta");
		Step.DataVigenciaInicio("02/01/2020");
		Step.DataVigenciaFim("31/12/2021");
		Step.Contraparte("Fornecedor");
		Step.NumeroDoContrato("a1b2c3");
		Step.CompartilharCom();
		Step.Confirmar();
		Step.Atualizar();
		
		Assert.assertEquals("CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Contrato de energia", Step.ValidaTipo());

		Step.EditarUpload();
		
		Assert.assertEquals("CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CONTRATO DE ENERGIA", Step.ValidaTipoDocumento());
		Assert.assertEquals("PROPOSTA", Step.ValidaEstagio());
		Assert.assertEquals("FORNECEDOR", Step.ValidaContraparte());
		Assert.assertEquals("A1B2C3", Step.ValidaNumeroContrato());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos2();
		
		Assert.assertEquals("CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Contrato de energia", Step.ValidaTipo());
	
		
		Step.EditarUpload();
		
		Assert.assertEquals("CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CONTRATO DE ENERGIA", Step.ValidaTipoDocumento());
		Assert.assertEquals("PROPOSTA", Step.ValidaEstagio());
		Assert.assertEquals("FORNECEDOR", Step.ValidaContraparte());
		Assert.assertEquals("A1B2C3", Step.ValidaNumeroContrato());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos3();
		
		Assert.assertEquals("CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Contrato de energia", Step.ValidaTipo());
		
		Step.EditarUpload();
		
		Assert.assertEquals("CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CONTRATO DE ENERGIA", Step.ValidaTipoDocumento());
		Assert.assertEquals("PROPOSTA", Step.ValidaEstagio());
		Assert.assertEquals("FORNECEDOR", Step.ValidaContraparte());
		Assert.assertEquals("A1B2C3", Step.ValidaNumeroContrato());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
				
		Step.ExcluirUpload();
		
		Assert.assertEquals(" ", Step.ValidaExclusao());
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//		

// Upload - Tipo de Documento: CONTRATO DE GESTAO
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos1();
		
		Step.EnviarArquivo();
		Step.UploadArquivo();
		Step.TipoDocumento("Contrato de Gestão");
		Step.Estagio2("Minuta");
		Step.DataVigenciaInicio("02/01/2020");
		Step.DataVigenciaFim("31/12/2021");
		Step.CompartilharCom();
		Step.Confirmar();
		Step.Atualizar();
		
		Assert.assertEquals("MINUTA_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("Inicio em 02/01/2020", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Contrato de gestão", Step.ValidaTipo());

		Step.EditarUpload();
		
		Assert.assertEquals("MINUTA_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CONTRATO DE GESTÃO", Step.ValidaTipoDocumento());
		Assert.assertEquals("MINUTA", Step.ValidaEstagio());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos2();
		
		Assert.assertEquals("MINUTA_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("Inicio em 02/01/2020", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Contrato de gestão", Step.ValidaTipo());
	
		
		Step.EditarUpload();
		
		Assert.assertEquals("MINUTA_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CONTRATO DE GESTÃO", Step.ValidaTipoDocumento());
		Assert.assertEquals("MINUTA", Step.ValidaEstagio());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos3();
		
		Assert.assertEquals("MINUTA_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("Inicio em 02/01/2020", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Contrato de gestão", Step.ValidaTipo());
		
		Step.EditarUpload();
		
		Assert.assertEquals("MINUTA_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CONTRATO DE GESTÃO", Step.ValidaTipoDocumento());
		Assert.assertEquals("MINUTA", Step.ValidaEstagio());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
				
		Step.ExcluirUpload();
		
		Assert.assertEquals(" ", Step.ValidaExclusao());		
		
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//		
		
// Upload - Tipo de Documento: ADITIVO DE GESTÃO
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos1();
		
		Step.EnviarArquivo();
		Step.UploadArquivo();
		Step.TipoDocumento("Aditivo de gestão");
		Step.Estagio2("Contrato");
		Step.DataVigenciaInicio("02/01/2020");
		Step.DataVigenciaFim("31/12/2021");
		Step.NumeroAditivo("123456789");
		Step.CompartilharCom();
		Step.Confirmar();
		Step.Atualizar();
		
		Assert.assertEquals("123456789_ADITIVO_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("Inicio em 02/01/2020", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Aditivo de gestão", Step.ValidaTipo());

		Step.EditarUpload();
		
		Assert.assertEquals("123456789_ADITIVO_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaArquivo());
		Assert.assertEquals("ADITIVO DE GESTÃO", Step.ValidaTipoDocumento());
		Assert.assertEquals("CONTRATO", Step.ValidaEstagio());
		Assert.assertEquals("123456789", Step.ValidaNumeroAditivo());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos2();
		
		Assert.assertEquals("123456789_ADITIVO_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("Inicio em 02/01/2020", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Aditivo de gestão", Step.ValidaTipo());
	
		
		Step.EditarUpload();
		
		Assert.assertEquals("123456789_ADITIVO_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaArquivo());
		Assert.assertEquals("ADITIVO DE GESTÃO", Step.ValidaTipoDocumento());
		Assert.assertEquals("CONTRATO", Step.ValidaEstagio());
		Assert.assertEquals("123456789", Step.ValidaNumeroAditivo());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos3();
		
		Assert.assertEquals("123456789_ADITIVO_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("Inicio em 02/01/2020", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Aditivo de gestão", Step.ValidaTipo());
		
		Step.EditarUpload();
		
		Assert.assertEquals("123456789_ADITIVO_GEREN_POWERVIEWBALANCO_x_COMERC.pdf", Step.ValidaArquivo());
		Assert.assertEquals("ADITIVO DE GESTÃO", Step.ValidaTipoDocumento());
		Assert.assertEquals("CONTRATO", Step.ValidaEstagio());
		Assert.assertEquals("123456789", Step.ValidaNumeroAditivo());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
				
		Step.ExcluirUpload();
		
		Assert.assertEquals(" ", Step.ValidaExclusao());		
		
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//
		
// Upload - Tipo de Documento: ADITIVO DE ENERGIA	
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos1();
		
		Step.EnviarArquivo();
		Step.UploadArquivo();
		Step.TipoDocumento("Aditivo de Energia");
		Step.Estagio2("Proposta");
		Step.DataVigenciaInicio("02/01/2020");
		Step.DataVigenciaFim("31/12/2021");
		Step.Contraparte("Fornecedor");
		Step.NumeroAditivo2("123456789");
		Step.NumeroDoContrato3("a1b2c3");
		Step.CompartilharCom();
		Step.Confirmar();
		Step.Atualizar();
		
		Assert.assertEquals("123456789_ADITIVO_CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Aditivo de energia", Step.ValidaTipo());

		Step.EditarUpload();
		
		Assert.assertEquals("123456789_ADITIVO_CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaArquivo());
		Assert.assertEquals("ADITIVO DE ENERGIA", Step.ValidaTipoDocumento());
		Assert.assertEquals("PROPOSTA", Step.ValidaEstagio());
		Assert.assertEquals("FORNECEDOR", Step.ValidaContraparte());
		Assert.assertEquals("123456789", Step.ValidaNumeroContrato());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos2();
		
		Assert.assertEquals("123456789_ADITIVO_CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Aditivo de energia", Step.ValidaTipo());
	
		
		Step.EditarUpload();
		
		Assert.assertEquals("123456789_ADITIVO_CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaArquivo());
		Assert.assertEquals("ADITIVO DE ENERGIA", Step.ValidaTipoDocumento());
		Assert.assertEquals("PROPOSTA", Step.ValidaEstagio());
		Assert.assertEquals("FORNECEDOR", Step.ValidaContraparte());
		Assert.assertEquals("123456789", Step.ValidaNumeroContrato());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos3();
		
		Assert.assertEquals("123456789_ADITIVO_CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("Aditivo de energia", Step.ValidaTipo());
		
		Step.EditarUpload();
		
		Assert.assertEquals("123456789_ADITIVO_CCVEE_POWERVIEWBALANCO_x_FORNECEDOR_A1B2C3.pdf", Step.ValidaArquivo());
		Assert.assertEquals("ADITIVO DE ENERGIA", Step.ValidaTipoDocumento());
		Assert.assertEquals("PROPOSTA", Step.ValidaEstagio());
		Assert.assertEquals("FORNECEDOR", Step.ValidaContraparte());
		Assert.assertEquals("123456789", Step.ValidaNumeroContrato());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
				
		Step.ExcluirUpload();
		
		Assert.assertEquals(" ", Step.ValidaExclusao());
		
//----------------------------------------------------------------------//------------------------------------------------------------------------------//		
		
		// Upload - Tipo de Documento: CUSD
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos1();
		
		Step.EnviarArquivo();
		Step.UploadArquivo();
		Step.TipoDocumento("CUSD");
		Step.Estagio2("Minuta");
		Step.DataVigenciaInicio("02/01/2020");
		Step.DataVigenciaFim("31/12/2021");
		Step.Distribuidora("Pax");
		Step.CompartilharCom();
		Step.Confirmar();
		Step.Atualizar();
		
		Assert.assertEquals("MINUTA_CUSD_POWERVIEWBALANCO_X_DISTRIBUIDORA.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("CUSD", Step.ValidaTipo());

		Step.EditarUpload();
		
		Assert.assertEquals("MINUTA_CUSD_POWERVIEWBALANCO_X_DISTRIBUIDORA.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CUSD", Step.ValidaTipoDocumento());
		Assert.assertEquals("MINUTA", Step.ValidaEstagio());
		Assert.assertEquals("PAX", Step.ValidaDistribuidora());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos2();
		
		Assert.assertEquals("MINUTA_CUSD_POWERVIEWBALANCO_X_DISTRIBUIDORA.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("CUSD", Step.ValidaTipo());
	
		
		Step.EditarUpload();
		
		Assert.assertEquals("MINUTA_CUSD_POWERVIEWBALANCO_X_DISTRIBUIDORA.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CUSD", Step.ValidaTipoDocumento());
		Assert.assertEquals("MINUTA", Step.ValidaEstagio());
		Assert.assertEquals("PAX", Step.ValidaDistribuidora());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 3" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
		
		Step.MinhaConta();
		Step.CentralCadastro();
		Step.AcessarUpload();
		Step.Celula("POWERVIEW");
		Step.GrupoEconomico("POWERVIEW BALANCO");
		Step.GrupoEmpresa("POWERVIEW BALANCO");
		Step.Estado("SÃO PAULO");
		Step.filtrar();
		
		Step.GerenciarDocumentos3();
		
		Assert.assertEquals("MINUTA_CUSD_POWERVIEWBALANCO_X_DISTRIBUIDORA.pdf", Step.ValidaNomeDocumento());
		Assert.assertEquals("02/01/2020 Até 31/12/2021", Step.ValidaDataVigencia());
		Assert.assertEquals("VIGENTE", Step.ValidaStatus());
		Assert.assertEquals("CUSD", Step.ValidaTipo());
		
		Step.EditarUpload();
		
		Assert.assertEquals("MINUTA_CUSD_POWERVIEWBALANCO_X_DISTRIBUIDORA.pdf", Step.ValidaArquivo());
		Assert.assertEquals("CUSD", Step.ValidaTipoDocumento());
		Assert.assertEquals("MINUTA", Step.ValidaEstagio());
		Assert.assertEquals("PAX", Step.ValidaDistribuidora());
		Assert.assertEquals("POWERVIEW BALANCO UNID 1" , Step.ValidaPrimeiraUnidade());
		Assert.assertEquals("POWERVIEW BALANCO UNID 2" , Step.ValidaSegundaUnidade());
		
		Step.Cancelar();
				
		Step.ExcluirUpload();
		
		Assert.assertEquals(" ", Step.ValidaExclusao());
		
		
	}
		
}
