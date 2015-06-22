package com.mutia.supermarket.entity;
// Generated Jun 7, 2015 11:15:13 PM by Hibernate Tools 3.6.0

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Produk generated by hbm2java
 */
@Entity
@Table(name = "produk")
public class Produk  implements java.io.Serializable {


     @Id
     private Integer id;
     private String nama;
     private int harga;

    public Produk() {
    }

    public Produk(String nama, int harga) {
       this.nama = nama;
       this.harga = harga;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getHarga() {
        return this.harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    @Override
    public int hashCode(){
        int hash = 3;
        hash = 23 * hash + this.id;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produk other = (Produk) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    



}

