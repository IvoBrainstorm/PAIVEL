/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Paulo Amosse
 */
@Entity(name = "EVENTO")
public class Evento implements Serializable {

    @Id
    @GeneratedValue
    private Integer eventoID;
    private String codigoEvento;
    private String titulo;
    private Integer nrPessoas;

    @Temporal(TemporalType.DATE)
    private Date dataDeRealizacao;
    private int duracao; //a duracao do evento e' por default 19 horas (05 - 23 hrs).
    private double preco; //O preco sera igual a nrPessoas*precoDoSalao - algumDesconto + algumaTaxa 
    private double taxaAdiamento;
    private boolean activo;
    private boolean apagado;

    @ManyToOne
    private Salao salao;

    @OneToOne
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Ev_Mat", joinColumns = @JoinColumn(name = "codigoEvento"),
            inverseJoinColumns = @JoinColumn(name = "codigoMaterial"))
    private Set<Material> materiais = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Ev_Func", joinColumns = @JoinColumn(name = "codigoEvento"),
            inverseJoinColumns = @JoinColumn(name = "codigoFuncionario"))
    private Set<Funcionario> funcionarios = new HashSet<>();

    public Evento() {
        this.activo = true;
        this.setDuracao(23);
    }

    public Integer getEventoID() {
        return eventoID;
    }

    public void setEventoID(Integer eventoID) {
        this.eventoID = eventoID;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNrPessoas() {
        return nrPessoas;
    }

    public void setNrPessoas(Integer nrPessoas) {

        if (nrPessoas > this.getSalao().getCapacidade()) {
            throw new Error("O nr de pessoas deve ser menor que a capacidade do salao.");
        } else {
            this.nrPessoas = nrPessoas;
        }

    }

    public Date getDataDeRealizacao() {
        return dataDeRealizacao;
    }

    public void setDataDeRealizacao(Date dataDeRealizacao) {
        this.dataDeRealizacao = dataDeRealizacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTaxaAdiamento() {
        return taxaAdiamento;
    }

    public void setTaxaAdiamento(double taxaAdiamento) {
        this.taxaAdiamento = taxaAdiamento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(Set<Material> materiais) {
        this.materiais = materiais;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }

    public boolean isApagado() {
        return apagado;
    }

    private void setApagado(boolean apagado) {
        this.apagado = apagado;
    }

    public void apagar() {
        this.setApagado(true);
    }

    public void recuperar() {
        this.setApagado(false);
    }

    public boolean adiarPara(Date novaData) {
        if (this.isActivo()) {
            this.setDataDeRealizacao(novaData);
            return true;
        }
        return false;
    }

    public void activar() {
        if (!this.isActivo()) {
            this.setActivo(true);
        }
    }

    public void desactivar() {
        if (this.isActivo()) {
            this.setActivo(false);
        }
    }

    public void definirPreco() {
        double valor = this.getSalao().getPreco() * this.getNrPessoas() + this.cliente.getTaxa();
        this.setPreco(valor);
    }

    public boolean pagarParcela(double valor) {

        double dinheiro = 0;

        for (Parcela parcela : this.getCliente().getParcelas()) {
            dinheiro = dinheiro + parcela.getValor();
        }

        if ((dinheiro == 0) && (dinheiro + valor) >= 0.3 * this.getPreco()) {
            activar();
            if ((dinheiro + valor) <= this.getPreco()) {
                Parcela p = new Parcela();
                p.setValor(valor);
                p.setCliente(this.cliente);

                this.getCliente().getParcelas().add(p);
                return true;
            }

        }

        return false;
    }

}
