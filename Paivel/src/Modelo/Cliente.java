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
import javax.persistence.OneToOne;

/**
 * Unidade elementar do negocio (without clients, we dont have a business).
 *
 * @author Paulo Amosse
 */
@Entity(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_cliente;
    private String nome;
    private String contato1;//Contato do cliente
    private String contato2;//Segundo contacto, este e' opcional
    private String email; //Contato de outra pessoa que pode ser contactada em caso de problema
    private double taxa; //Taxa para Clientes Empresariais e Individuais

    @OneToOne(mappedBy = "evento")
    private Evento evento;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

}
