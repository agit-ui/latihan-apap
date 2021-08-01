package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;

import java.util.List;

public interface ObatService {

    void addObat(ObatModel obat);

    void deleteObat(ObatModel obat);

    ObatModel updateObat(ObatModel obat);

    ObatModel getObatById(Long idObat);

}
