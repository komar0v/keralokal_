/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas_java;

/**
 *
 * @author ASUS
 */
public class OBJ_produk extends OBJ_toko{
    private String id_produk, nama_produk, jenis_produk, keterangan_produk;
    private int stock_produk;
    private double harga_produk;

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getJenis_produk() {
        return jenis_produk;
    }

    public void setJenis_produk(String jenis_produk) {
        this.jenis_produk = jenis_produk;
    }

    public String getKeterangan_produk() {
        return keterangan_produk;
    }

    public void setKeterangan_produk(String keterangan_produk) {
        this.keterangan_produk = keterangan_produk;
    }

    public int getStock_produk() {
        return stock_produk;
    }

    public void setStock_produk(int stock_produk) {
        this.stock_produk = stock_produk;
    }

    public double getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(double harga_produk) {
        this.harga_produk = harga_produk;
    }
    
    
}
