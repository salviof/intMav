package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ConfigModulo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoHeaderBuilder;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.json.simple.JSONObject;

public class IntegracaoRestMavmail_HeaderPadrao
        extends
        AcaoApiIntegracaoHeaderBuilder {

    public IntegracaoRestMavmail_HeaderPadrao(final ItfAcaoApiRest pAcao) {
        super(pAcao);
    }

    @Override
    public void buildHeaderPadrao() {
        //super.buildHeaderPadrao(); //chamada super do metodo (implementação classe pai)

        cabecalho.put("Content-type", "application/x-www-form-urlencoded");

    }
}
