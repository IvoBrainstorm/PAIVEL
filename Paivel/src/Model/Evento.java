/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paulo Amosse
 */
public class Evento {

    /**
     * Pergunta que nao quer calar, aahh por que voce colocou ArrayList nos
     * atributos?. 50 me disse que hibernate permite guardar uma collection
     * (vector ou arraylist) sem problemas.
     */
    private String titulo;
    private short nrPessoas;
    private Date dataDeRealizacao;
    private Date duracao; //a duracao do evento e' por default 19 horas (05 - 23 hrs).
    private Salao idSalao; //Escolha do salao.
    private double preco; //O preco sera igual a nrPessoas*precoDoSalao - algumDesconto + algumaTaxa 
    private Cliente idCliente; //A seleccao e gravacao do cliente e' feita na hora. 
    private ArrayList<Material> idMaterial; //Um mesmo evento usa varios materiais.
    private ArrayList<Funcionario> idFuncionario; //E ainda aloca varios funcionarios.
    private boolean activo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public short getNrPessoas() {
        return nrPessoas;
    }

    public void setNrPessoas(short nrPessoas) {
        this.nrPessoas = nrPessoas;
    }

    public Date getDataDeRealizacao() {
        return dataDeRealizacao;
    }

    public void setDataDeRealizacao(Date dataDeRealizacao) {
        this.dataDeRealizacao = dataDeRealizacao;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public Salao getIdSalao() {
        return idSalao;
    }

    public void setIdSalao(Salao idSalao) {
        this.idSalao = idSalao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Material> getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(ArrayList<Material> idMaterial) {
        this.idMaterial = idMaterial;
    }

    public ArrayList<Funcionario> getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(ArrayList<Funcionario> idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    /**
     * Vila Verde aceita um adiamento sem pagamento de taxa, mediante a
     * apresentacao de justificacao plausivel, mas se houver um segundo
     * adiamento, sera cobrada uma taxa de 30.000 MT para se adiar, mas os 30%
     * do valor do evento continuam la ate o termino do pagamento das parcelas.
     */
    public void adiar() {

    }
}
