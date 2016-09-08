/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Cliente;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
public class ClienteServiceTest {
    
    private EJBContainer container;
    
    private ClienteService instance;
    
    private Cliente clienteA;
    
    private Cliente clienteB;
    
    private Cliente clienteC;
    
    public ClienteServiceTest() {
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
        instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        
        clienteA = new Cliente();
        clienteA.setEndereco("endereco A" + new Random().nextInt());
        clienteA.setIdade(Math.abs(new Random().nextInt(99)));
        clienteA.setDataNascimento(new Date());
        clienteA.setCidade("Cidade" + new Random().nextInt());
        clienteA.setComplemento("Complemento" + new Random().nextInt());
        clienteA.setNomePai("Pai " + new Random().nextInt());
        clienteA.setNomeMae("Mae " + new Random().nextInt());
        clienteA.setNome("Nome " + new Random().nextInt());
        clienteA.setObservacoes("Observacoes " + new Random().nextInt());
        clienteA.setOcupacao("Ocupacao " + new Random().nextInt());
        clienteA.setEstado("BA");
        clienteA.setTelefone("Telefone " + new Random().nextInt());
        clienteA.setTelefoneCelular("Celular " + new Random().nextInt());
        
    }
    
    @After
    public void tearDown() {
        instance.removeCliente(clienteA);
        instance.removeCliente(clienteB);
        instance.removeCliente(clienteC);
        
        container.close();
    }

    /**
     * Test of addCliente method, of class ClienteService.
     */
    @Test
    public void testAddCliente() throws Exception {
        System.out.println("addCliente");
        Cliente cliente = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClienteService instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        Cliente expResult = null;
        Cliente result = instance.addCliente(cliente);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class ClienteService.
     */
    @Test
    public void testSetCliente() throws Exception {
        System.out.println("setCliente");
        Cliente cliente = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClienteService instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        Cliente expResult = null;
        Cliente result = instance.setCliente(cliente);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCliente method, of class ClienteService.
     */
    @Test
    public void testRemoveCliente() throws Exception {
        System.out.println("removeCliente");
        Cliente cliente = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClienteService instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        instance.removeCliente(cliente);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class ClienteService.
     */
    @Test
    public void testGetCliente() throws Exception {
        System.out.println("getCliente");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClienteService instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        Cliente expResult = null;
        Cliente result = instance.getCliente(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientesComPagamentoEmAberto method, of class ClienteService.
     */
    @Test
    public void testGetClientesComPagamentoEmAberto() throws Exception {
        System.out.println("getClientesComPagamentoEmAberto");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClienteService instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        List<Cliente> expResult = null;
        List<Cliente> result = instance.getClientesComPagamentoEmAberto();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClienteByName method, of class ClienteService.
     */
    @Test
    public void testGetClienteByName() throws Exception {
        System.out.println("getClienteByName");
        String nome = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClienteService instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        List<Cliente> expResult = null;
        List<Cliente> result = instance.getClienteByName(nome);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClienteParaLigar method, of class ClienteService.
     */
    @Test
    public void testGetClienteParaLigar() throws Exception {
        System.out.println("getClienteParaLigar");
        int mes = 0;
        int ano = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClienteService instance = (ClienteService)container.getContext().lookup("java:global/classes/ClienteService");
        List<Cliente> expResult = null;
        List<Cliente> result = instance.getClienteParaLigar(mes, ano);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
