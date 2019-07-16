package com.example.asmaulhusna.Model;

public class ModelAsmaulHusna {
    String nomor, nama, arti, gambar,suara,kisah,kisahGambar, penjelasan, judulkisah,id,score;
    String no,soal,jawaban,jawabana,jawabanb,jawabanc,jawaband;

    public ModelAsmaulHusna() {

    }

    public ModelAsmaulHusna(String no,String soal,String jawaban,String jawabana,String jawabanb,String jawabanc,String jawaband){
        this.no=no;
        this.soal=soal;
        this.jawaban=jawaban;
        this.jawabana=jawabana;
        this.jawabanb=jawabanb;
        this.jawabanc=jawabanc;
        this.jawaband=jawaband;
    }
    public ModelAsmaulHusna(String score){
        this.score=score;
    }
    public ModelAsmaulHusna(String nomor,String nama,String arti,String gambar,String suara,String kisah,String kisahGambar,String penjelasan,String judulkisah){
        this.nomor=nomor;
        this.nama=nama;
        this.arti=arti;
        this.gambar=gambar;
        this.suara=suara;
        this.kisah=kisah;
        this.kisahGambar=kisahGambar;
        this.penjelasan=penjelasan;
        this.judulkisah=judulkisah;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getSuara() {
        return suara;
    }

    public void setSuara(String suara) {
        this.suara = suara;
    }

    public String getKisah() {
        return kisah;
    }

    public void setKisah(String kisah) {
        this.kisah = kisah;
    }

    public String getKisahGambar() {
        return kisahGambar;
    }

    public void setKisahGambar(String kisahGambar) {
        this.kisahGambar = kisahGambar;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getJudulkisah() {
        return judulkisah;
    }

    public void setJudulkisah(String judulkisah) {
        this.judulkisah = judulkisah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getJawabana() {
        return jawabana;
    }

    public void setJawabana(String jawabana) {
        this.jawabana = jawabana;
    }

    public String getJawabanb() {
        return jawabanb;
    }

    public void setJawabanb(String jawabanb) {
        this.jawabanb = jawabanb;
    }

    public String getJawabanc() {
        return jawabanc;
    }

    public void setJawabanc(String jawabanc) {
        this.jawabanc = jawabanc;
    }

    public String getJawaband() {
        return jawaband;
    }

    public void setJawaband(String jawaband) {
        this.jawaband = jawaband;
    }
}
