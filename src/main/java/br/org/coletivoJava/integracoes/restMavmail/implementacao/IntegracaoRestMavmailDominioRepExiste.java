package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailDominio;
import br.org.coletivoJava.integracoes.restMavmail.api.dominio.FabApiRestMavMailDominio;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailDominio(tipo = FabApiRestMavMailDominio.DOMINIO_REP_EXISTE)
public class IntegracaoRestMavmailDominioRepExiste
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestMavmailDominioRepExiste(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestMavMailDominio.DOMINIO_REP_EXISTE, pTipoAgente,
				pUsuario, pParametro);
	}
}