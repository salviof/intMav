/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.servicoDeEmail;

import br.org.coletivoJava.integracoes.restMavmail.api.cliente.FabApiRestMavMailCliente;
import br.org.coletivoJava.integracoes.restMavmail.api.caixapostal.FabApiRestMavMailCaixaPostal;
import br.org.coletivoJava.integracoes.restMavmail.api.dominio.FabApiRestMavMailDominio;
import br.org.coletivoJava.integracoes.restMavmail.api.pojo.ClienteMav;
import br.org.coletivoJava.integracoes.restMavmail.api.pojo.DominioMav;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.financeiro.ItfPessoa;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.financeiro.ItfPessoaFisicoJuridico;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * Uma implementação beta, consiste na primera versão de uma implementação de
 * módulo ERP do Framework Coletivojava.com.br, esses módulos permiten abstrair
 * camadas pelo ponto de vista de soluções que possam ser alteradas usando
 * injeção de dependencia.
 *
 * O nome final, implementação beta, é proposital para obrigar a refatoração
 * quando for modularizado.
 *
 *
 * @author sfurbino
 */
public class ServicoDeEmailImplementacaoBeta implements ItfInfraServicoDeEmail {

    @Override
    public List<ItfPessoa> getClientesLista() {
        ItfResposta resp = FabApiRestMavMailCliente.CLIENTE_REP_LISTAR.getAcao().getResposta();

        if (!resp.isSucesso()) {
            return null;
        }
        List<ItfPessoa> listaPessoas = new ArrayList<>();
        String retorno = resp.getRetorno().toString();
        InputSource is = new InputSource(new StringReader(retorno));

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlsDoc = db.parse(is);
            xmlsDoc.normalize();
            Object clientesXML = xmlsDoc.getElementsByTagName("clients");
            NodeList nList = (NodeList) clientesXML;
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                Element elemento = (Element) node;
                NodeList clientesListagem = elemento.getElementsByTagName("client");
                for (int tempClient = 0; tempClient < clientesListagem.getLength(); tempClient++) {
                    Node cliente = clientesListagem.item(tempClient);
                    if (cliente == null) {

                        System.out.println("putamerda");
                    } else {

                        Element clienteElemento = (Element) cliente;
                        String nome = clienteElemento.getElementsByTagName("name").item(0).getTextContent();
                        String identificadorAPI = clienteElemento.getElementsByTagName("APIid").item(0).getTextContent();
                        ClienteMav clienteInstancia = new ClienteMav();
                        clienteInstancia.setNome(nome);
                        clienteInstancia.setIdentificadorAPI(identificadorAPI);
                        listaPessoas.add(clienteInstancia);
                    }
                }

            }
            return listaPessoas;

        } catch (SAXException ex) {
            Logger.getLogger(ServicoDeEmailImplementacaoBeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicoDeEmailImplementacaoBeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ServicoDeEmailImplementacaoBeta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public ItfPessoa getCliente(String PIdentificadorUnico) {
        Optional<ItfPessoa> pessoaEncontrada = getClientesLista().stream().filter(pessoa
                -> (((ClienteMav) pessoa).getIdentificadorAPI().equals(PIdentificadorUnico) || ((ClienteMav) pessoa).getNome().equals(PIdentificadorUnico))).findFirst();
        if (!pessoaEncontrada.isPresent()) {
            return null;
        }
        return pessoaEncontrada.get();
    }

    @Override
    public ItfResposta clienteNovo(ItfPessoa pPessoaFisicoJuridica) {
        ClienteMav pcliente = (ClienteMav) pPessoaFisicoJuridica;
        ItfResposta resp = FabApiRestMavMailCliente.CLIENTE_CTR_NOVO.getAcao(pcliente.getIdentificadorAPI(), pcliente.getNome()).getResposta();
        String stringRetorno = resp.getRetorno().toString();
        return resp;
    }

    @Override
    public ItfResposta clienteRemover(ItfPessoa pPessoaFisicoJuridica) {
        ClienteMav pcliente = (ClienteMav) pPessoaFisicoJuridica;
        ItfResposta respDominios = FabApiRestMavMailCliente.CLIENTE_REP_DOMINIOS.getAcao(pcliente.getIdentificadorAPI()).getResposta();
        if (respDominios.isSucesso()) {
            String dominiosstr = respDominios.getRetorno().toString();
            List<DominioMav> dominios = getParseDominiosDoCliente(pcliente, dominiosstr);
            for (DominioMav dm : dominios) {
                ItfResposta resp = FabApiRestMavMailDominio.DOMINIO_CTR_REMOVER.getAcao(dm.getEndereco()).getResposta();
                if (resp.isSucesso()) {
                    System.out.println("Dominio " + dm.getEndereco() + " removido com sucesso");
                } else {
                    System.out.println("Falha removendo Dominio " + dm.getEndereco());
                }
            }
        }
        ItfResposta resp = FabApiRestMavMailCliente.CLIENTE_CTR_REMOVER.getAcao(pcliente.getIdentificadorAPI()).getResposta();
        String stringRetorno = resp.getRetorno().toString();
        return resp;
    }

    private List<DominioMav> getParseDominiosDoCliente(ClienteMav pCliente, String pTexto) {
        InputSource is = new InputSource(new StringReader(pTexto));
        List<DominioMav> listaDominios = new ArrayList();
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlsDoc = db.parse(is);
            xmlsDoc.normalize();
            Object clientesXML = xmlsDoc.getElementsByTagName("domains");
            NodeList nList = (NodeList) clientesXML;
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                Element elemento = (Element) node;
                NodeList clientesListagem = elemento.getElementsByTagName("domain");
                for (int tempClient = 0; tempClient < clientesListagem.getLength(); tempClient++) {
                    Node dominioNode = clientesListagem.item(tempClient);
                    if (dominioNode == null) {

                        System.out.println("putamerda");
                    } else {

                        Element clienteElemento = (Element) dominioNode;
                        String dominiostr = clienteElemento.getTextContent();
                        DominioMav dominio = new DominioMav();
                        dominio.setPessoaResponsavel(pCliente);
                        dominio.setEndereco(dominiostr);
                        listaDominios.add(dominio);
                    }
                }

            }
            return listaDominios;

        } catch (SAXException ex) {
            Logger.getLogger(ServicoDeEmailImplementacaoBeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicoDeEmailImplementacaoBeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ServicoDeEmailImplementacaoBeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ItfResposta dominioNovo(ItfInfraDominio pDominio) {
        DominioMav dominioMav = (DominioMav) pDominio;
        ClienteMav cliente = (ClienteMav) pDominio.getPessoaResponsavel();
        ItfResposta resp = FabApiRestMavMailDominio.DOMINIO_CTR_CRIAR.getAcao(cliente.getIdentificadorAPI(), dominioMav.getEndereco(), dominioMav.getQuantidadeDeCaixas()).getResposta();
        String stringRetorno = resp.getRetorno().toString();
        boolean sucesso = resp.isSucesso();
        return resp;
    }

    public ItfResposta dominioExiste(ItfInfraDominio pDominio) {
        DominioMav dominioMav = (DominioMav) pDominio;
        ClienteMav cliente = (ClienteMav) pDominio.getPessoaResponsavel();
        ItfResposta resp = FabApiRestMavMailDominio.DOMINIO_CTR_CRIAR.getAcao(cliente.getIdentificadorAPI(), dominioMav.getEndereco()).getResposta();
        String stringRetorno = resp.getRetorno().toString();
        return resp;
    }

    public ItfResposta criarCaixaDeEntrata(String pCaixaDeEntrada) {
        String dominio = pCaixaDeEntrada.substring(pCaixaDeEntrada.indexOf("@") + 1);
        ItfResposta resp = FabApiRestMavMailCaixaPostal.CAIXA_POSTAL_CTR_NOVO.getAcao(dominio, pCaixaDeEntrada).getResposta();
        String stringRetorno = resp.getRetorno().toString();
        return resp;
    }

}
