package br.com.devmedia.cursojee.control.converter;

import br.com.devmedia.cursojee.entities.Usuario;
import br.com.devmedia.cursojee.service.UsuarioService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

    UsuarioService usuarioService = lookupUsuarioServiceBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            return usuarioService.getUsuarioByExactName(value);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else {
            return ((Usuario)value).getNome();
        }
    }

    private UsuarioService lookupUsuarioServiceBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioService) c.lookup("java:global/curso-jee7/curso-jee7-ejb/UsuarioService!br.com.devmedia.cursojee.service.UsuarioService");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
