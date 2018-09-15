/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Paulo Amosse
 */
//Uma especificacao dos mateirias.
public class CategoriaMaterial {

    private Material idMaterial;
    private String titulo;
    private String descricao;
    private boolean alugavel;

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
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
    
    
}
