package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Usuario;
import br.com.devmedia.cursojee.exception.AcessoInvalidoException;
import java.security.MessageDigest;
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

    @Test
    public void testAddUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setAdministrador(new Random().nextBoolean());
        usuario.setDentista(new Random().nextBoolean());
        usuario.setLogin("loginAdd" + new Random().nextInt());
        usuario.setNome("Teste de Adicao" + new Random().nextInt());
        usuario.setSenha(usuario.getLogin());
        
        Usuario result = instance.addUsuario(usuario);
        Usuario resultFromGet = instance.getUsuario(usuario.getId());
        
        assertEquals(resultFromGet, result);
        
        instance.removeUsuario(resultFromGet);
    }

    @Test
    public void testGetUsuario() {
        Usuario expResult = usuarioB;
        Usuario result = instance.getUsuario(usuarioB.getId());
        assertEquals(expResult, result);
    }

    @Test
    public void testSetUsuario() throws AcessoInvalidoException {
        Usuario usuario = usuarioC;
        Usuario expResult = usuarioC;
        usuario.setNome("Novo nome " + new Random().nextInt());
        
        Usuario result = instance.setUsuario(usuario);
        Usuario resultFromGet = instance.getUsuario(usuarioC.getId());
        assertEquals(expResult.getNome(), result.getNome());
        assertEquals(resultFromGet.getNome(), result.getNome());
    }

    @Test
    public void testRemoveUsuario() throws Exception {
        Usuario teste = new Usuario();
        teste.setAdministrador(new Random().nextBoolean());
        teste.setDentista(new Random().nextBoolean());
        teste.setLogin("loginRemove" + new Random().nextInt());
        teste.setNome("Teste de Remoção" + new Random().nextInt());
        teste.setSenha(teste.getLogin());
        
        teste = instance.addUsuario(teste);
        instance.removeUsuario(teste);
        
        Usuario removido = instance.getUsuario(teste.getId());
        assertNull(removido);
    }

    @Test
    public void testSetPassword() throws Exception {
        String senha = "NovaSenha"+new Random().nextInt();
        String md5 = getMD5(senha);
        instance.setPassword(senha, usuarioB.getId());
        Usuario usuario = instance.getUsuario(usuarioB.getId());
        assertEquals(usuario.getSenha(), md5);
    }
    
    private String getMD5(String message) {
        String digest = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return digest;
    }

    @Test
    public void testGetUsuarioByLoginPassword() throws Exception {
        String login = usuarioA.getLogin();
        String password = usuarioA.getLogin();
        Usuario expResult = usuarioA;
        Usuario result = instance.getUsuarioByLoginPassword(login, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUsers() throws Exception {
        List<Usuario> expResult = new LinkedList<>();
        expResult.add(usuarioA);
        expResult.add(usuarioB);
        expResult.add(usuarioC);
        
        List<Usuario> result = instance.getUsers();
        assertTrue(expResult.containsAll(result));
    }
    
}
