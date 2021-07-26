package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class ResepController {
    @Autowired
    private ResepService resepService;

    @RequestMapping("/resep/add")
    public String addResep(
            @RequestParam(value = "noResep", required = true) Long noResep,
            @RequestParam(value = "namaDokter", required = true) String namaDokter,
            @RequestParam(value = "namaPasien", required = true) String namaPasien,
            @RequestParam(value = "catatan", required = true) String catatan,
            Model model
    ){
        ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

        resepService.addResep(resep);

        model.addAttribute("nomorResep", noResep);
        return "add-resep";
    }

    @RequestMapping("/resep/viewall")
    public String detailResep(Model model){
            List<ResepModel> listResep = resepService.getResepList();

            model.addAttribute("listResep", listResep);

            return "viewall-resep";
    }

    @RequestMapping("/resep/view")
    public String detailResep(
            @RequestParam(value = "noResep") Optional<Long> noResep,
            Model model
    ){
        if(noResep.isPresent()){
            ResepModel resep = resepService.getResepByNomorResep(noResep.get());

            model.addAttribute("resep", resep);
        } else{
            model.addAttribute("msg", "Silahkan isi nomor Resep terlebih dahulu");
        }

        return "view-resep";
    }

    @RequestMapping(value = {
            "/resep/view/no-resep/{noResep}",
            "/resep/view/no-resep"
    })
    public String detailResepWithPathVariable(
            @PathVariable(value = "noResep") Optional<Long> noResep,
            Model model
    ){
        if(noResep.isPresent()){
            ResepModel resep = resepService.getResepByNomorResep(noResep.get());

            model.addAttribute("resep", resep);

        } else{
            model.addAttribute("msg", "Silahkan isi nomor Resep terlebih dahulu");
        }

        return "view-resep";
    }

    @RequestMapping(value = {
            "/resep/update/no-resep/{noResep}/catatan/{catatan}",
            "/resep/update/no-resep/catatan/{catatan}",
            "/resep/update/no-resep/{noResep}/catatan",
            "/resep/update/catatan/{catatan}",
            "/resep/update/no-resep/{noResep}",
            "/resep/update"
    })
    public String updateCatatan(
            @PathVariable(value = "noResep") Optional<Long> noResep,
            @PathVariable(value = "catatan") Optional<String> catatan,
            Model model
    ){
        if (noResep.isPresent() && catatan.isPresent()) {
            ResepModel resepUpdate = resepService.updateCatatan(noResep.get(), catatan.get());

            model.addAttribute("resep", resepUpdate);

        } else if (noResep.isEmpty() && catatan.isPresent()) {
            model.addAttribute("msg", "Silahkan isi nomor Resep terlebih dahulu");
        } else if (catatan.isEmpty() && noResep.isPresent()) {
            model.addAttribute("msg", "Silahkan isi catatan terlebih dahulu");
        } else {
            model.addAttribute("msg", "Silahkan isi nomor resep & catatan terlebih dahulu");
        }

        return "update-catatan";
    }

    @RequestMapping(value = {
            "/resep/delete/no-resep/{noResep}",
            "/resep/delete/no-resep",
            "/resep/delete"
    })
    public String deleteResep(
            @PathVariable(value = "noResep") Optional<Long> noResep,
            Model model
    ){
        if(noResep.isPresent()){
            ResepModel resep = resepService.deleteResep(noResep.get());

            model.addAttribute("resep", resep);
        } else{
            model.addAttribute("msg", "Silahkan isi nomor Resep terlebih dahulu");
        }

        return "delete-resep";
    }
}