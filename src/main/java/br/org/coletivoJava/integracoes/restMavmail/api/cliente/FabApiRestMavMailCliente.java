/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavmail.api.cliente;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;
import com.super_bits.modulosSB.SBCore.modulos.ManipulaArquivo.importacao.FabTipoArquivoImportacao;

/**
 *
 * @author sfurbino
 */
@InfoConfigRestClientIntegracao(enderecosDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3",
        tipoAutenticacao = FabTipoAutenticacaoRest.USUARIO_SENHA_SIMPLES,
        nomeIntegracao = FabConfigMavMail.NOME_APLICACAO,
        configuracao = FabConfigMavMail.class
)
public enum FabApiRestMavMailCliente implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/listResselerClients",
            tipoConexao = FabTipoConexaoRest.POST,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#9006e582-711f-4314-bedc-613301419937")
    CLIENTE_REP_LISTAR,
    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/createClient",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            aceitarCertificadoDeHostNaoConfiavel = true,
            parametrosPost = {"APIid", "clientName"},
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#b4b49c87-4cec-483b-9f36-afd2b078f806"
    )
    CLIENTE_CTR_NOVO,
    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/deleteClient",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            aceitarCertificadoDeHostNaoConfiavel = true,
            parametrosPost = {"APIid", "clientName"},
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#b4b49c87-4cec-483b-9f36-afd2b078f806"
    )
    CLIENTE_CTR_REMOVER,
    /**
     * Atualmente suporta apenas pesquisas em canais vinculados a um ID, exemplo
     * nomeCanal-123 -> 123 representa o id
     */
    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/listResselerClients",
            tipoConexao = FabTipoConexaoRest.POST,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "ttps://documenter.getpostman.com/view/9632769/SWLiamS3#9006e582-711f-4314-bedc-613301419937")
    CLIENTE_REP_EXISTE,
    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/listClientDomains",
            tipoConexao = FabTipoConexaoRest.POST,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#9006e582-711f-4314-bedc-613301419937")
    CLIENTE_REP_DOMINIOS;

}
