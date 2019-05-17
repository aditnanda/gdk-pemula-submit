package com.nand_project.praktikumdesainkomputer;

public class Model {
    private String judul;
    private String keterangan;
    private String jadwal;
    private int foto;

    public Model() {
    }

    public Model(String judul, String keterangan, String jadwal, int foto) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.jadwal = jadwal;
        this.foto = foto;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
