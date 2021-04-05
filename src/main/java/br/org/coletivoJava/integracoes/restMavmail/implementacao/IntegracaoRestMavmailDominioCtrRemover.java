package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailDominio;
import br.org.coletivoJava.integracoes.restMavmail.api.dominio.FabApiRestMavMailDominio;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ConsumoWSExecucao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailDominio(tipo = FabApiRestMavMailDominio.DOMINIO_CTR_REMOVER)
public class IntegracaoRestMavmailDominioCtrRemover
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestMavmailDominioCtrRemover(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMavMailDominio.DOMINIO_CTR_REMOVER, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        StringBuilder corpoSolicitaccao = new StringBuilder();
        corpoSolicitaccao.append("token=").append(GestaoTokenRestMavmail.configuraca.getPropriedade(FabConfigMavMail.CAHVE_DE_ACESSO));
        corpoSolicitaccao.append("&domain=").append(getParametros()[0]);
        return corpoSolicitaccao.toString();
    }

    @Override
    public void gerarResposta(ConsumoWSExecucao pConsumoRest) {
        super.gerarResposta(pConsumoRest); //To change body of generated methods, choose Tools | Templates.

        if (getResposta().isSucesso()) {
            String textoREsposta = getResposta().getRetorno().toString();
            if (!textoREsposta.toLowerCase().contains("ok")) {
                getResposta().addErro("A resposta não foi a resposta esperada:" + textoREsposta);
            }
        }
    }
}
