package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Parcela;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinanceiroServiceTest {

    private EJBContainer container;
    private FinanceiroService financeiroService;

    public FinanceiroServiceTest() {
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
        financeiroService = (FinanceiroService) container.getContext().lookup("java:global/classes/FinanceiroService");
    }

    @After
    public void tearDown() {
        container.close();
    }

    @Test
    public void testGetParcela() throws Exception {
        System.out.println("getParcela");
        int id = 0;
        Parcela expResult = null;
        Parcela result = financeiroService.getParcela(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testSetParcela() throws Exception {
        System.out.println("setParcela");
        Parcela parcela = null;
        Parcela expResult = null;
        Parcela result = financeiroService.setParcela(parcela);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddParcela() throws Exception {
        System.out.println("addParcela");
        Parcela parcela = null;
        Parcela expResult = null;
        Parcela result = financeiroService.addParcela(parcela);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveParcela() throws Exception {
        System.out.println("removeParcela");
        Parcela parcela = null;
        financeiroService.removeParcela(parcela);
    }

    @Test
    public void testGetParcelasByOrcamento() throws Exception {
        System.out.println("getParcelasByOrcamento");
        int idOrcamento = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasByOrcamento(idOrcamento);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParcelasEmAberto() throws Exception {
        System.out.println("getParcelasEmAberto");
        int idOrcamento = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasEmAberto(idOrcamento);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParcelasPagas() throws Exception {
        System.out.println("getParcelasPagas");
        int idOrcamento = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasPagas(idOrcamento);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParcelasByCliente() throws Exception {
        System.out.println("getParcelasByCliente");
        int idCliente = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasByCliente(idCliente);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParcelasEmAbertoByCliente() throws Exception {
        System.out.println("getParcelasEmAbertoByCliente");
        int idCliente = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasEmAbertoByCliente(idCliente);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParcelasPagasByCliente() throws Exception {
        System.out.println("getParcelasPagasByCliente");
        int idCliente = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasPagasByCliente(idCliente);
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPagamentoParcela() throws Exception {
        System.out.println("setPagamentoParcela");
        int ipParcela = 0;
        Parcela expResult = null;
        Parcela result = financeiroService.setPagamentoParcela(ipParcela);
        assertEquals(expResult, result);
    }

}
