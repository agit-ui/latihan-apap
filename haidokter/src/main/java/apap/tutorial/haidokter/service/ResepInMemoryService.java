package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ResepDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResepInMemoryService implements ResepService {

    @Autowired
    private  ResepDb resepDb;

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
    public ResepModel updateResep(ResepModel resep) {
        return null;
    }

    @Override
    public void deleteResep(ResepModel resep) {
        resepDb.delete(resep);
    }

}
