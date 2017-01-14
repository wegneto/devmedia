package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Usuario;
import br.com.devmedia.cursojee.exception.AcessoInvalidoException;
import br.com.devmedia.cursojee.service.UsuarioService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Named
@SessionScoped
public class UsuarioControl extends BasicControl implements Serializable {
    
    @EJB
    private UsuarioService service;
    
    private Usuario loggedUser;
    
    @NotNull(message = "O nome de usuário não pode ser vazio")
    @NotEmpty(message = "O nome de usuário não pode ser vazio")
    private String userName;
    
    @NotNull(message = "A senha não pode ser vazia")
    @NotEmpty(message = "A senha não pode ser vazia")
    @Length(message = "Sua senha deve conter no mínimo 3 caracteres")
    private String password;
    
    private String localizar;
    
    private List<Usuario> filtrado;
    
    private Usuario usuarioSelected;

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public UsuarioService getService() {
        return service;
    }

    public void setService(UsuarioService service) {
        this.service = service;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Usuario loggedUser) {
        this.loggedUser = loggedUser;
    }
    
    public String doLogin() {
        loggedUser = null;
        loggedUser = service.getUsuarioByLoginPassword(this.userName, this.password);
        if (loggedUser == null) {
            createFacesErrorMessage("\"Usuário ou senha inválidos\"");
            return "/login.faces";
        } else {
            return "/restrito/index.faces?faces-redirect=true";
        }
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("[DevMedia] UsuarioControl iniciou!");
    }
    
    public List<Usuario> getUsers() {
        return service.getUsers();
    }
    
    public String getLocalizar() {
        return localizar;
    }

    public void setLocalizar(String localizar) {
        this.localizar = localizar;
    }

    public List<Usuario> getFiltrado() {
        if (filtrado == null) {
            return getUsers();
        }
        return filtrado;
    }

    public void setFiltrado(List<Usuario> filtrado) {
        this.filtrado = filtrado;
    }
    
    public String doLocalizar() {
        filtrado = service.getUsersByName(getLocalizar());
        return "usuarios.faces";
    }
    
    public String addUsuario() {
        setUsuarioSelected(new Usuario());
        return "/restrito/addUsuario.faces";
    }
    
    public String createUsuario() {
        setFiltrado(null);
        try {
            service.addUsuario(usuarioSelected);
        } catch (AcessoInvalidoException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/restrito/addUsuario.faces";
        }
        return "/restrito/usuarios.faces";
    }
    
    public String removeUsuario() {
        setFiltrado(null);
        if (usuarioSelected.equals(loggedUser)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não é possível excluir o usuário autenticado no momento", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            service.removeUsuario(usuarioSelected);
        }
        
        return "/restrito/usuarios.faces";
    }
    
    public String editUsuario() {
        return "/restrito/editUsuario.faces";
    }
    
    public String editSenha() {
        getUsuarioSelected().setSenha("");
        return "/restrito/editSenha.faces";
    }
    
    public String updateUsuario() {
        setFiltrado(null);
        try {
            service.setUsuario(usuarioSelected);
        } catch (AcessoInvalidoException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/restrito/editUsuario.faces";
        }
        return "/restrito/usuarios.faces";
    }
    
    public String updateSenha() {
        setFiltrado(null);
        service.setPassword(getUsuarioSelected().getSenha(), getUsuarioSelected().getId());
        return "/restrito/usuarios.faces";
    }
    
}
