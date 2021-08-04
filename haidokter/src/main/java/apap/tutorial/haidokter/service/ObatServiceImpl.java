package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObatServiceImpl implements  ObatService {
    @Autowired
    ObatDb obatDb;

    @Override
    public void addObat(ObatModel obat){
        obatDb.save(obat);
    }

    @Override
    public ObatModel updateObat(ObatModel obat){
        obatDb.save(obat);

        return obat;
    }

    @Override
    public ObatModel getObatById(Long idObat){
        return obatDb.findById(idObat).get();
    }

    @Override
    public void deleteObat(ObatModel obat){
        obatDb.delete(obat);
    }
}