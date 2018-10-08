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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @see Funcionario
 * @author Paulo Amosse
 */
@Entity(name = "material")
public class Material implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_material;
    private String codigoMaterial;
    private String nome;
    private int quantidade;
    private String descricao;
    private boolean disponivel;
    private boolean alugavel;

    //Um material esta para uma categoria
    //Uma categoria esta para varios materiais
    @ManyToOne
    @JoinColumn(name = "id_categoriaMaterial")
    private CategoriaMaterial material;

    @ManyToMany
    //Um material esta para varios eventos.
    private Collection<Evento> evento = new ArrayList<>();

    @ManyToMany
    //Um material pode ser alugado por varias entidades.
    private Collection<Alugar> alugueres = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_salao")
    private Salao salao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaMaterial getMaterial() {
        return material;
    }

    public void setMaterial(CategoriaMaterial material) {
        this.material = material;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Collection<Evento> getEvento() {
        return evento;
    }

    public void setEvento(Collection<Evento> evento) {
        this.evento = evento;
    }

    public Integer getId_material() {
        return id_material;
    }

    public void setId_material(Integer id_material) {
        this.id_material = id_material;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }

    public boolean isAlugavel() {
        return alugavel;
    }

    public void setAlugavel(boolean alugavel) {
        this.alugavel = alugavel;
    }

    public boolean alugar(int quantidade) {
        if (this.isAlugavel()) {
            if (this.getQuantidade() >= quantidade) {
                this.setQuantidade(this.getQuantidade() - quantidade);
                return true;
            }
        }
        return false;
    }

}
