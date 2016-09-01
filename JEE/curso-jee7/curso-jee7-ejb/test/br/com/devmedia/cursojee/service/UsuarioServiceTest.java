package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Usuario;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioServiceTest {
    
    private Usuario usuarioA;
    
    private Usuario usuarioB;
    
    private Usuario usuarioC;
    
    private EJBContainer container;
    
    private UsuarioService instance;
    
    public UsuarioServiceTest() {
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
        instance = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        
        usuarioA = new Usuario();
        usuarioA.setAdministrador(new Random().nextBoolean());
        usuarioA.setDentista(new Random().nextBoolean());
        usuarioA.setLogin("testeLoginA" + new Random().nextInt());
        usuarioA.setNome("testeNomeA" + new Random().nextInt());
        usuarioA.setSenha(usuarioA.getLogin());
        
        usuarioB = new Usuario();
        usuarioB.setAdministrador(new Random().nextBoolean());
        usuarioB.setDentista(new Random().nextBoolean());
        usuarioB.setLogin("testeLoginB" + new Random().nextInt());
        usuarioB.setNome("testeNomeB" + new Random().nextInt());
        usuarioB.setSenha(usuarioB.getLogin());
        
        usuarioC = new Usuario();
        usuarioC.setAdministrador(new Random().nextBoolean());
        usuarioC.setDentista(new Random().nextBoolean());
        usuarioC.setLogin("testeLoginB" + new Random().nextInt());
        usuarioC.setNome("testeNomeB" + new Random().nextInt());
        usuarioC.setSenha(usuarioC.getLogin());
        
        usuarioA = instance.addUsuario(usuarioA);
        usuarioB = instance.addUsuario(usuarioB);
        usuarioC = instance.addUsuario(usuarioC);
    }
    
    @After
    public void tearDown() {
        instance.removeUsuario(usuarioA);
        instance.removeUsuario(usuarioB);
        instance.removeUsuario(usuarioC);
        
        usuarioA = null;
        usuarioB = null;
        usuarioC = null;
        
        container.close();
    }

    /**
     * Test of addUsuario method, of class UsuarioService.
     */
    //@Test
    public void testAddUsuario() throws Exception {
        System.out.println("addUsuario");
        Usuario usuario = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioService instance = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        Usuario expResult = null;
        Usuario result = instance.addUsuario(usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsuario() {
        Usuario expResult = usuarioB;
        Usuario result = instance.getUsuario(usuarioB.getId());
        assertEquals(expResult, result);
    }

    @Test
    public void testSetUsuario() {
        Usuario usuario = usuarioC;
        Usuario expResult = usuarioC;
        usuario.setNome("Novo nome " + new Random().nextInt());
        
        Usuario result = instance.setUsuario(usuario);
        Usuario resultFromGet = instance.getUsuario(usuarioC.getId());
        assertEquals(expResult.getNome(), result.getNome());
        assertEquals(resultFromGet.getNome(), result.getNome());
    }

    /**
     * Test of removeUsuario method, of class UsuarioService.
     */
    //@Test
    public void testRemoveUsuario() throws Exception {
        System.out.println("removeUsuario");
        Usuario usuario = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioService instance = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        instance.removeUsuario(usuario);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class UsuarioService.
     */
    //@Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        String password = "";
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioService instance = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        instance.setPassword(password, id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioByLoginPassword method, of class UsuarioService.
     */
    //@Test
    public void testGetUsuarioByLoginPassword() throws Exception {
        System.out.println("getUsuarioByLoginPassword");
        String login = "";
        String password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioService instance = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        Usuario expResult = null;
        Usuario result = instance.getUsuarioByLoginPassword(login, password);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class UsuarioService.
     */
    //@Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioService instance = (UsuarioService)container.getContext().lookup("java:global/classes/UsuarioService");
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getUsers();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
