package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.OrcamentoServico;
import br.com.devmedia.cursojee.service.OrcamentoService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class OrcamentoController extends BasicControl {
    
    @EJB
    private OrcamentoService service;
    
    @Inject
    private AnamineseController anamineseController;
    
    private Orcamento selected;
    
    private List<Orcamento> orcamentos;
    
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public OrcamentoService getService() {
        return service;
    }

    public void setService(OrcamentoService service) {
        this.service = service;
    }

    public Orcamento getSelected() {
        return selected;
    }

    public void setSelected(Orcamento selected) {
        this.selected = selected;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
    
    public String atenderCliente(Cliente cliente) {
       setCliente(cliente);
       anamineseController.setCliente(cliente);
       anamineseController.cleanCache();
       cleanCache();
       
       return "/restrito/orcamento.faces";
    }
   
    public String getOrcamentoItens(Orcamento orcamento) {
        StringBuilder sb = new StringBuilder();
        for (OrcamentoServico item : orcamento.getOrcamentoServicoList()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(item.getServico().getNome());
        }
        
        return sb.toString();
    }
    

    private void cleanCache() {
        setSelected(new Orcamento());
        getSelected().setCliente(getCliente());
        setOrcamentos(service.getOrcamentos(getCliente().getId()));
    }
    
}
