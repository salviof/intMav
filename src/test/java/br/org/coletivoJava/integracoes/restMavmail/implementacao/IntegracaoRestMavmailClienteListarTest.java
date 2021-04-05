/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ConsumoWSExecucao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreMavMailTestesRegraNegocio;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sfurbino
 */
public class IntegracaoRestMavmailClienteListarTest {

    public IntegracaoRestMavmailClienteListarTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestMavmailClienteListar.
     */
    @Test
    public void testGerarCorpoRequisicao() {

        SBCore.configurar(new ConfigCoreMavMailTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfAcaoApiRest listaDeClientes = (IntegracaoRestMavmailClienteRepListar) FabApiRestMavMailCliente.CLIENTE_REP_LISTAR.getAcao();
        RespostaWebServiceSimples resposta = listaDeClientes.getResposta();
        if (resposta.isSucesso()) {
            System.out.println("Fuciona");
            JSONObject json = resposta.getRespostaComoObjetoJson();
        } else {
            String respostaString = resposta.getResposta();
            String respostaErro = resposta.getRespostaErro();
        }
        assertTrue("A lista de clientes não pode ser obtida", resposta.isSucesso());

    }

}
