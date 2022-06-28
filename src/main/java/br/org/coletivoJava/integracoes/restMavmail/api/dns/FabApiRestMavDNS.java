/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.restMavmail.api.dns;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;

@InfoConfigRestClientIntegracao(enderecosDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3",
        tipoAutenticacao = FabTipoAutenticacaoRest.USUARIO_SENHA_SIMPLES,
        nomeIntegracao = FabConfigMavMail.NOME_APLICACAO, configuracao = FabConfigMavMail.class
)
public enum FabApiRestMavDNS implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/_REST/resellersAPI/listDNSRegistries",
            tipoConexao = FabTipoConexaoRest.POST,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://documenter.getpostman.com/view/9632769/SWLiamS3#5a723b6b-6912-47a7-ac9a-07a7784477dc")
    DNS_REP_REGISTROS;
}
