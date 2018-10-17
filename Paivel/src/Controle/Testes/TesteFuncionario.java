/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Testes;

import Controle.Dao.FuncionarioDao;
import Modelo.Funcionario;
import Util.FabricaSessoes;

/**
 *
 * @author Paulo Amosse
 */
public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        func.setCodigoFuncionario("Func001");
        func.setNome("Helio Zandamela");
        
        if(FuncionarioDao.gravar(func)){
            System.out.println("Gravado");
            FabricaSessoes.getSessionFactory().close();
        }
    }
   
}
