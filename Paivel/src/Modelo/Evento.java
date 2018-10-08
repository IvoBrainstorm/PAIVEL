/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javafx.scene.paint.Material;
import javax.persistence.Entity;
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
@Entity(name = "evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_evento;
    private String codigoEvento;
    private String titulo;
    private Integer nrPessoas;

    @Temporal(TemporalType.DATE)
    private Date dataDeRealizacao;
    @Temporal(TemporalType.TIME)
    private Date duracao; //a duracao do evento e' por default 19 horas (05 - 23 hrs).
    private double preco; //O preco sera igual a nrPessoas*precoDoSalao - algumDesconto + algumaTaxa 
    private double valorDasParcelas;
    private double taxaAdiamento;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_salao")
    private Salao salao; //Escolha do salao.

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente; //A seleccao e gravacao do cliente e' feita na hora.

    @ManyToMany
    @JoinTable(name = "Evento_Material", joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_material"))
    //Um mesmo evento usa varios materiais e um material pode ser usado em varios eventos.
    private Collection<Material> materiais = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Evento_Funcionario", joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_funcionario"))
    //E ainda aloca varios funcionarios.
    private Collection<Funcionario> funcionarios = new ArrayList<>();

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

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Collection<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(Collection<Material> materiais) {
        this.materiais = materiais;
    }

    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public double getTaxaAdiamento() {
        return taxaAdiamento;
    }

    public void setTaxaAdiamento(double taxaAdiamento) {
        this.taxaAdiamento = taxaAdiamento;
    }

    public double getValorDasParcelas() {
        return valorDasParcelas;
    }

    public void setValorDasParcelas(double valorDasParcelas) {
        this.valorDasParcelas = valorDasParcelas;
    }

    /**
     * Vila Verde aceita um adiamento sem pagamento de taxa, mediante a
     * apresentacao de justificacao plausivel, mas se houver um segundo
     * adiamento, sera cobrada uma taxa de 30.000 MT para se adiar, mas os 30%
     * do valor do evento continuam la ate o termino do pagamento das parcelas.
     *
     * @param novaData
     * @param valor
     */
    public void adiar(Date novaData, double valor) {
        this.taxaAdiamento = valor;
        this.setDataDeRealizacao(novaData);
    }

    public boolean desactivar() {
        if (this.isActivo()) {
            this.setActivo(false);
            return true;
        }
        return false;
    }

    public boolean pagarParcela(double valor) {
        if (valor >= 0) {
            if (this.getValorDasParcelas() < this.getPreco()) {
                if ((this.getValorDasParcelas() + valor) <= this.getPreco()) {
                    this.setValorDasParcelas(valor+this.getValorDasParcelas());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean activar() {
        if (this.isActivo()) {
            return false;
        }
        this.setActivo(true);
        return false;
    }

}
