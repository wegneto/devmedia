package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.FormaPagamento;
import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.Usuario;
import java.math.BigDecimal;
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

public class ClienteServiceTest {
    
    private EJBContainer container;
    
    private ClienteService instance;
    
    private Cliente clienteA;
    
    private Cliente clienteB;
    
    private Cliente clienteC;
    
    private Usuario dentista;
    
    private UsuarioService usuarioService;
    
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
        usuarioService = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        
        clienteA = new Cliente();
        clienteA.setEndereco("endereco " + new Random().nextInt());
        clienteA.setIdade(Math.abs(new Random().nextInt(99)));
        clienteA.setDataNascimento(new Date());
        clienteA.setCidade("Cidade" + new Random().nextInt());
        clienteA.setComplemento("Complemento" + new Random().nextInt());
        clienteA.setNomePai("Pai " + new Random().nextInt());
        clienteA.setNomeMae("Mae " + new Random().nextInt());
        clienteA.setNome("Nome A " + new Random().nextInt());
        clienteA.setObservacoes("Observacoes " + new Random().nextInt());
        clienteA.setOcupacao("Ocupacao " + new Random().nextInt(20));
        clienteA.setEstado("BA");
        clienteA.setTelefone(new Random().nextInt(1234567890)+"");
        clienteA.setTelefoneCelular(new Random().nextInt(1234567890)+"");
        clienteA.setEnderecoComercial("Endereco Comercial " + new Random().nextInt());
        clienteA.setTelefoneComercial(new Random().nextInt(1234567890)+"");
        
        clienteB = new Cliente();
        clienteB.setEndereco("endereco " + new Random().nextInt());
        clienteB.setIdade(Math.abs(new Random().nextInt(99)));
        clienteB.setDataNascimento(new Date());
        clienteB.setCidade("Cidade" + new Random().nextInt());
        clienteB.setComplemento("Complemento" + new Random().nextInt());
        clienteB.setNomePai("Pai " + new Random().nextInt());
        clienteB.setNomeMae("Mae " + new Random().nextInt());
        clienteB.setNome("Nome B " + new Random().nextInt());
        clienteB.setObservacoes("Observacoes " + new Random().nextInt());
        clienteB.setOcupacao("Ocupacao " + new Random().nextInt(20));
        clienteB.setEstado("BA");
        clienteB.setTelefone(new Random().nextInt(1234567890)+"");
        clienteB.setTelefoneCelular(new Random().nextInt(1234567890)+"");
        clienteB.setEnderecoComercial("Endereco Comercial " + new Random().nextInt());
        clienteB.setTelefoneComercial(new Random().nextInt(1234567890)+"");
        
        clienteC = new Cliente();
        clienteC.setEndereco("endereco " + new Random().nextInt());
        clienteC.setIdade(Math.abs(new Random().nextInt(99)));
        clienteC.setDataNascimento(new Date());
        clienteC.setCidade("Cidade" + new Random().nextInt());
        clienteC.setComplemento("Complemento" + new Random().nextInt());
        clienteC.setNomePai("Pai " + new Random().nextInt());
        clienteC.setNomeMae("Mae " + new Random().nextInt());
        clienteC.setNome("Nome C " + new Random().nextInt());
        clienteC.setObservacoes("Observacoes " + new Random().nextInt());
        clienteC.setOcupacao("Ocupacao " + new Random().nextInt(20));
        clienteC.setEstado("BA");
        clienteC.setTelefone(new Random().nextInt(1234567890)+"");
        clienteC.setTelefoneCelular(new Random().nextInt(1234567890)+"");
        clienteC.setEnderecoComercial("Endereco Comercial " + new Random().nextInt());
        clienteC.setTelefoneComercial(new Random().nextInt(1234567890)+"");
        
        clienteA = instance.addCliente(clienteA);
        clienteB = instance.addCliente(clienteB);
        clienteC = instance.addCliente(clienteC);
        
        dentista = new Usuario();
        dentista.setAdministrador(new Random().nextBoolean());
        dentista.setDentista(Boolean.TRUE);
        dentista.setLogin("dentistaLoginA" + new Random().nextInt());
        dentista.setNome("dentistaNomeA" + new Random().nextInt());
        dentista.setSenha(dentista.getLogin());
        
