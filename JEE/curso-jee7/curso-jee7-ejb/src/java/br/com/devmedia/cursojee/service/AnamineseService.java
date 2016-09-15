package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Anaminese;
import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.service.repositories.AnamineseRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AnamineseService extends BasicService{

    @PersistenceContext
    private EntityManager em;
    
    private AnamineseRepository repository;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        repository = new AnamineseRepository(em);
    }

    public Anaminese addAnaminese(Anaminese anaminese) {
        return repository.addAnaminese(anaminese);
    }

    public Anaminese setAnaminese(Anaminese anaminese) {
        return repository.setAnaminese(anaminese);
    }

    public void removeAnaminese(Anaminese anaminese) {
        repository.removeAnaminese(anaminese);
    }

    public Anaminese getAnaminese(int id) {
        return repository.getAnaminese(id);
    }
    
    public List<Anaminese> getAnaminesesByCliente(Cliente cliente) {
        return repository.getAnaminesesByCliente(cliente);
    }
    
    public List<Anaminese> getAnaminesesByOrcamento(Orcamento orcamento) {
        return repository.getAnaminesesByOrcamento(orcamento);
    }
}
