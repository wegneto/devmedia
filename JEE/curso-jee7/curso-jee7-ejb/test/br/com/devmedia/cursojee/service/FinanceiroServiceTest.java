package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.FormaPagamento;
import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.Parcela;
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

public class FinanceiroServiceTest {

    private EJBContainer container;
    private FinanceiroService financeiroService;
    
    private OrcamentoService orcamentoService;

    private ClienteService clienteService;

    private UsuarioService usuarioService;

    private ServicoService servicoService;

    private Cliente cliente;

    private PodamFactory podam;

    private Orcamento orcamento;

    private Servico servico;

    private Usuario dentista;

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
        orcamentoService = (OrcamentoService) container.getContext().lookup("java:global/classes/OrcamentoService");
        usuarioService = (UsuarioService) container.getContext().lookup("java:global/classes/UsuarioService");
        clienteService = (ClienteService) container.getContext().lookup("java:global/classes/ClienteService");
        servicoService = (ServicoService) container.getContext().lookup("java:global/classes/ServicoService");

        podam = new PodamFactoryImpl();

        cliente = new Cliente();
        podam.populatePojo(cliente);
        cliente = clienteService.addCliente(cliente);

        dentista = new Usuario();
        podam.populatePojo(dentista);
        dentista = usuarioService.addUsuario(dentista);

        servico = new Servico();
        podam.populatePojo(servico);
        servico = servicoService.addServico(servico);

        orcamento = new Orcamento();
        podam.populatePojo(orcamento);
        orcamento.setCliente(cliente);
        orcamento.setDentista(dentista);
        orcamento.setFormaPagamento(FormaPagamento.CREDITO);
        orcamento = orcamentoService.addOrcamento(orcamento);
    }

    @After
    public void tearDown() {
        orcamentoService.removeOrcamento(orcamento);
        servicoService.removeServico(servico);
        usuarioService.removeUsuario(dentista);
        clienteService.removeCliente(cliente);
        
        container.close();
    }
    
    private Parcela prepararObjeto() {
        Parcela parcela = new Parcela();
        podam.populatePojo(parcela);
        parcela.setOrcamento(orcamento);

        return parcela;
    }
    
    @Test
    public void testAddParcela() throws Exception {
        System.out.println("addParcela");
        Parcela parcela = prepararObjeto();
        Parcela result = financeiroService.addParcela(parcela);
        Parcela expResult = financeiroService.getParcela(result.getId());

        assertEquals(expResult, result);
        
        financeiroService.removeParcela(result);
    }

    @Test
    public void testGetParcela() throws Exception {
        System.out.println("getParcela");
        Parcela parcela = prepararObjeto();
        parcela = financeiroService.addParcela(parcela);
        Parcela expResult = parcela;
        Parcela result = financeiroService.getParcela(parcela.getId());
        assertEquals(expResult, result);
        
        financeiroService.removeParcela(parcela);
    }

    //@Test
    public void testSetParcela() throws Exception {
        System.out.println("setParcela");
        Parcela parcela = null;
        Parcela expResult = null;
        Parcela result = financeiroService.setParcela(parcela);
        assertEquals(expResult, result);
    }

    //@Test
    public void testRemoveParcela() throws Exception {
        System.out.println("removeParcela");
        Parcela parcela = null;
        financeiroService.removeParcela(parcela);
    }

    //@Test
    public void testGetParcelasByOrcamento() throws Exception {
        System.out.println("getParcelasByOrcamento");
        int idOrcamento = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasByOrcamento(idOrcamento);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetParcelasEmAberto() throws Exception {
        System.out.println("getParcelasEmAberto");
        int idOrcamento = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasEmAberto(idOrcamento);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetParcelasPagas() throws Exception {
        System.out.println("getParcelasPagas");
        int idOrcamento = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasPagas(idOrcamento);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetParcelasByCliente() throws Exception {
        System.out.println("getParcelasByCliente");
        int idCliente = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasByCliente(idCliente);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetParcelasEmAbertoByCliente() throws Exception {
        System.out.println("getParcelasEmAbertoByCliente");
        int idCliente = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasEmAbertoByCliente(idCliente);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetParcelasPagasByCliente() throws Exception {
        System.out.println("getParcelasPagasByCliente");
        int idCliente = 0;
        List<Parcela> expResult = null;
        List<Parcela> result = financeiroService.getParcelasPagasByCliente(idCliente);
        assertEquals(expResult, result);
    }

    //@Test
    public void testSetPagamentoParcela() throws Exception {
        System.out.println("setPagamentoParcela");
        int ipParcela = 0;
        Parcela expResult = null;
        Parcela result = financeiroService.setPagamentoParcela(ipParcela);
        assertEquals(expResult, result);
    }

}
