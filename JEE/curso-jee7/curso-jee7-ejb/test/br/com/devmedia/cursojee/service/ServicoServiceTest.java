package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Servico;
import java.math.BigDecimal;
import java.util.LinkedList;
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
        Servico servico = new Servico();
        servico.setNome("Teste de inclusão " + new Random().nextInt());
        servico.setCusto(new BigDecimal(new Random().nextFloat()));
        Servico result = instance.addServico(servico);
        Servico expResult = instance.getServico(result.getId());
        instance.removeServico(result);
        assertEquals(expResult.getNome(), result.getNome());
    }

    @Test
    public void testSetServico() throws Exception {
        Servico servico = servicoA;
        String novoNome = "Teste de alteração " + new Random().nextInt();
        servico.setNome(novoNome);
        
        Servico result = instance.setServico(servico);
        Servico expResult = instance.getServico(servico.getId());
        
        assertEquals(novoNome, expResult.getNome());
    }

    @Test
    public void testRemoveServico() throws Exception {
        Servico servico = new Servico();
        servico.setNome("Teste de remocao " + new Random().nextInt());
        servico.setCusto(new BigDecimal(new Random().nextFloat()));
        
        servico = instance.addServico(servico);
        
        instance.removeServico(servico);
        
        Servico removido = instance.getServico(servico.getId());
        assertNull(removido);
    }

    @Test
    public void testGetServico() throws Exception {
        Servico expResult = servicoA;
        Servico result = instance.getServico(servicoA.getId());
        assertEquals(expResult.getId(), result.getId());
    }

    @Test
    public void testGetServicos() throws Exception {
        List<Servico> expResult = new LinkedList<>();
        expResult.add(servicoA);
        expResult.add(servicoB);
        expResult.add(servicoC);
        
        List<Servico> result = instance.getServicos();
        assertTrue(expResult.containsAll(result));
    }

    @Test
    public void testGetServicoByNome() throws Exception {
        assertEquals(3, instance.getServicoByNome("testeServico").size());
        assertEquals(1, instance.getServicoByNome("testeServicoA").size());
        assertEquals(1, instance.getServicoByNome("testeServicoB").size());
        assertEquals(1, instance.getServicoByNome("testeServicoC").size());
        assertEquals(0, instance.getServicoByNome("xpto" + new Random().nextInt()).size());
    }
    
}
