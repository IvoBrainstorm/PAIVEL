/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Pra uma Casa de Eventos que possui mais de um salao, como e' o caso do Vila
 * Verde, Folha Verde e outros, devemos registar todos esses saloes e a sua
 * localizacao.
 *
 * @author Paulo Amosse
 */
@Entity(name = "salao")
public class Salao implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_salao;
    private String codigoSalao;
    private String nome;
    private String descricao;
    private double preco; //Preco do salao por pessoa.
    private boolean disponivel;

    @OneToMany
    //um salao esta para varios eventos
    private Collection<Evento> eventos = new ArrayList<>();

    @OneToMany
    //Um Salao esta para varios materiais
    private Collection<Material> material = new ArrayList<>();

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

    public Collection<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Collection<Evento> eventos) {
        this.eventos = eventos;
    }

    public Collection<Material> getMaterial() {
        return material;
    }

    public void setMaterial(Collection<Material> material) {
        this.material = material;
    }

    public Integer getId_salao() {
        return id_salao;
    }

    public void setId_salao(Integer id_salao) {
        this.id_salao = id_salao;
    }

    public String getCodigoSalao() {
        return codigoSalao;
    }

    public void setCodigoSalao(String codigoSalao) {
        this.codigoSalao = codigoSalao;
    }

    public boolean disponibilizarSalao() {
        if (this.isDisponivel()) {
            return false;
        }
        this.setDisponivel(true);
        return true;
    }

    public boolean indisponibilizarSalao() {
        if (this.isDisponivel()) {
            this.setDisponivel(false);
            return true;
        }
        return false;
    }

}
