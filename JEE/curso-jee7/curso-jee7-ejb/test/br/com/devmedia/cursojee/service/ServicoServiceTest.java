package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Servico;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServicoServiceTest {
    
    private Servico servicoA;
    
    private Servico servicoB;
    
    private Servico servicoC;
    
    private EJBContainer container;
    
    private ServicoService instance;
    
    
    public ServicoServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws  Exception {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        instance = (ServicoService)container.getContext().lookup("java:global/classes/ServicoService");
        
        servicoA = new Servico();
        servicoA.setNome("testeServicoA" + new Random().nextInt());
        servicoA.setCusto(new BigDecimal(new Random().nextFloat()));
                
        servicoB = new Servico();
        servicoB.setNome("testeServicoB" + new Random().nextInt());
        servicoB.setCusto(new BigDecimal(new Random().nextFloat()));
        
        servicoC = new Servico();
        servicoC.setNome("testeServicoC" + new Random().nextInt());
        servicoC.setCusto(new BigDecimal(new Random().nextFloat()));
        
        servicoA = instance.addServico(servicoA);
        servicoB = instance.addServico(servicoB);
        servicoC = instance.addServico(servicoC);
    }
    
    @After
    public void tearDown() {
        instance.removeServico(servicoA);
        instance.removeServico(servicoB);
        instance.removeServico(servicoC);
        
        servicoA = null;
        servicoB = null;
        servicoC = null;
        
        container.close();
    }

    @Test
    public void testAddServico() throws Exception {
        Servico servico = null;
        Servico expResult = null;
        Servico result = instance.addServico(servico);
        assertEquals(expResult, result);
    }

    @Test
    public void testSetServico() throws Exception {
        Servico servico = null;
        Servico expResult = null;
        Servico result = instance.setServico(servico);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveServico() throws Exception {
        Servico servico = null;
        instance.removeServico(servico);
    }

    @Test
    public void testGetServico() throws Exception {
        int id = 0;
        Servico expResult = null;
        Servico result = instance.getServico(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetServicos() throws Exception {
        List<Servico> expResult = null;
        List<Servico> result = instance.getServicos();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetServicoByNome() throws Exception {
        String nome = "";
        List<Servico> expResult = null;
        List<Servico> result = instance.getServicoByNome(nome);
        assertEquals(expResult, result);
    }
    
}
