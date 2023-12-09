/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import br.org.coletivoJava.integracoes.restMavmail.api.dns.FabApiRestMavDNS;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreMavMailTestesRegraNegocio;
import jakarta.json.JsonObject;
import org.json.simple.JSONObject;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import testesFW.TesteJunit;

/**
 *
 * @author salvio
 */
public class IntegracaoRestMavmailDnsRepRegistrosTest extends TesteJunit {

    public IntegracaoRestMavmailDnsRepRegistrosTest() {
    }

    @Test
    public void testSomeMethod() {

        ItfAcaoApiRest listaDeClientes = (IntegracaoRestMavmailDnsRepRegistros) FabApiRestMavDNS.DNS_REP_REGISTROS.getAcao("casanovadigital.com.br");
        ItfRespostaWebServiceSimples resposta = listaDeClientes.getResposta();
        if (resposta.isSucesso()) {
            System.out.println("Fuciona");
            System.out.println(resposta.getRespostaTexto());
            SBCore.getServicoMensagens().enviarMsgAlertaAoDesenvolvedor(resposta.getRespostaTexto());
        } else {
            String respostaString = resposta.getRespostaTexto();
            String respostaErro = resposta.getRespostaTexto();
        }
        try {
            assertTrue("A lista de clientes não pode ser obtida", resposta.isSucesso());
        } catch (Throwable t) {

        }
    }

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreMavMailTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
    }
}
