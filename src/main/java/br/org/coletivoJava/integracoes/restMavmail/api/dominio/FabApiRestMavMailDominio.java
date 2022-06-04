/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavmail.api.dominio;

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
@InfoConfigRestClientIntegracao(enderecosDocumentacao = "ttps://documenter.getpostman.com/view/9632769/SWLiamS3",
        tipoAutenticacao = FabTipoAutenticacaoRest.USUARIO_SENHA_SIMPLES,
        nomeIntegracao = FabConfigMavMail.NOME_APLICACAO,
        configuracao = FabConfigMavMail.class
)
public enum FabApiRestMavMailDominio implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/createDomain",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            parametrosPost = {"APIiddoCliente", "dominio", "qtd_contas"},
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#74ef2799-5a93-4fb1-933b-ad5aaa6adf03"    )
    DOMINIO_CTR_CRIAR,
    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/listAccountsByDomain",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            parametrosPost = {"dominio"},
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#74ef2799-5a93-4fb1-933b-ad5aaa6adf03"    )
    DOMINIO_REP_EXISTE,
    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/deleteDomain",
            tipoConexao = FabTipoConexaoRest.POST,
            tipoInformacaoEnviada = FabTipoArquivoImportacao.JSON,
            parametrosPost = {"dominio"},
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#1bf804d8-ea0f-48bd-85bf-4e16d6461ac2"    )
    DOMINIO_CTR_REMOVER;
    

}
