package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailPostal;
import br.org.coletivoJava.integracoes.restMavmail.api.caixapostal.FabApiRestMavMailCaixaPostal;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailPostal(tipo = FabApiRestMavMailCaixaPostal.CAIXA_POSTAL_RP_EXISTE)
public class IntegracaoRestMavmailCaixaPostalRpExiste
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestMavmailCaixaPostalRpExiste(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestMavMailCaixaPostal.CAIXA_POSTAL_RP_EXISTE, pTipoAgente,
				pUsuario, pParametro);
	}
}