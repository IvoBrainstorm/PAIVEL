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
 *
 * @author Paulo Amosse
 */
@Entity(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_funcionario;
    private String codigoFuncionario;
    private String nome;
    private boolean disponivel;
    
    @ManyToOne
    @JoinColumn(name = "id_categoriaFuncionario")
    private CategoriaFuncionario categoriaFuncionario;
    
    @ManyToMany
    private Collection<Evento> evento = new ArrayList<>(); 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaFuncionario getCategoriaFuncionario() {
        return categoriaFuncionario;
    }

    public void setCategoriaFuncionario(CategoriaFuncionario categoriaFuncionario) {
        this.categoriaFuncionario = categoriaFuncionario;
    }

    public Collection<Evento> getEvento() {
        return evento;
    }

    public void setEvento(Collection<Evento> evento) {
        this.evento = evento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    
    
}
