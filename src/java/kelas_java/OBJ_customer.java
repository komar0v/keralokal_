/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas_java;

import java.sql.Blob;

/**
 *
 * @author ASUS
 */
public class OBJ_customer {
    private String id_customer, nama_depan_customer, nama_belakang_customer, nik_customer, alamat_customer, email_customer, password_customer, nohp_customer;

    public String getNohp_customer() {
        return nohp_customer;
    }

    public void setNohp_customer(String nohp_customer) {
        this.nohp_customer = nohp_customer;
    }
    private Blob fotoKtp_customer, foto_profil_customer;

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama_depan_customer() {
        return nama_depan_customer;
    }

    public void setNama_depan_customer(String nama_depan_customer) {
        this.nama_depan_customer = nama_depan_customer;
    }

    public String getNama_belakang_customer() {
        return nama_belakang_customer;
    }

    public void setNama_belakang_customer(String nama_belakang_customer) {
        this.nama_belakang_customer = nama_belakang_customer;
    }

    public String getNik_customer() {
        return nik_customer;
    }

    public void setNik_customer(String nik_customer) {
        this.nik_customer = nik_customer;
    }

    public String getAlamat_customer() {
        return alamat_customer;
    }

    public void setAlamat_customer(String alamat_customer) {
        this.alamat_customer = alamat_customer;
    }

    public String getEmail_customer() {
        return email_customer;
    }

    public void setEmail_customer(String email_customer) {
        this.email_customer = email_customer;
    }

    public String getPassword_customer() {
        return password_customer;
    }

    public void setPassword_customer(String password_customer) {
        this.password_customer = password_customer;
    }

    public Blob getFotoKtp_customer() {
        return fotoKtp_customer;
    }

    public void setFotoKtp_customer(Blob fotoKtp_customer) {
        this.fotoKtp_customer = fotoKtp_customer;
    }

    public Blob getFoto_profil_customer() {
        return foto_profil_customer;
    }

    public void setFoto_profil_customer(Blob foto_profil_customer) {
        this.foto_profil_customer = foto_profil_customer;
    }
    
    
}
