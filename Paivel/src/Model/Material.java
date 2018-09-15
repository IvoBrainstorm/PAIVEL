/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @see Funcionario
 * @author Paulo Amosse
 */
public class Material {

    /**
     * A situacao nao e' diferente do Funcionario, ou seja, um material possui
     * uma e unica categoria, mas uma categoria pode incluir varios materiais..
     * Ntendeu?
     */
    private String nome;
    private short quantidade;
    private String descricao;
    private CategoriaMaterial idCategoriaMaterial;
    private boolean disponivel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaMaterial getIdCategoriaMaterial() {
        return idCategoriaMaterial;
    }

    public void setIdCategoriaMaterial(CategoriaMaterial idCategoriaMaterial) {
        this.idCategoriaMaterial = idCategoriaMaterial;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
}
