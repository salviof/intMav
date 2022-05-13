/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.pojo.ClienteMav;
import br.org.coletivoJava.integracoes.servicoDeEmail.ItfInfraServicoDeEmail;
import br.org.coletivoJava.integracoes.servicoDeEmail.ServicoDeEmailImplementacaoBeta;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreMavMailTestesRegraNegocio;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sfurbino
 */
public class IntegracaoRestMavmailClienteCtrRemoverTest {

    public IntegracaoRestMavmailClienteCtrRemoverTest() {
    }

    /**
     * Test of gerarCorpoRequisicao method, of class
     * IntegracaoRestMavmailClienteCtrRemover.
     */
    @Test
    public void teste() {
        SBCore.configurar(new ConfigCoreMavMailTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfInfraServicoDeEmail servicoTEste = new ServicoDeEmailImplementacaoBeta();
        String identificador = "minasdrill.com.br";
        String nome = "Minasdrill";
        ClienteMav cliente = new ClienteMav();
        cliente.setIdentificadorAPI(identificador);
        cliente.setNome(nome);
        ItfResposta resposta = servicoTEste.clienteRemover(cliente);
        assertNotNull("erro obtendo pessoas, retornounulo", resposta);
        assertTrue("Retornou a pessoa Errada", resposta.isSucesso());
    }

}
