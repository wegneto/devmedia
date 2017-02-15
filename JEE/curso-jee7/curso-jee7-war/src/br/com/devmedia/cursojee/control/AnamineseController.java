package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Anaminese;
import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.service.AnamineseService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AnamineseController extends BasicControl {

    @EJB
    private AnamineseService service;

    private Anaminese selected;

    private List<Anaminese> anamineses;
    
    private Cliente cliente;
    
    @Inject
    private OrcamentoController orcamentoController;

    public AnamineseService getService() {
        return service;
    }

    public void setService(AnamineseService service) {
        this.service = service;
    }

    public Anaminese getSelected() {
        return selected;
    }

    public void setSelected(Anaminese selected) {
        this.selected = selected;
    }

    public List<Anaminese> getAnamineses() {
        return anamineses;
    }

    public void setAnamineses(List<Anaminese> anamineses) {
        this.anamineses = anamineses;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void cleanCache() {
        setSelected(new Anaminese());
        getSelected().setCliente(getCliente());
        anamineses = service.getAnaminesesByCliente(getCliente());
    }
    
    public String add() {
        cleanCache();
        return "/restrito/addAnamnese.faces";
    }
    
    public String create() {
        selected.setCliente(cliente);
        service.addAnaminese(selected);
        cleanCache();
        return "/restrito/orcamento.faces";
    }

}
