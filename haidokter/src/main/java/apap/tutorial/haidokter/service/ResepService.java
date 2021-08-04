package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.util.List;

public interface ResepService {

    void addResep(ResepModel resep);

    void deleteResep(ResepModel resep) throws Exception;

    List<ResepModel> getResepList();

    ResepModel getResepByNomorResep(Long noResep);

    ResepModel updateResep(ResepModel resepModel);

}
