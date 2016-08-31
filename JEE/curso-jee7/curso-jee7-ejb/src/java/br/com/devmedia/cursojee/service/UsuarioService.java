package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Usuario;
import br.com.devmedia.cursojee.service.repositories.UsuarioRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UsuarioService extends BasicService {

    @PersistenceContext
    private EntityManager em;

    private UsuarioRepository usrRepo;

    @PostConstruct
    @PostActivate
    private void postConstruct() {
        usrRepo = new UsuarioRepository(em);
    }

    public UsuarioService() {
    }

    public Usuario addUsuario(Usuario usuario) {
        return usrRepo.addUsuario(usuario);
    }

    public Usuario getUsuario(int id) {
        return usrRepo.getUsuario(id);
    }
    
    public Usuario setUsuario(Usuario usuario) {
        return usrRepo.setUsuario(usuario);
    }
    
    public void removeUsuario(Usuario usuario) {
        usrRepo.removeUsuario(usuario);
    }
    
    public void setPassword(String password, int id) {
        usrRepo.setPassword(password, id);
    }
    
    public Usuario getUsuarioByLoginPassword(String login, String password) {
        return usrRepo.getUsuarioByLoginPassword(login, password);
    }
    
    public List<Usuario> getUsers() {
        return usrRepo.getUsers();
    }
    
}
