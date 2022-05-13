/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavEmail;

import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import br.org.coletivoJava.integracoes.restMavmail.api.caixapostal.FabApiRestMavMailCaixaPostal;
import br.org.coletivoJava.integracoes.restMavmail.api.dominio.FabApiRestMavMailDominio;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreMavMailTestesRegraNegocio;
import org.junit.Test;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author sfurbino
 */
public class TesteConformidade extends TestesApiRest {

    @Test
    public void testes() {
        SBCore.configurar(new ConfigCoreMavMailTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        gerarCodigos(FabApiRestMavMailCliente.class);
        gerarCodigos(FabApiRestMavMailDominio.class);
        gerarCodigos(FabApiRestMavMailCaixaPostal.class);
//        RespostaWebServiceSimples resposta = FabApiRestRokcetChatV1Users.DIRECT_MENSAGENS_CONTADORES.getAcao().getResposta();
        //      System.out.println(resposta);
        //     System.out.println(resposta.getRespostaTexto());
    }
}
