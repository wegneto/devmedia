/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 43189334587
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anaminese.findAll", query = "SELECT a FROM Anaminese a")})
public class Anaminese implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean fuma;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean exercicio;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean doenca;
    @Size(max = 255)
    @Column(name = "doenca_descricao", length = 255)
    private String doencaDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean cirurgia;
    @Size(max = 255)
    @Column(name = "cirurgia_descricao", length = 255)
    private String cirurgiaDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean medicacao;
    @Size(max = 255)
    @Column(name = "medicacao_descricao", length = 255)
    private String medicacaoDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean alergia;
    @Size(max = 255)
    @Column(name = "alergia_descricao", length = 255)
    private String alergiaDescricao;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String observacoes;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Orcamento idOrcamento;

    public Anaminese() {
    }

    public Anaminese(Integer id) {
        this.id = id;
    }

    public Anaminese(Integer id, boolean fuma, boolean exercicio, boolean doenca, boolean cirurgia, boolean medicacao, boolean alergia) {
        this.id = id;
        this.fuma = fuma;
        this.exercicio = exercicio;
        this.doenca = doenca;
        this.cirurgia = cirurgia;
        this.medicacao = medicacao;
        this.alergia = alergia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean getExercicio() {
        return exercicio;
    }

    public void setExercicio(boolean exercicio) {
        this.exercicio = exercicio;
    }

    public boolean getDoenca() {
        return doenca;
    }

    public void setDoenca(boolean doenca) {
        this.doenca = doenca;
    }

    public String getDoencaDescricao() {
        return doencaDescricao;
    }

    public void setDoencaDescricao(String doencaDescricao) {
        this.doencaDescricao = doencaDescricao;
    }

    public boolean getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(boolean cirurgia) {
        this.cirurgia = cirurgia;
    }

    public String getCirurgiaDescricao() {
        return cirurgiaDescricao;
    }

    public void setCirurgiaDescricao(String cirurgiaDescricao) {
        this.cirurgiaDescricao = cirurgiaDescricao;
    }

    public boolean getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(boolean medicacao) {
        this.medicacao = medicacao;
    }

    public String getMedicacaoDescricao() {
        return medicacaoDescricao;
    }

    public void setMedicacaoDescricao(String medicacaoDescricao) {
        this.medicacaoDescricao = medicacaoDescricao;
    }

    public boolean getAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public String getAlergiaDescricao() {
        return alergiaDescricao;
    }

    public void setAlergiaDescricao(String alergiaDescricao) {
        this.alergiaDescricao = alergiaDescricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        if (!(object instanceof Anaminese)) {
            return false;
        }
        Anaminese other = (Anaminese) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.devmedia.cursojee.entities.Anaminese[ id=" + id + " ]";
    }

}
