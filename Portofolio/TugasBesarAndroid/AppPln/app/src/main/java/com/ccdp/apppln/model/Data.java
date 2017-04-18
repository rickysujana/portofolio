package com.ccdp.apppln.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Asus on 3/6/2017.
 */
public class Data implements Serializable {

    private int id;
    @SerializedName("id_pelanggan")
    private String idPelanggan;
    @SerializedName("nama")
    private String Nama;
    @SerializedName("tanggal")
    private String Tanggal;
    @SerializedName("jumlah")
    private String Jumlah;
    @SerializedName("userid")
    private int userid;

    public Data(){

    }

    public Data(int id, String idPelanggan, String nama, String tanggal, String jumlah, int userid) {
        this.id = id;
        this.idPelanggan = idPelanggan;
        Nama = nama;
        Tanggal = tanggal;
        Jumlah = jumlah;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (id != data.id) return false;
        if (userid != data.userid) return false;
        if (!idPelanggan.equals(data.idPelanggan)) return false;
        if (!Nama.equals(data.Nama)) return false;
        if (!Tanggal.equals(data.Tanggal)) return false;
        return Jumlah.equals(data.Jumlah);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPelanggan.hashCode();
        result = 31 * result + Nama.hashCode();
        result = 31 * result + Tanggal.hashCode();
        result = 31 * result + Jumlah.hashCode();
        result = 31 * result + userid;
        return result;
    }
}
