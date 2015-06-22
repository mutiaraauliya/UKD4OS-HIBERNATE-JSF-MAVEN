/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mutia.supermarket.controler;

/**
 *
 * @author tonyhendra
 */
;
import javax.faces.bean.ManagedBean;
import javax. faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.mutia.supermarket.entity.Produk;
import com.mutia.supermarket.dao.ProdukDAO;

@ManagedBean
@SessionScoped
public class produkControler {
    Produk produk;
    List<Produk> produkList;
 private ProdukDAO dataAccess;
 private String searchBy;
 private String searchValue;
 
 public produkControler() {
 produkList = new ArrayList<Produk>();
 produk = new Produk();
 dataAccess = new ProdukDAO();
 produkList = dataAccess.getAll();
 }
 public String displayAll(){
  produkList = dataAccess.getAll();
 return "List";
 }
 public String searchProduk(){
 produkList = dataAccess.getByProperty(this.searchBy,this.searchValue);
 return "List";
 }
 public String addProduk(){
 dataAccess.insert(produk);
 FacesMessage message = new FacesMessage("Data berhasil ditambahkan");
 message.setSeverity((FacesMessage.SEVERITY_INFO));
 FacesContext.getCurrentInstance().addMessage(null, message);
 produkList = dataAccess.getAll();
 return "List";
 }
 public String updateProduk(){
 dataAccess.update(produk);
 FacesMessage message = new FacesMessage("Data berhasil diubah");
 message. setSeverity((FacesMessage.SEVERITY_INFO));
 FacesContext.getCurrentInstance().addMessage(null, message);
 produkList = dataAccess.getAll();
 return "List";
 }
 public String deleteProduk(){
 dataAccess.delete(produk);
 FacesMessage message = new FacesMessage("Data berhasil dihapus");
 message.setSeverity((FacesMessage.SEVERITY_INFO));
 FacesContext.getCurrentInstance().addMessage(null, message);
 produkList = dataAccess.getAll();
 return "List";
 }
 public Produk getProduk() {
 return produk;
 }
 public void setProduk(Produk produk) {
 this.produk = produk;
 }
 public List<Produk> getProdukList() {
 return produkList;
 }
 public void setProdukList(List<Produk> produkList) {
 this.produkList = produkList;
 }
 public ProdukDAO getDataAccess() {
 return dataAccess;
 }
 public void setDataAccess(ProdukDAO dataAccess) {
 this.dataAccess = dataAccess;
 }
 public String getSearchBy() {
 return searchBy;
 }
 public void setSearchBy(String searchBy) {
 this.searchBy = searchBy;
 }
 public String getSearchValue() {
 return searchValue;
 }
 public void setSearchValue(String searchValue) {
 this.searchValue = searchValue;
 }
    
}
