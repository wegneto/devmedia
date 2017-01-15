package br.com.devmedia.cursojee.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class BasicControl implements Serializable {
    
    private SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy"); 

    public void createFacesErrorMessage(String message) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    protected Set<ConstraintViolation<Serializable>> getViolations(Serializable entidade) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Serializable>> retorno = validator.validate(entidade);
        return retorno;
    }
    
    protected boolean checkViolations(Serializable entidade) {
        Set<ConstraintViolation<Serializable>> retorno = getViolations(entidade);
        
        if (retorno.isEmpty()) {
            return false;
        }
        
        for(ConstraintViolation<Serializable> constraintViolation : retorno) {
            createFacesErrorMessage(constraintViolation.getMessage());
        }
        
        return true;
    }
    
    public SimpleDateFormat getSfd() {
        return sfd;
    }
    
}
