/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 43189334587
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o")})
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String observacoes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "forma_pagamento", nullable = false, length = 9)
    private String formaPagamento;
    private Integer vezes;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "id_dentista", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idDentista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private List<OrcamentoServico> orcamentoServicoList = new LinkedList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private List<Parcela> parcelaList = new LinkedList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrcamento")
    private List<Anaminese> anamineseList = new LinkedList<>();

    public Orcamento() {
    }

    public Orcamento(Integer id) {
        this.id = id;
    }

    public Orcamento(Integer id, Date data, Date hora, BigDecimal total, String formaPagamento) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.total = total;
        this.formaPagamento = formaPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getVezes() {
        return vezes;
    }

    public void setVezes(Integer vezes) {
        this.vezes = vezes;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.cliente = idCliente;
    }

    public Usuario getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Usuario idDentista) {
        this.idDentista = idDentista;
    }

    @XmlTransient
    public List<OrcamentoServico> getOrcamentoServicoList() {
        return orcamentoServicoList;
    }

    public void setOrcamentoServicoList(List<OrcamentoServico> orcamentoServicoList) {
        this.orcamentoServicoList = orcamentoServicoList;
    }

    @XmlTransient
    public List<Parcela> getParcelaList() {
        return parcelaList;
    }

    public void setParcelaList(List<Parcela> parcelaList) {
        this.parcelaList = parcelaList;
    }

    @XmlTransient
    public List<Anaminese> getAnamineseList() {
        return anamineseList;
    }

    public void setAnamineseList(List<Anaminese> anamineseList) {
        this.anamineseList = anamineseList;
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
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.devmedia.cursojee.entities.Orcamento[ id=" + id + " ]";
    }

    public void addServico(OrcamentoServico orcamentoServico) {
        orcamentoServico.setOrcamento(this);
        orcamentoServicoList.add(orcamentoServico);
    }

}
