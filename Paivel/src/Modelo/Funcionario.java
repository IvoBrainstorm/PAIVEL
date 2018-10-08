/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
    private boolean demitido;

    @ManyToOne
    @JoinColumn(name = "id_categoriaFuncionario")
    private CategoriaFuncionario categoriaFuncionario;

    @ManyToMany
    private Collection<Evento> eventos = new ArrayList<>();

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

    public Collection<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Collection<Evento> eventos) {
        this.eventos = eventos;
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

    public boolean isDemitido() {
        return demitido;
    }

    public void setDemitido(boolean demitido) {
        this.demitido = demitido;
    }

    public boolean disponibilizarFuncionario() {
        if (this.isDisponivel()) {
            return false;
        } else {
            this.setDisponivel(true);
            return true;
        }
    }

    public boolean indisponibilizarFuncionario() {
        if (this.isDisponivel()) {
            this.setDisponivel(false);
            return true;
        }
        return false;
    }

    public boolean demitirFuncionario() {
        if (this.isDemitido()) {
            return false;
        } else {
            this.setDemitido(true);
            return true;
        }
    }

    /**
     * Este metodo provavelemte (99.9% de chances) vai dar erro. Porque o
     * funcionario no tipo de mapeamento que fiz nao precisa saber a que eventos
     * foi solicitado, mas o evento precisa saber que funcionarios usou.
     *
     * @return
     */
    public int eventosParticipados() {
        int i = 0;
        Iterator iterador = eventos.iterator();
        while (iterador.hasNext() ) {
            i++;
        }
        return i;
    }
}
