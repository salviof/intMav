package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailCliente;
import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailCliente(tipo = FabApiRestMavMailCliente.CLIENTE_REP_LISTAR)
public class IntegracaoRestMavmailClienteRepListar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestMavmailClienteRepListar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMavMailCliente.CLIENTE_REP_LISTAR, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String chave=GestaoTokenRestMavmail.configuraca.getPropriedade(FabConfigMavMail.CHAVE_DE_ACESSO);
        return "token=" + chave;
    }

}
