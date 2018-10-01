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
 *
 * @author Paulo Amosse
 */
//Uma especificacao dos materias.
@Entity (name = "CategoriaMaterial")
public class CategoriaMaterial implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_categoriaMaterial;
    private String titulo;
    private String descricao;
    private boolean alugavel;
    
    @OneToMany
    //Uma categoria esta relacionada a diversos materiais.
    private Collection<Material> material = new ArrayList<>();

    public Collection<Material> getMaterial() {
        return material;
    }

    public void setMaterial(Collection<Material> material) {
        this.material = material;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAlugavel() {
        return alugavel;
    }

    public void setAlugavel(boolean alugavel) {
        this.alugavel = alugavel;
    }

    public Integer getId_categoriaMaterial() {
        return id_categoriaMaterial;
    }

    public void setId_categoriaMaterial(Integer id_categoriaMaterial) {
        this.id_categoriaMaterial = id_categoriaMaterial;
    }
    
    
}
