/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.servicoDeEmail;

import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.financeiro.ItfPessoa;

/**
 *
 * @author sfurbino
 */
public interface ItfInfraDominio {

    public ItfPessoa getPessoaResponsavel();

    public String getEndereco();

    public void setEndereco(String pEndereco);

}
