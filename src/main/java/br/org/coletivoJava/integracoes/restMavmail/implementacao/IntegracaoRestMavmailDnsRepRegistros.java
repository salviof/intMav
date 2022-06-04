package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailS;
import br.org.coletivoJava.integracoes.restMavmail.api.dns.FabApiRestMavDNS;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailS(tipo = FabApiRestMavDNS.DNS_REP_REGISTROS)
public class IntegracaoRestMavmailDnsRepRegistros
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestMavmailDnsRepRegistros(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestMavDNS.DNS_REP_REGISTROS, pTipoAgente, pUsuario,
				pParametro);
	}
        
    
    @Override
    public String gerarCorpoRequisicao() {
         String chave=GestaoTokenRestMavmail.configuraca.getPropriedade(FabConfigMavMail.CHAVE_DE_ACESSO);
        String dominio= (String) getParametros()[0];
        return "token=" + chave+"&domain="+dominio;
    }
}