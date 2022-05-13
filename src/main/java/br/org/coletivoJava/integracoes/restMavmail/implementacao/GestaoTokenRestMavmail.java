package br.org.coletivoJava.integracoes.restMavmail.implementacao;

import br.org.coletivoJava.integracoes.restMavmail.api.InfoIntegracaoRestMavmailCliente;
import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import br.org.coletivoJava.integracoes.restMavmail.api.FabConfigMavMail;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ConfigModulo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenEstatico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestMavmailCliente(tipo = FabApiRestMavMailCliente.CLIENTE_REP_LISTAR)
public class GestaoTokenRestMavmail extends GestaoTokenEstatico {

    public static ConfigModulo configuraca = SBCore.getConfigModulo(FabConfigMavMail.class);

    public GestaoTokenRestMavmail(Class<? extends ItfFabricaIntegracaoRest> pClasseEndpoints, FabTipoAgenteClienteApi pTipoAgente, ItfUsuario pUsuario) {
        super(pClasseEndpoints, pTipoAgente, pUsuario);
    }

    public GestaoTokenRestMavmail(FabTipoAgenteClienteApi pApi, ItfUsuario pUsuario) {
        this(FabApiRestMavMailCliente.class, FabTipoAgenteClienteApi.SISTEMA, null);
    }

    @Override
    public ItfTokenDeAcessoExterno gerarNovoToken() {
        return new TokenDeAcessoExternoSimples(configuraca.getPropriedade(FabConfigMavMail.CHAVE_DE_ACESSO));
    }

    @Override
    public boolean validarToken() {
        return !configuraca.getPropriedade(FabConfigMavMail.CHAVE_DE_ACESSO).equals(FabConfigMavMail.CHAVE_DE_ACESSO.getValorPadrao());

    }

    @Override
    public ItfTokenDeAcessoExterno loadTokenArmazenado() {
        return new TokenDeAcessoExternoSimples(configuraca.getPropriedade(FabConfigMavMail.CHAVE_DE_ACESSO));
    }

}
