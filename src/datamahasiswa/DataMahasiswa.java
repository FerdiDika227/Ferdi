/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class DataMahasiswa {

    @Id
    private String npm;
    private String nama;
    private int tinggi;
    private boolean pindah;

    public DataMahasiswa() {
    }

    public DataMahasiswa(String npm, String nama, int tinggi, boolean pindah) {
        this.npm = npm;
        this.nama = nama;
        this.tinggi = tinggi;
        this.pindah = pindah;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public boolean isPindah() {
        return pindah;
    }

    public void setPindah(boolean pindah) {
        this.pindah = pindah;
    }
}

