/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 43189334587
 */
@Entity
@Table(name = "orcamento_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrcamentoServico.findAll", query = "SELECT o FROM OrcamentoServico o")})
public class OrcamentoServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal custo;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String observacoes;
    @JoinColumn(name = "id_servico", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Servicos idServico;
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Orcamento idOrcamento;

    public OrcamentoServico() {
    }

    public OrcamentoServico(Integer id) {
        this.id = id;
    }

    public OrcamentoServico(Integer id, BigDecimal custo) {
        this.id = id;
        this.custo = custo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Servicos getIdServico() {
        return idServico;
    }

    public void setIdServico(Servicos idServico) {
        this.idServico = idServico;
    }

    public Orcamento getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Orcamento idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrcamentoServico)) {
            return false;
        }
        OrcamentoServico other = (OrcamentoServico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.devmedia.cursojee.entities.OrcamentoServico[ id=" + id + " ]";
    }
    
}
