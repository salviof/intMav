package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailCliente;
import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ConsumoWSExecucao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailCliente(tipo = FabApiRestMavMailCliente.CLIENTE_REP_DOMINIOS)
public class IntegracaoRestMavmailClienteRepDominios
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestMavmailClienteRepDominios(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMavMailCliente.CLIENTE_REP_DOMINIOS, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        StringBuilder corpoSolicitaccao = new StringBuilder();
        corpoSolicitaccao.append("token=").append(GestaoTokenRestMavmail.configuraca.getPropriedade(FabConfigMavMail.CHAVE_DE_ACESSO));
        corpoSolicitaccao.append("&APIid=").append(getParametros()[0]);
        return corpoSolicitaccao.toString();
    }

    @Override
    public void gerarResposta(ConsumoWSExecucao pConsumoRest) {
        super.gerarResposta(pConsumoRest); //To change body of generated methods, choose Tools | Templates.

        if (getResposta().isSucesso()) {
            String textoREsposta = getResposta().getRetorno().toString();
            if (!textoREsposta.toLowerCase().contains("domains")) {
                getResposta().addErro("A resposta não foi a resposta esperada:" + textoREsposta);
            }
        }
    }
}
