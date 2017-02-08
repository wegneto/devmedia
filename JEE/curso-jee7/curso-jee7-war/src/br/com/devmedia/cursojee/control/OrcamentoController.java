package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.service.OrcamentoService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class OrcamentoController extends BasicControl {
    
    @EJB
    private OrcamentoService service;
    
    private Orcamento selected;
    
    private List<Orcamento> orcamentos;
    
}
