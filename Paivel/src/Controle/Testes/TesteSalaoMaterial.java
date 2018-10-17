/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Testes;

import Controle.Dao.MaterialDao;
import Modelo.Material;
import Modelo.Salao;
import Util.FabricaSessoes;

/**
 *
 * @author Paulo Amosse
 */
public class TesteSalaoMaterial {

    public static void main(String[] args) {
        Salao salao = new Salao();
        salao.setSalaoID(01);
//        salao.setCapacidade(2000);
//        salao.setPreco(1500);
//        salao.setNome("King Jar");
//        salao.setDescricao("Salao Tenda.");
//        salao.setCodigoSalao("Salao001");

        Material material = new Material();
//        material.setMaterialID(1);
        material.setCodigoMaterial("Mat001");
        material.setCategoria("Madeira");
        material.setNome("Cadeira Preta");
        material.setPrecoDeAluguer(120);
        material.setQuantidade(1200);
        material.setSalao(salao);
        
        if (MaterialDao.actualizar(material)) {
            System.out.println("Gravado");
            FabricaSessoes.getSessionFactory().close();
        }
    }
}
