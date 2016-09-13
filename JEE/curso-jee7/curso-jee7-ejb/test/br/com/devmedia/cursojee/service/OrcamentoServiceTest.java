/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.OrcamentoServico;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wegneto
 */
public class OrcamentoServiceTest {
    
    private EJBContainer container;
    
    private OrcamentoService instance;
    
    private ClienteService clienteService;
    
    private UsuarioService usuarioService;
    
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
        instance = (OrcamentoService)container.getContext().lookup("java:global/classes/OrcamentoService");
        
    }
    
    @After
    public void tearDown() {
        container.close();
    }

    /**
     * Test of addOrcamento method, of class OrcamentoService.
     */
    @Test
    public void testAddOrcamento() throws Exception {
        System.out.println("addOrcamento");
        Orcamento orcamento = null;
        Orcamento expResult = null;
        Orcamento result = instance.addOrcamento(orcamento);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrcamento method, of class OrcamentoService.
     */
    @Test
    public void testSetOrcamento() throws Exception {
        System.out.println("setOrcamento");
        Orcamento orcamento = null;
        Orcamento expResult = null;
        Orcamento result = instance.setOrcamento(orcamento);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrcamento method, of class OrcamentoService.
     */
    @Test
    public void testRemoveOrcamento() throws Exception {
        System.out.println("removeOrcamento");
        Orcamento orcamento = null;
        instance.removeOrcamento(orcamento);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrcamento method, of class OrcamentoService.
     */
    @Test
    public void testGetOrcamento() throws Exception {
        System.out.println("getOrcamento");
        int id = 0;
        Orcamento expResult = null;
        Orcamento result = instance.getOrcamento(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServico method, of class OrcamentoService.
     */
    @Test
    public void testGetServico() throws Exception {
        System.out.println("getServico");
        int orcamentoId = 0;
        List<OrcamentoServico> expResult = null;
        List<OrcamentoServico> result = instance.getServico(orcamentoId);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrcamentoServico method, of class OrcamentoService.
     */
    @Test
    public void testAddOrcamentoServico() throws Exception {
        System.out.println("addOrcamentoServico");
        OrcamentoServico orcamentoServico = null;
        OrcamentoServico expResult = null;
        OrcamentoServico result = instance.addOrcamentoServico(orcamentoServico);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrcamentoServico method, of class OrcamentoService.
     */
    @Test
    public void testSetOrcamentoServico() throws Exception {
        System.out.println("setOrcamentoServico");
        OrcamentoServico orcamentoServico = null;
        OrcamentoServico expResult = null;
        OrcamentoServico result = instance.setOrcamentoServico(orcamentoServico);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrcamentoServico method, of class OrcamentoService.
     */
    @Test
    public void testGetOrcamentoServico() throws Exception {
        System.out.println("getOrcamentoServico");
        int id = 0;
        OrcamentoServico expResult = null;
        OrcamentoServico result = instance.getOrcamentoServico(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrcamentoServico method, of class OrcamentoService.
     */
    @Test
    public void testRemoveOrcamentoServico() throws Exception {
        System.out.println("removeOrcamentoServico");
        OrcamentoServico orcamentoServico = null;
        instance.removeOrcamentoServico(orcamentoServico);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrcamentos method, of class OrcamentoService.
     */
    @Test
    public void testGetOrcamentos() throws Exception {
        System.out.println("getOrcamentos");
        int clienteId = 0;
        List<Orcamento> expResult = null;
        List<Orcamento> result = instance.getOrcamentos(clienteId);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
