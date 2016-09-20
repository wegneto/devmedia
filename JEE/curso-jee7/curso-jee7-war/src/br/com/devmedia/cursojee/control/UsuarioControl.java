package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Usuario;
import br.com.devmedia.cursojee.service.UsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioControl extends BasicControl implements Serializable {
    
    @EJB
    private UsuarioService service;
    
    private Usuario loggedUser;
    
    private String userName;
    
    private String password;
    
}
