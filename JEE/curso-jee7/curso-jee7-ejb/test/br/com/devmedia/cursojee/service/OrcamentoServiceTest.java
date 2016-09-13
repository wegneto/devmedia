/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.FormaPagamento;
import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.OrcamentoServico;
import br.com.devmedia.cursojee.entities.Servico;
import br.com.devmedia.cursojee.entities.Usuario;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author wegneto
 */
public class OrcamentoServiceTest {
    
    private EJBContainer container;
    
    private OrcamentoService orcamentoService;
    
    private ClienteService clienteService;
    
    private UsuarioService usuarioService;
    
    private ServicoService servicoService;
    
    public OrcamentoServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        orcamentoService = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        usuarioService = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        clienteService = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        servicoService = (ServicoService)container.getContext().lookup("java:global/classes/ServicoService");
    }
    
    @After
    public void tearDown() {
        container.close();
    }

    @Test
    public void testAddOrcamento() throws Exception {
        System.out.println("addOrcamento");
        PodamFactory factory = new PodamFactoryImpl();
        
        Cliente cliente = new Cliente();
        factory.populatePojo(cliente);
        cliente = clienteService.addCliente(cliente);
        
        Usuario dentista = new Usuario();
        factory.populatePojo(dentista);
        dentista = usuarioService.addUsuario(dentista);
        
        Servico servico = new Servico();
        factory.populatePojo(servico);
        servico = servicoService.addServico(servico);
        
        Orcamento orcamento = new Orcamento();
        factory.populatePojo(orcamento);
        orcamento.setCliente(cliente);
        orcamento.setDentista(dentista);
        orcamento.setFormaPagamento(FormaPagamento.CARTAO);
        
        OrcamentoServico orcamentoServico = new OrcamentoServico();
        factory.populatePojo(orcamentoServico);
        orcamentoServico.setOrcamento(orcamento);
        orcamentoServico.setServico(servico);
        
        orcamento.addServico(orcamentoServico);

        Orcamento result = orcamentoService.addOrcamento(orcamento);        
        Orcamento expResult = orcamentoService.getOrcamento(result.getId());
        
        assertEquals(expResult, result);
        
        orcamentoService.removeOrcamento(orcamento);
        servicoService.removeServico(servico);
        usuarioService.removeUsuario(dentista);
        clienteService.removeCliente(cliente);
    }

    //@Test
    public void testSetOrcamento() throws Exception {
        System.out.println("setOrcamento");
        Orcamento orcamento = null;
        Orcamento expResult = null;
        Orcamento result = orcamentoService.setOrcamento(orcamento);
        assertEquals(expResult, result);
    }

    //@Test
    public void testRemoveOrcamento() throws Exception {
        System.out.println("removeOrcamento");
        Orcamento orcamento = null;
        orcamentoService.removeOrcamento(orcamento);
    }

    //@Test
    public void testGetOrcamento() throws Exception {
        System.out.println("getOrcamento");
        int id = 0;
        Orcamento expResult = null;
        Orcamento result = orcamentoService.getOrcamento(id);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetServico() throws Exception {
        System.out.println("getServico");
        int orcamentoId = 0;
        List<OrcamentoServico> expResult = null;
        List<OrcamentoServico> result = orcamentoService.getServico(orcamentoId);
        assertEquals(expResult, result);
    }

    //@Test
    public void testAddOrcamentoServico() throws Exception {
        System.out.println("addOrcamentoServico");
        OrcamentoServico orcamentoServico = null;
        OrcamentoServico expResult = null;
        OrcamentoServico result = orcamentoService.addOrcamentoServico(orcamentoServico);
        assertEquals(expResult, result);
    }

    //@Test
    public void testSetOrcamentoServico() throws Exception {
        System.out.println("setOrcamentoServico");
        OrcamentoServico orcamentoServico = null;
        OrcamentoServico expResult = null;
        OrcamentoServico result = orcamentoService.setOrcamentoServico(orcamentoServico);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetOrcamentoServico() throws Exception {
        System.out.println("getOrcamentoServico");
        int id = 0;
        OrcamentoServico expResult = null;
        OrcamentoServico result = orcamentoService.getOrcamentoServico(id);
        assertEquals(expResult, result);
    }

    //@Test
    public void testRemoveOrcamentoServico() throws Exception {
        System.out.println("removeOrcamentoServico");
        OrcamentoServico orcamentoServico = null;
        orcamentoService.removeOrcamentoServico(orcamentoServico);
    }

    //@Test
    public void testGetOrcamentos() throws Exception {
        System.out.println("getOrcamentos");
        int clienteId = 0;
        List<Orcamento> expResult = null;
        List<Orcamento> result = orcamentoService.getOrcamentos(clienteId);
        assertEquals(expResult, result);
    }
    
}