        dentista = usuarioService.addUsuario(dentista);
        
    }
    
    @After
    public void tearDown() {
        instance.removeCliente(clienteA);
        instance.removeCliente(clienteB);
        instance.removeCliente(clienteC);
        
        usuarioService.removeUsuario(dentista);
        
        container.close();
    }

    @Test
    public void testAddCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setEndereco("endereco " + new Random().nextInt());
        cliente.setIdade(Math.abs(new Random().nextInt(99)));
        cliente.setDataNascimento(new Date());
        cliente.setCidade("Cidade" + new Random().nextInt());
        cliente.setComplemento("Complemento" + new Random().nextInt());
        cliente.setNomePai("Pai " + new Random().nextInt());
        cliente.setNomeMae("Mae " + new Random().nextInt());
        cliente.setNome("Nome Add " + new Random().nextInt());
        cliente.setObservacoes("Observacoes " + new Random().nextInt());
        cliente.setOcupacao("Ocupacao " + new Random().nextInt(20));
        cliente.setEstado("BA");
        cliente.setTelefone(new Random().nextInt(1234567890)+"");
        cliente.setTelefoneCelular(new Random().nextInt(1234567890)+"");
        cliente.setEnderecoComercial("Endereco Comercial " + new Random().nextInt());
        cliente.setTelefoneComercial(new Random().nextInt(1234567890)+"");
        
        Cliente result = instance.addCliente(cliente);
        Cliente expResult = instance.getCliente(result.getId());
        
        assertEquals(expResult, result);
        assertEquals(expResult.getNome(), result.getNome());
        
        instance.removeCliente(cliente);
    }

    @Test
    public void testSetCliente() throws Exception {
        String novoNome = "Novo nome do cliente" + new Random().nextInt();
        
        Cliente cliente = clienteA;
        cliente.setNome(novoNome);
        Cliente result = instance.setCliente(cliente);
        assertEquals(novoNome, result.getNome());
    }

    @Test
    public void testRemoveCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setEndereco("endereco " + new Random().nextInt());
        cliente.setIdade(Math.abs(new Random().nextInt(99)));
        cliente.setDataNascimento(new Date());
        cliente.setCidade("Cidade" + new Random().nextInt());
        cliente.setComplemento("Complemento" + new Random().nextInt());
        cliente.setNomePai("Pai " + new Random().nextInt());
        cliente.setNomeMae("Mae " + new Random().nextInt());
        cliente.setNome("Nome Remove " + new Random().nextInt());
        cliente.setObservacoes("Observacoes " + new Random().nextInt());
        cliente.setOcupacao("Ocupacao " + new Random().nextInt(20));
        cliente.setEstado("BA");
        cliente.setTelefone(new Random().nextInt(1234567890)+"");
        cliente.setTelefoneCelular(new Random().nextInt(1234567890)+"");
        cliente.setEnderecoComercial("Endereco Comercial " + new Random().nextInt());
        cliente.setTelefoneComercial(new Random().nextInt(1234567890)+"");
        Cliente toRemove = instance.addCliente(cliente);
        
        Cliente temp = instance.getCliente(toRemove.getId());
        assertNotNull(temp);
        
        instance.removeCliente(temp);
        
        Cliente temp2 = instance.getCliente(temp.getId());
        assertNull(temp2);
        
        
    }

    @Test
    public void testGetCliente() throws Exception {
        int id = clienteC.getId();
        Cliente expResult = clienteC;
        Cliente result = instance.getCliente(id);
        assertEquals(expResult, result);
    }

    //@Test
    public void testGetClientesComPagamentoEmAberto() throws Exception {
        List<Cliente> expResult = null;
        List<Cliente> result = instance.getClientesComPagamentoEmAberto();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetClienteByName() throws Exception {
        assertEquals(3, instance.getClienteByName("Nome").size());
        assertEquals(1, instance.getClienteByName("Nome A").size());
        assertEquals(1, instance.getClienteByName("Nome B").size());
        assertEquals(1, instance.getClienteByName("Nome C").size());
        assertEquals(0, instance.getClienteByName("Jose").size());
        
    }

    //@Test
    public void testGetClienteParaLigar() throws Exception {
        int mes = new Random().nextInt(13);
        if (mes == 0) {
            mes++;
        }
        int ano = 2016;
        
        Orcamento orcamento = new Orcamento();
        orcamento.setCliente(clienteA);
        orcamento.setDentista(dentista);
        orcamento.setVezes(10);
        orcamento.setTotal(BigDecimal.TEN);
        orcamento.setFormaPagamento(FormaPagamento.CREDITO);
        
        List<Cliente> expResult = null;
        List<Cliente> result = instance.getClienteParaLigar(mes, ano);
        assertEquals(expResult, result);
    }
    
}
