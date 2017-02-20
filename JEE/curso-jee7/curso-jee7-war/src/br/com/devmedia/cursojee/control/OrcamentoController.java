package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Anaminese;
import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.FormaPagamento;
import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.OrcamentoServico;
import br.com.devmedia.cursojee.entities.Servico;
import br.com.devmedia.cursojee.entities.Usuario;
import br.com.devmedia.cursojee.service.OrcamentoService;
import br.com.devmedia.cursojee.service.ServicoService;
import br.com.devmedia.cursojee.service.UsuarioService;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class OrcamentoController extends BasicControl {

    @EJB
    private OrcamentoService service;

    @EJB
    private UsuarioService usuarioService;

    @Inject
    private AnamineseController anamineseController;

    private Orcamento selected;

    private List<Orcamento> orcamentos;

    private Cliente cliente;

    private OrcamentoServico orcamentoServico;

    @EJB
    private ServicoService servicoService;

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

    public String criarOrcamento(Anaminese anaminese) {
        cleanCache();
        getSelected().setAnaminese(anaminese);
        anaminese.setOrcamento(getSelected());
        return "/restrito/addOrcamento.faces";
    }

    public List<Usuario> getDentistas() {
        return usuarioService.getDentistas();
    }

    public FormaPagamento[] getFormasPagamento() {
        return FormaPagamento.values();
    }

    public OrcamentoServico getOrcamentoServico() {
        return orcamentoServico;
    }

    public void setOrcamentoServico(OrcamentoServico orcamentoServico) {
        this.orcamentoServico = orcamentoServico;
    }

    public List<Servico> getServicos() {
        return servicoService.getServicos();
    }

    public String addItem() {
        orcamentoServico = new OrcamentoServico();
        orcamentoServico.setOrcamento(selected);
        return "/restrito/addOrcamentoItem.faces";
    }

    public String createOrcamentoServico() {
        orcamentoServico.setCusto(orcamentoServico.getTotalItemParcial());
        selected.getOrcamentoServicoList().add(orcamentoServico);
        BigDecimal total = BigDecimal.ZERO;
        for (OrcamentoServico os : selected.getOrcamentoServicoList()) {
            total = total.add(os.getCusto());
        }
        selected.setTotal(total);
        return "/restrito/addOrcamento.faces";
    }

    public String updateOrcamentoServico() {
        if (orcamentoServico.getId() != null) {
            service.setOrcamentoServico(orcamentoServico);
        }
        orcamentoServico.setCusto(orcamentoServico.getTotalItemParcial());
        recalcular();
        return "/restrito/addOrcamento.faces";
    }

    private void recalcular() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrcamentoServico os : selected.getOrcamentoServicoList()) {
            total = total.add(os.getCusto());
        }
        selected.setTotal(total);
    }

    public String removeOrcamentoServico() {
        selected.getOrcamentoServicoList().remove(orcamentoServico);
        recalcular();
        return "/restrito/addOrcamento.faces";
    }

    public String editOrcamentoServico() {
        return "/restrito/editOrcamentoItem.faces";
    }

    public String create() {
        if (!selected.getFormaPagamento().equals(FormaPagamento.CREDITO)) {
            selected.setVezes(1);
        } else if (selected.getVezes() == null || selected.getVezes() <= 0) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Número de parcelas é obrigatório.", "Número de parcelas é obrigatório.");
            FacesContext.getCurrentInstance().addMessage("parcelas", fm);
            return "/restrito/addOrcamento.faces";
        }
        
        selected.setCliente(cliente);
        service.addOrcamento(selected);

        return "/restrito/orcamento.faces";
    }

}
