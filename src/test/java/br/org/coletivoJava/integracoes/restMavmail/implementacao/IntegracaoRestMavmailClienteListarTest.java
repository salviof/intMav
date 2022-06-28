/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreMavMailTestesRegraNegocio;
import org.json.simple.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import testesFW.TesteJunit;

/**
 *
 * @author sfurbino
 */
public class IntegracaoRestMavmailClienteListarTest extends TesteJunit {

    public IntegracaoRestMavmailClienteListarTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestMavmailClienteListar.
     */
    @Test
    public void testGerarCorpoRequisicao() {

        ItfAcaoApiRest listaDeClientes = (IntegracaoRestMavmailClienteRepListar) FabApiRestMavMailCliente.CLIENTE_REP_LISTAR.getAcao();
        ItfRespostaWebServiceSimples resposta = listaDeClientes.getResposta();
        if (resposta.isSucesso()) {
            System.out.println("Fuciona");
            String respostastr = resposta.getRetorno().toString();
            System.out.println(respostastr);
        }

        assertTrue("A lista de clientes não pode ser obtida", resposta.isSucesso());

    }

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreMavMailTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
    }

}
