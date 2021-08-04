package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepService;
import apap.tutorial.haidokter.service.ObatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class ResepController {
    @Qualifier("resepServiceImpl")
    @Autowired
    private ResepService resepService;

    @Autowired
    private ObatService obatService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/resep/add")
    public String addResepFormPage(Model model) {
        model.addAttribute("resep", new ResepModel());

        return "form-add-resep";
    }

    @PostMapping("/resep/add")
    public String addResepSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        resepService.addResep(resep);
        model.addAttribute("nomorResep", resep.getNoResep());

        return "add-resep";
    }

    @GetMapping("/resep/change/{noResep}")
    private String changeResepFormPage(
            @PathVariable Long noResep,
            Model model
    ) {
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("resep", resep);

        return "form-update-resep";
    }

    @PostMapping("/resep/change")
    private String changeResepFormSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        ResepModel updateResep = resepService.updateResep(resep);
        model.addAttribute("resep", updateResep.getNoResep());

        return "update-resep";
    }

    @GetMapping("/resep/view")
    public String viewDetailResep(
            @RequestParam(value = "noResep") Long noResep,
            Model model
    ) {

        String pesan;
        try{
            resepService.getResepByNomorResep(noResep);
        } catch (NoSuchElementException e){
            pesan = "Nomor Resep tidak ditemukan! Silakan teliti kembali";
            model.addAttribute("pesan", pesan);
            return "error-all";
        }

        ResepModel resep = resepService.getResepByNomorResep(noResep);
        List<ObatModel> listObat = resep.getListObat();

        model.addAttribute("resep", resep);
        model.addAttribute("listObat", listObat);

        return "view-resep";
    }

    @RequestMapping("/resep/viewall")
    public String detailResep(Model model){
        List<ResepModel> listResep = resepService.getResepList();

        model.addAttribute("listResep", listResep);

        return "viewall-resep";
    }

    @RequestMapping("/resep/delete/{noResep}")
    public String deleteResep(
            @PathVariable Long noResep,
            Model model
    ) throws Exception {
        String pesan;
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        try {
            resepService.deleteResep(resep);
            pesan = "Resep Berhasil dihapus";
        } catch (Exception e){
            pesan = e.getMessage();
        }
        model.addAttribute("pesan", pesan);

        return "delete-resep";
    }

}