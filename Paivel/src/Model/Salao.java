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
/**
 * Pra uma Casa de Eventos que possui mais de um salao, como e' o caso do Vila
 * Verde, Folha Verde e outros, devemos registar todos esses saloes e a sua
 * localizacao.
 *
 * @author Paulo Amosse
 */
public class Salao {

    private String nome;
    private String descricao;
    private double preco; //Preco do salao por pessoa.
    private String endereco; //Pra caso dos saloes estiverem no mesmo espaco, este atributo e opcional

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
