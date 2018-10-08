/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Paulo Amosse
 */
@Entity(name = "alugar")
public class Alugar implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_alugar;
    private String nomeCliente;
    private String descricaoDoServico;

    @ManyToMany
    @JoinTable(name = "Alugar_Material", joinColumns = @JoinColumn(name = "id_alugar"),
            inverseJoinColumns = @JoinColumn(name = "id_material"))
    //Varios materiais podem ser alugados de uma so vez
    private Collection<Material> materiais = new ArrayList<>();

}
