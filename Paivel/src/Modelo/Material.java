/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Paulo Amosse
 */
@Entity
@Table(name = "MATERIAL")
public class Material implements Serializable {

    @Id
    @GeneratedValue
    private Integer materialID;
    private String codigoMaterial;
    private String nome;
    private int quantidade;
    private double precoDeAluguer;
    private String categoria;
    private boolean disponivel;
    private boolean alugavel;
    private boolean apagado;

    @ManyToOne
    private Salao salao;

    public Material() {
        this.setDisponivel(true);
    }

    public Integer getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Integer materialID) {
        this.materialID = materialID;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isAlugavel() {
        return alugavel;
    }

    public void setAlugavel(boolean alugavel) {
        this.alugavel = alugavel;
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }

    public double getPrecoDeAluguer() {
        return precoDeAluguer;
    }

    public void setPrecoDeAluguer(double precoDeAluguer) {
        this.precoDeAluguer = precoDeAluguer;
    }

    private void setApagado(boolean apagado) {
        this.apagado = apagado;
    }

    public boolean isApagado() {
        return apagado;
    }

    public void apagar() {
        this.setApagado(true);
    }

    public void recuperar() {
        this.setApagado(false);
    }

    public boolean disponibilizar() {
        if (this.getQuantidade() > 0) {
            this.setDisponivel(true);
            return true;
        }
        return false;
    }

    public boolean indisponibilizar() {
        if (this.getQuantidade() == 0) {
            this.setDisponivel(false);
            return true;
        }
        return false;
    }

    public boolean adicionar(int quantidade) {
        if (quantidade > 0) {
            this.setQuantidade(this.getQuantidade() + quantidade);
            return true;
        }
        return false;
    }

    public boolean retirar(int quantidade) {
        if ((this.getQuantidade() > 0) && (this.getQuantidade() - quantidade) >= 0) {
            this.setQuantidade(this.getQuantidade() - quantidade);
            if (this.getQuantidade() == 0) {
                indisponibilizar();
            }
            return true;
        }
        return false;
    }
}
