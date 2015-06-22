/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mutia.supermarket.dao;

import java.util.List;
import com.mutia.supermarket.entity.Produk;
import com.mutia.supermarket.util.NewHibernateUtil;
import com.mutia.supermarket.dao.EntityBase;
import com.mutia.supermarket.dao.IDataAccess;
import org.hibernate.Query;
/**
 *
 * @author tonyhendra
 */
public class ProdukDAO extends EntityBase implements IDataAccess<Produk>{
     public ProdukDAO(){        
    }   

    @Override
    public void insert(Produk obj) {
        connect();
        session.save(obj);
        session.flush();
        disconect();
    }

    @Override
    public void update(Produk obj) {
        connect();
        session.update(obj);
        session.flush();
        disconect();
    }

    @Override
    public void delete(Produk obj) {
        connect();
        session.delete(obj);
        session.flush();
        disconect();
    }

    @Override
    public List getAll() {
        connect();
        List<Produk> produkList = session.createQuery("from Produk").list();
        disconect();
        return produkList;
    }

    @Override
    public Produk getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produk getById(String id) {
        connect();
        List<Produk> produkList = getByProperty("id", id);
        disconect();
        if(produkList != null && produkList.size()>0){
        return produkList.get(0);
        }
        return null;
    }

    @Override
    public List<Produk> getByProperty(String name, Object value) {
        connect();
        Query query = session.createQuery("from Produk where " + name + " =:value");
        query.setParameter("value", value);
        List<Produk> produkList = query.list();
        disconect();
        return produkList;
 }

    @Override
    public List<Produk> search(String name, Object value) {
        connect();
        Query query = session.createSQLQuery("select * from Produk where " + name+ " like '%" + value + "%'");
        List<Produk> produkList = query.list();
        disconect();
        return produkList;
    }

    
    
}
