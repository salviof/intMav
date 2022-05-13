/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavmail.api.pojo;

import br.org.coletivoJava.integracoes.servicoDeEmail.ItfInfraDominio;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.financeiro.ItfPessoa;

/**
 *
 * @author sfurbino
 */
public class DominioMav implements ItfInfraDominio {

    private ClienteMav pessoaResponsavel;
    private String endereco;
    private int quantidadeDeCaixas;
    private String codigoContrato;

    @Override
    public ItfPessoa getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String pEndereco) {
        endereco = pEndereco;
    }

    public void setPessoaResponsavel(ClienteMav pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public int getQuantidadeDeCaixas() {
        return quantidadeDeCaixas;
    }

    public void setQuantidadeDeCaixas(int quantidadeDeCaixas) {
        this.quantidadeDeCaixas = quantidadeDeCaixas;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

}
