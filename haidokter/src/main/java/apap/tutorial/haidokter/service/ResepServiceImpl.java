package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ResepDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResepServiceImpl implements ResepService {

    @Autowired
    private  ResepDb resepDb;

    @Override
    public void addResep(ResepModel resep){
        resepDb.save(resep);
    }

    @Override
    public List<ResepModel> getResepList() { return resepDb.findAll(); }

    @Override
    public ResepModel getResepByNomorResep(Long noResep) { return resepDb.findByNoResep(noResep).get(); }

    @Override
    public ResepModel updateResep(ResepModel resep) {
        resepDb.save(resep);

        return resep;
    }

    @Override
    public void deleteResep(ResepModel resep) throws Exception {
        if(resep.getListObat().isEmpty()){
            resepDb.delete(resep);
        } else {
            throw new Exception("Resep tidak bisa dihapus karena memiliki obat.");
        }
    }

}
