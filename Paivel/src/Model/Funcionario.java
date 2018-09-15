/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Paulo Amosse
 */
public class Funcionario {

    /**
     * #Importante#
     * Esta classe tem relacao one-to-one com a classe CategoriaFuncionario. A
     * ideia e', um funcionario so pode pertencer uma categoria, mas uma mesma
     * categoria pode ter varios funcionarios a seu favor.
     *
     * O acesso aos eventos que o Funcionario participou sera feito do mesmo
     * jeito que actualizamos um ficheiro. Primeiro buscamos o array, depois
     * actualizamos e no fim devolvemos ele a nossa Data-Base.
     */
    private String nome;
    private CategoriaFuncionario idCategoriaFuncionario;
    private ArrayList<Evento> idEvento; 
    private boolean disponivel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaFuncionario getIdCategoriaFuncionario() {
        return idCategoriaFuncionario;
    }

    public void setIdCategoriaFuncionario(CategoriaFuncionario idCategoriaFuncionario) {
        this.idCategoriaFuncionario = idCategoriaFuncionario;
    }

    public ArrayList<Evento> getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(ArrayList<Evento> idEvento) {
        this.idEvento = idEvento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    
}
