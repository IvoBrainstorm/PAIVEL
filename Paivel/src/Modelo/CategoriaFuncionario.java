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
import javax.persistence.OneToMany;

/**
 *
 * @author Paulo Amosse
 */
//Categoria do funcionario e' a area de actuacao do Funcionario.
@Entity(name = "CategoriaFuncionario")
public class CategoriaFuncionario implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_categoriaFuncionario;
    private String titulo;
    private String descricao;

    @OneToMany()
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    public Integer getId_categoriaFuncionario() {
        return id_categoriaFuncionario;
    }

    public void setId_categoriaFuncionario(Integer id_categoriaFuncionario) {
        this.id_categoriaFuncionario = id_categoriaFuncionario;
    }

}
