/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.entities.validator;

import br.com.devmedia.cursojee.entities.Servico;
import br.com.devmedia.cursojee.service.ServicoService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author wegneto
 */
public class DescricaoServicoUnicaValidator implements ConstraintValidator<DescricaoServicoUnica, Servico> {

    private final ServicoService servicoService = lookupServicoServiceBean();

    @Override
    public void initialize(DescricaoServicoUnica constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(Servico value, ConstraintValidatorContext context) {
        return false;
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
