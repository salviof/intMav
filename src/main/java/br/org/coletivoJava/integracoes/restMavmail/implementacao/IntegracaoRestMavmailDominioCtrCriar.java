package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailDominio;
import br.org.coletivoJava.integracoes.restMavmail.api.dominio.FabApiRestMavMailDominio;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ConsumoWSExecucao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailDominio(tipo = FabApiRestMavMailDominio.DOMINIO_CTR_CRIAR)
public class IntegracaoRestMavmailDominioCtrCriar
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestMavmailDominioCtrCriar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMavMailDominio.DOMINIO_CTR_CRIAR, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        StringBuilder corpoSolicitaccao = new StringBuilder();
        corpoSolicitaccao.append("token=").append(GestaoTokenRestMavmail.configuraca.getPropriedade(FabConfigMavMail.CAHVE_DE_ACESSO));
        corpoSolicitaccao.append("&APIid=").append(getParametros()[0]);
        corpoSolicitaccao.append("&domain=").append(getParametros()[0]);
        corpoSolicitaccao.append("&plan=").append("SUPRA2G");
        corpoSolicitaccao.append("&contract=").append(getParametros()[0]);
        corpoSolicitaccao.append("&accounts=").append(getParametros()[2]);

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
