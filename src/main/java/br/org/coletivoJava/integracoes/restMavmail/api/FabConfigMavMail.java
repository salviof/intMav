/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavmail.api;

import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ItfFabConfigModulo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.FabPropriedadeModuloIntegracaoOauth;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.InfoPropriedadeConfigRestIntegracao;

/**
 *
 * @author sfurbino
 * @since 07/12/2019
 * @version 1.0
 */
public enum FabConfigMavMail implements ItfFabConfigModulo {

    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.URL_SERVIDOR_API)
    URL_SERVIDOR_MAV_MAIL,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.CHAVE_PRIVADA)
    CAHVE_DE_ACESSO;

    public static final String NOME_APLICACAO = "MavMail";

    @Override
    public String getValorPadrao() {
        switch (this) {
            case URL_SERVIDOR_MAV_MAIL:
                return "https://painel.casanovadigital.com.br:5052";

            case CAHVE_DE_ACESSO:
                return "CONFIGURE_SUA_CHAVE";

            default:
                throw new AssertionError(this.name());

        }

    }

}
