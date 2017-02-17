package br.com.devmedia.cursojee.control.converter;

import br.com.devmedia.cursojee.entities.Servico;
import br.com.devmedia.cursojee.service.ServicoService;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesConverter("servicoConverter")
public class ServicoConverter implements Converter {

    ServicoService servicoService = lookupServicoServiceBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            return lookupServicoServiceBean().getServicoByExactName(value.toString());
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else {
            return ((Servico) value).getNome();
        }
    }

    private ServicoService lookupServicoServiceBean() {
        try {
            Context c = new InitialContext();
            return (ServicoService) c.lookup("java:global/curso-jee7/curso-jee7-ejb/ServicoService!br.com.devmedia.cursojee.service.ServicoService");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
