/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Dao;

import Modelo.Material;
import Util.FabricaSessoes;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paulo Amosse
 */
public class MaterialDao {
     public static boolean gravar(Material material) {
        Session s = FabricaSessoes.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        try {
            s.save(material);
            t.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro: \n\t"+ex);
            return false;
        } finally {
            s.close();
        }
    }
    public static boolean actualizar(Material material) {
        Session s = FabricaSessoes.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        try {
            s.merge(material);
            t.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro: \n\t"+ex);
            return false;
        } finally {
            s.close();
        }
    }
    public static ArrayList<Material> ler() {
        Session s = FabricaSessoes.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Criteria cr = s.createCriteria(Material.class);
        ArrayList<Material> material = (ArrayList<Material>) cr.list();
        
        try {
            return material;
        } catch (Exception ex) {
            System.out.println("Erro: \n\t"+ex);
            return null;
        } finally {
            s.close();
        }
    }
}
