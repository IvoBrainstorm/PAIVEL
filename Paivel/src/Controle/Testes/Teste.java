/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Testes;

import Controle.Dao.ClienteDao;
import Modelo.Cliente;
import Util.FabricaSessoes;

/**
 *
 * @author Paulo Amosse
 */
public class Teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setContato1("82 345 6890");
        cliente.setContato2("84 202 2036");
        cliente.setEmail("lucasamosse@yahoo.com.br");
        cliente.setNome("Lucas Amosse");
        cliente.setTaxa(3000);
        
        if(ClienteDao.gravar(cliente)){
            System.out.println("Gravado");
            FabricaSessoes.getSessionFactory().close();
        }
    }
}
