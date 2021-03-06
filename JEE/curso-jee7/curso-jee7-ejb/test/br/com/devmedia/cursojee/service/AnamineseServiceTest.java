package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Anaminese;
import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.FormaPagamento;
import br.com.devmedia.cursojee.entities.Orcamento;
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

public class AnamineseServiceTest {

    private EJBContainer container;

    private AnamineseService anamineseService;

    private OrcamentoService orcamentoService;

    private ClienteService clienteService;

    private UsuarioService usuarioService;

    private ServicoService servicoService;

    private Cliente cliente;

    private PodamFactory podam;

    private Orcamento orcamento;

    private Servico servico;

    private Usuario dentista;

    public AnamineseServiceTest() {
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
        anamineseService = (AnamineseService) container.getContext().lookup("java:global/classes/AnamineseService");
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

    @Test
    public void testAddAnaminese() throws Exception {
        System.out.println("addAnaminese");

        Anaminese anaminese = prepararObjeto();

        Anaminese result = anamineseService.addAnaminese(anaminese);
        Anaminese expResult = anamineseService.getAnaminese(result.getId());

        assertEquals(expResult, result);

        anamineseService.removeAnaminese(anaminese);
    }

    private Anaminese prepararObjeto() {
        Anaminese anaminese = new Anaminese();
        podam.populatePojo(anaminese);
        anaminese.setCliente(cliente);
        anaminese.setOrcamento(orcamento);

        return anaminese;
    }

    //@Test
    public void testSetAnaminese() throws Exception {
        System.out.println("setAnaminese");
        Anaminese anaminese = prepararObjeto();
        Anaminese expResult = null;
        Anaminese result = anamineseService.setAnaminese(anaminese);
    }

    //@Test
    public void testRemoveAnaminese() throws Exception {
        System.out.println("removeAnaminese");
        Anaminese anaminese = null;
        anamineseService.removeAnaminese(anaminese);
    }

    //@Test
    public void testGetAnaminese() throws Exception {
        System.out.println("getAnaminese");
        int id = 0;
        Anaminese expResult = null;
        Anaminese result = anamineseService.getAnaminese(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAnaminesesByCliente() throws Exception {
        System.out.println("getAnaminesesByCliente");

        Anaminese anaminese1 = prepararObjeto();
        anamineseService.addAnaminese(anaminese1);

        Anaminese anaminese2 = prepararObjeto();
        anamineseService.addAnaminese(anaminese2);

        Anaminese anaminese3 = prepararObjeto();
        anamineseService.addAnaminese(anaminese3);

        List<Anaminese> result = anamineseService.getAnaminesesByCliente(cliente);
        assertEquals(3, result.size());

        anamineseService.removeAnaminese(anaminese1);
        anamineseService.removeAnaminese(anaminese2);
        anamineseService.removeAnaminese(anaminese3);
    }

    @Test
    public void testGetAnaminesesByOrcamento() throws Exception {
        System.out.println("getAnaminesesByOrcamento");
        
        Anaminese anaminese1 = prepararObjeto();
        anamineseService.addAnaminese(anaminese1);

        Anaminese anaminese2 = prepararObjeto();
        anamineseService.addAnaminese(anaminese2);

        Anaminese anaminese3 = prepararObjeto();
        anamineseService.addAnaminese(anaminese3);
        
        List<Anaminese> result = anamineseService.getAnaminesesByOrcamento(orcamento);
        assertEquals(3, result.size());
        
        anamineseService.removeAnaminese(anaminese1);
        anamineseService.removeAnaminese(anaminese2);
        anamineseService.removeAnaminese(anaminese3);
    }

}
