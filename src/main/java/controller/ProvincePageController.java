package controller;

import DAO.ICountryRepository;
import model.Country;
import model.Product;
import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ICRUDService;
import service.IProvinceService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProvincePageController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    IProvinceService provinceService;
    @Autowired
    ICountryRepository countryRepository;

//    public Iterable<Province> provinceListEscGDP(){
//        return provinceService.findProvinceOrderByGDPAsc();
//    }
//
//    @ModelAttribute("provinces")
//    public Iterable<Province> provinceList() {
//        return provinceService.findAll();
//    }

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryRepository.findAll();
    }

    @ModelAttribute("newProvince")
    public Province newProvince() {
        return new Province();
    }

    @GetMapping("/Province")
    public String provinceListPage(Model model) {
        model.addAttribute("provinces",provinceService.findAll());
        return "adminView/ListProvince";
    }

    @GetMapping("/Province/AscGDP")
    public String provinceListEscGDP(Model model) {
        model.addAttribute("provinces",provinceService.findProvinceOrderByGDPAsc());
        return "adminView/ListProvince";
    }

    @GetMapping("/Province/View/{id}")
    public String viewProvince(@PathVariable("id") Long id,Model model){
        model.addAttribute("provinces",provinceService.findById(id).get());
        return"adminView/ListProvince";
    }

    @GetMapping("/Province/Delete/{id}")
    public String deleteProvince(@PathVariable("id") Long id){
        provinceService.deleteById(id);
        return"redirect:http://localhost:8080/Province";
    }
    @GetMapping("/Province/Edit/{id}")
    public String editProvince(@PathVariable("id") Long id,Model model){
        model.addAttribute("displayEdit",true);
        model.addAttribute("provinceEdit",provinceService.findById(id).get());
        model.addAttribute("provinces",provinceService.findAll());
        return"adminView/ListProvince";
    }

    @PostMapping("/Province")
    public String addNewProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes) {
        setImageOfCar(province);
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create Successfully!");
        return "redirect:http://localhost:8080/Province";
    }
    @PostMapping("/Province/Edit/{id}")
    public String confirmProvince(@PathVariable("id") Long id ,@ModelAttribute Province province,
                                  RedirectAttributes redirectAttributes){
        provinceService.updateById(province);
        redirectAttributes.addFlashAttribute("message", "edit Successfully!");
        return "redirect:http://localhost:8080/Province";
    }

    private void setImageOfCar(Province province) {
        MultipartFile image = province.getImage();
        String imageUrl = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload + image.getOriginalFilename()));
        } catch (IOException ex) {
            System.err.println("Error");
        }
        province.setPicture_province(imageUrl);
    }

}
