/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.servicoDeEmail;

import br.org.coletivoJava.integracoes.restMavmail.api.pojo.RegistroDNSMav;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.financeiro.ItfPessoa;
import java.util.List;

/**
 *
 * @author sfurbino
 */
public interface ItfInfraServicoDeEmail {

    public List<ItfPessoa> getClientesLista();

    public ItfPessoa getCliente(String PIdentificadorUnico);
    
    public List<RegistroDNSMav> getRegistrosDNS(String pDominio);
    
    public ItfResposta clienteNovo(ItfPessoa pPessoaFisicoJuridica);

    public ItfResposta clienteRemover(ItfPessoa pPessoaFisicoJuridica);

    public ItfResposta dominioNovo(ItfInfraDominio pDominio);
    
   

}
