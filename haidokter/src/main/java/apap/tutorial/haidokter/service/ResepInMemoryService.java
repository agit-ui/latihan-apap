package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResepInMemoryService implements ResepService {
    private List<ResepModel> listResep;

    public ResepInMemoryService() {
        listResep= new ArrayList<>();
    }

    @Override
    public void addResep(ResepModel resep) {
        listResep.add(resep);
    }

    @Override
    public List<ResepModel> getResepList() {
        return listResep;
    }

    @Override
    public ResepModel getResepByNomorResep(Long noResep){
        for (ResepModel x: listResep){
            if(x.getNoResep() == noResep){
                return x;
            }
        }
        return null;
    }

    @Override
    public ResepModel updateCatatan(Long noResep, String catatan){
        for (ResepModel x: listResep){
            if(x.getNoResep() == noResep){
                    x.setCatatan(catatan);
                return x;
            }
        }
        return null;
    }

    @Override
    public ResepModel deleteResep(Long noResep){
        for (ResepModel x: listResep){
            if(x.getNoResep() == noResep){
                    x.setCatatan(null);
                    x.setNoResep(null);
                    x.setNamaDokter(null);
                    x.setNamaPasien(null);
                return x;
            }
        }
        return null;
    }
}
