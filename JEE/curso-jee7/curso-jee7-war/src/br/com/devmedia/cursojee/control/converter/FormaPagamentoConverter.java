package br.com.devmedia.cursojee.control.converter;

import br.com.devmedia.cursojee.entities.FormaPagamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = FormaPagamento.class, value = "formaPagamentoConverter")
public class FormaPagamentoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            for (FormaPagamento object : FormaPagamento.values()) {
                if (object.getDescricao().equals(value)) {
                    return object;
                }
            }
            throw new IllegalArgumentException("Erro de conversão do tipo de pagamento");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else {
            return ((FormaPagamento) value).getDescricao();
        }
    }

    private Exception IllegalArgumentException(String erro_de_conversão_do_tipo_de_pagamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
