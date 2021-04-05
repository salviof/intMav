package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailPostal;
import br.org.coletivoJava.integracoes.restMavmail.api.caixapostal.FabApiRestMavMailCaixaPostal;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ConsumoWSExecucao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailPostal(tipo = FabApiRestMavMailCaixaPostal.CAIXA_POSTAL_CTR_NOVO)
public class IntegracaoRestMavmailCaixaPostalCtrNovo
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestMavmailCaixaPostalCtrNovo(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestMavMailCaixaPostal.CAIXA_POSTAL_CTR_NOVO, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        StringBuilder corpoSolicitaccao = new StringBuilder();
        corpoSolicitaccao.append("token=").append(GestaoTokenRestMavmail.configuraca.getPropriedade(FabConfigMavMail.CAHVE_DE_ACESSO));
        corpoSolicitaccao.append("&domain=").append(getParametros()[0]);
        corpoSolicitaccao.append("&group=").append("Padrão");
        corpoSolicitaccao.append("&email=").append(getParametros()[1]);
        corpoSolicitaccao.append("&isVirtual=").append("false");
        corpoSolicitaccao.append("&isGoogle=").append("false");
//token=b2fgh11jj112v33b000m0ac2205&domain=teste.com&group=GrupoTeste&email=teste%40teste.com&password=123456
        return corpoSolicitaccao.toString();
    }

    @Override
    public void gerarResposta(ConsumoWSExecucao pConsumoRest) {
        super.gerarResposta(pConsumoRest); //To change body of generated methods, choose Tools | Templates.
        String textoREsposta = getResposta().getRetorno().toString();
        if (!textoREsposta.toLowerCase().contains("ok")) {
            getResposta().addErro("A resposta não foi a resposta esperada:" + textoREsposta);
        }
    }
}
