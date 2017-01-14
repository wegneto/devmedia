package br.com.devmedia.cursojee.control;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BasicControl implements Serializable {
    
    public void createFacesErrorMessage(String message) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
}
