package apap.tutorial.haidokter.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "resep")
public class ResepModel implements Serializable {
    @Id
    @Column(name = "no_resep")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noResep;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_dokter", nullable = false)
    private String namaDokter;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_pasien", nullable = false)
    private String namaPasien;

    @NotNull
    @Size(max = 40)
    @Column(name = "catatan", nullable = false)
    private String catatan;

    @OneToMany(mappedBy = "resepModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ObatModel> listObat;

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

    public List<ObatModel> getListObat() { return listObat; }

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

    public void setListObat(List<ObatModel> listObat) {
        this.listObat = listObat;
    }
}
