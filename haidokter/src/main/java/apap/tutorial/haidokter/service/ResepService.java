package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;
import java.util.Optional;

public interface ResepService {
    void addResep(ResepModel resep);

    List<ResepModel> getResepList();

    ResepModel getResepByNomorResep(Long noResep);

    ResepModel updateCatatan(Long noResep, String catatan);

    ResepModel deleteResep(Long noResep);
}
