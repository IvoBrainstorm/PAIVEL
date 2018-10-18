/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Paulo Amosse
 */
@Entity(name = "SALAO")
public class Salao implements Serializable {

    @Id
    @GeneratedValue
    private Integer salaoID;
    private String codigoSalao;
    private String nome;
    private String descricao;
    private int capacidade;
    private double preco; //Preco do salao por pessoa.
    private boolean disponivel;
    private boolean apagado;

    @OneToMany(mappedBy = "salao", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Material> materiais = new HashSet<>();

    @OneToMany(mappedBy = "salao", fetch = FetchType.EAGER)
    private Set<Evento> eventos = new HashSet<>();

    public Salao() {
        this.disponivel = true;
    }

    public Integer getSalaoID() {
        return salaoID;
    }

    public void setSalaoID(Integer salaoID) {
        this.salaoID = salaoID;
    }

    public String getCodigoSalao() {
        return codigoSalao;
    }

    public void setCodigoSalao(String codigoSalao) {
        this.codigoSalao = codigoSalao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Set<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(Set<Material> materiais) {
        this.materiais = materiais;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
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

    public boolean disponibilizar() {
        this.setDisponivel(true);
        return true;
    }

    public boolean indisponibilizar() {
        this.setDisponivel(false);
        return true;
    }

}
