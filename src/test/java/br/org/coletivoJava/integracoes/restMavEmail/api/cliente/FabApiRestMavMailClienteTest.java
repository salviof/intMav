/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavEmail.api.cliente;

import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreMavMailTestesRegraNegocio;
import org.junit.Test;
import static org.junit.Assert.*;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author sfurbino
 */
public class FabApiRestMavMailClienteTest extends TestesApiRest {

    public FabApiRestMavMailClienteTest() {
    }

    /**
     * Test of values method, of class FabApiRestMavMailCliente.
     */
    @Test
    public void testValues() {
        SBCore.configurar(new ConfigCoreMavMailTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        FabApiRestMavMailCliente.CLIENTE_REP_LISTAR.getAcao();

        //  FabApiRestMavMailCliente.CLIENTE_REP_EXISTE.getAcao("pimentahomeservice");
    }

}
