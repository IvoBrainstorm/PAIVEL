/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Paulo Amosse
 */
@Entity(name = "ALUGUER")
public class Aluguer implements Serializable {

    @Id
    @GeneratedValue
    private Integer aluguerID;
    private double valorDoPrejuizo;
    private boolean apagado;

    @Temporal(TemporalType.DATE)
    private Date data;

    @OneToOne
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "Aluguer_Material", joinColumns = @JoinColumn(name = "aluguerID"),
            inverseJoinColumns = @JoinColumn(name = "materialID"))
    private Set<Material> materiais = new HashSet<>();

    public Aluguer() {
    }

    public Integer getAluguerID() {
        return aluguerID;
    }

    public void setAluguerID(Integer aluguerID) {
        this.aluguerID = aluguerID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(Set<Material> materiais) {
        this.materiais = materiais;
    }

    public double getValorDoPrejuizo() {
        return valorDoPrejuizo;
    }

    public void setValorDoPrejuizo(double valorDoPrejuizo) {
        this.valorDoPrejuizo = valorDoPrejuizo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isApagado() {
        return apagado;
    }

    private void setApagado(boolean apagado) {
        this.apagado = apagado;
    }

    public void apagar() {
        this.setApagado(true);
    }

    public void recuperar() {
        this.setApagado(false);
    }
}
