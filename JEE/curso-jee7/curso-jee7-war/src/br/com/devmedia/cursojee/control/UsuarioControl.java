package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Usuario;
import br.com.devmedia.cursojee.service.UsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.print.attribute.standard.Severity;
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
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", "Usuário ou senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/login.faces";
        } else {
            return "/index.faces";
        }
    }
    
}
