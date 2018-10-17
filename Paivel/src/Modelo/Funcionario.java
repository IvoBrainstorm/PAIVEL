/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Paulo Amosse
 */
@Entity(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private Integer funcionarioID;
    private String codigoFuncionario;
    private String nome;
    private boolean disponivel;
    private boolean demitido;
    private boolean apagado;

    @ManyToMany(mappedBy = "funcionarios", fetch = FetchType.EAGER)
    private Set<Evento> eventos = new HashSet<>();

    public Funcionario() {
        this.disponivel = true;
    }

    public Integer getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Integer funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    private void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDemitido() {
        return demitido;
    }

    public void setDemitido(boolean demitido) {
        this.demitido = demitido;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
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
    
    public void recuperar(){
        this.setApagado(false);
    }

    public void demitirFuncionario() {
        if (!this.isDemitido()) {
            this.setDemitido(true);
            indisponibilizar();
        }
    }

    public void revogarDemissao() {
        if (this.isDemitido()) {
            this.setDemitido(false);
            disponibilizar();
        }
    }

    public void disponibilizar() {
        if (!this.isDemitido()) {
            this.setDisponivel(true);
        }
    }

    public void indisponibilizar() {
        if (!this.isDemitido()) {
            this.setDisponivel(false);
        }
    }

    public int eventosPartcipados() {
        int i = 0;
        for (Evento e : this.getEventos()) {
            i++;
        }
        return i;
    }
}
