/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.servicoDeEmail;

import br.org.coletivoJava.integracoes.restMavmail.api.pojo.ClienteMav;
import br.org.coletivoJava.integracoes.restMavmail.api.pojo.DominioMav;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreMavMailTestesRegraNegocio;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.financeiro.ItfPessoa;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import testesFW.TesteJunit;

/**
 *
 * @author sfurbino
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicoDeEmailImplementacaoBetaTest extends TesteJunit {

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreMavMailTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
    }

    /**
     * Test of getClientesLista method, of class
     * ServicoDeEmailImplementacaoBeta.
     */
    /**
     * Test of clienteNovo method, of class ServicoDeEmailImplementacaoBeta.
     */
    @Test
    public void _3testClienteNovo() {
        ItfInfraServicoDeEmail servicoTEste = new ServicoDeEmailImplementacaoBeta();
        String identificador = "apenasteste.com.br";
        String nome = "Apenenas Teste";
        ClienteMav cliente = new ClienteMav();
        cliente.setIdentificadorAPI(identificador);
        cliente.setNome(nome);
        ItfResposta resposta = servicoTEste.clienteNovo(cliente);
        assertNotNull("erro obtendo pessoas, retornounulo", resposta);
        assertTrue("Retornou a pessoa Errada", resposta.isSucesso());

    }

    @Test()
    public void _31testGetClientesLista() {
        ItfInfraServicoDeEmail servicoTEste = new ServicoDeEmailImplementacaoBeta();
        List<ItfPessoa> pessoasResponsaveis = servicoTEste.getClientesLista();
        assertNotNull("erro obtendo pessoas, retornounulo", pessoasResponsaveis);
        assertFalse("Nenuma pessoa encontrada", pessoasResponsaveis.isEmpty());
    }

    /**
     * Test of getCliente method, of class ServicoDeEmailImplementacaoBeta.
     */
    @Test
    public void _32testGetCliente() {
        ItfInfraServicoDeEmail servicoTEste = new ServicoDeEmailImplementacaoBeta();
        String identificador = "pimentahomeservice.com.br";
        ItfPessoa pessoa = servicoTEste.getCliente(identificador);
        assertNotNull("erro obtendo pessoas, retornounulo", pessoa);
        assertTrue("Retornou a pessoa Errada", ((ClienteMav) pessoa).getIdentificadorAPI().equals(identificador) || ((ClienteMav) pessoa).getNome().equals(identificador));

    }

    @Test
    public void _4testDominioNovo() {

        ItfInfraServicoDeEmail servicoTEste = new ServicoDeEmailImplementacaoBeta();
        String identificador = "apenasteste.com.br";
        String nome = "Apenenas Teste";
        ClienteMav cliente = new ClienteMav();
        cliente.setIdentificadorAPI(identificador);
        cliente.setNome(nome);
        DominioMav novoDominio = new DominioMav();
        novoDominio.setEndereco(cliente.getIdentificadorAPI());
        novoDominio.setPessoaResponsavel(cliente);
        novoDominio.setQuantidadeDeCaixas(1);
        ItfResposta resposta = servicoTEste.dominioNovo(novoDominio);
        assertNotNull("erro obtendo pessoas, retornounulo", resposta);
        assertTrue("Retornou a pessoa Errada", resposta.isSucesso());
    }

    @Test
    public void _5testClientCriarUsuario() {

        ServicoDeEmailImplementacaoBeta servicoTEste = new ServicoDeEmailImplementacaoBeta();

        ItfResposta resposta = servicoTEste.criarCaixaDeEntrata("teste@apenasteste.com.br");
        assertNotNull("erro obtendo pessoas, retornounulo", resposta);
        assertTrue("Falha criando caixa de entrada", resposta.isSucesso());
    }

    /**
     * Test of clienteRemover method, of class ServicoDeEmailImplementacaoBeta.
     */
    @Test
    public void _6testClienteRemover() {

        ItfInfraServicoDeEmail servicoTEste = new ServicoDeEmailImplementacaoBeta();
        String identificador = "apenasteste.com.br";
        String nome = "Apenenas Teste";
        ClienteMav cliente = new ClienteMav();
        cliente.setIdentificadorAPI(identificador);
        cliente.setNome(nome);
        ItfResposta resposta = servicoTEste.clienteRemover(cliente);
        assertNotNull("erro obtendo pessoas, retornounulo", resposta);
        assertTrue("Retornou a pessoa Errada", resposta.isSucesso());
    }

    /**
     * Test of dominioNovo method, of class ServicoDeEmailImplementacaoBeta.
     */
}
