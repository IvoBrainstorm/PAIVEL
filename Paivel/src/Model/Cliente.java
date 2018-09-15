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
 * Unidade elementar do negocio (without clients, we dont have a business).
 *
 * @author Paulo Amosse
 */
public class Cliente {

    private String nome;
    private String contato1;//Contato do cliente
    private String contato2;//Segundo contacto, este e' opcional
    private String outroContato; //Contato de outra pessoa que pode ser contactada em caso de problema
    private double taxa; //Taxa para Clientes Empresariais e Individuais

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getOutroContato() {
        return outroContato;
    }

    public void setOutroContato(String outroContato) {
        this.outroContato = outroContato;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
    

}
