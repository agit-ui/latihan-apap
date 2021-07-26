package apap.tutorial.haidokter.model;

public class ResepModel {
    private Long noResep;
    private String namaDokter;
    private String namaPasien;
    private String catatan;

    public ResepModel(Long noResep, String namaDokter, String namaPasien, String catatan) {
        this.noResep = noResep;
        this.namaDokter = namaDokter;
        this.namaPasien = namaPasien;
        this.catatan = catatan;
    }

    public Long getNoResep() {
        return noResep;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setNoResep(Long noResep) {
        this.noResep = noResep;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public void clear(){ }
}
